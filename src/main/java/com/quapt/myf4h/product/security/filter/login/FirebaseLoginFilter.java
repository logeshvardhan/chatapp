package com.quapt.myf4h.product.security.filter.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.tasks.OnFailureListener;
import com.google.firebase.tasks.OnSuccessListener;
import com.quapt.myf4h.product.security.LoginResult;
import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.config.FirebaseConfig;
import com.quapt.myf4h.product.security.config.LoginConfig;
import com.quapt.myf4h.product.security.core.AuthenticationException;
import com.quapt.myf4h.product.security.core.LoginFilter;
import com.quapt.myf4h.product.security.core.RoleService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirebaseLoginFilter extends LoginFilter {
    private static final Logger LOG = LoggerFactory.getLogger(FirebaseLoginFilter.class);

    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private FirebaseConfig firebaseConfig;

    private boolean initialized = false;

    @Override
    public void initFilterBean() throws ServletException {
        if (!initialized) {
            try {            	
            	FirebaseOptions options = new FirebaseOptions.Builder()
            			.setServiceAccount(new FileInputStream(firebaseConfig.getServiceAccountKey()))
            			.setDatabaseUrl(firebaseConfig.getDatabaseUrl()).build();                        
                FirebaseApp.initializeApp(options);
                initialized = true;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            super.initFilterBean();
        }
    }

    @Override
    public Optional<LoginResult> attemptLogin(ServletRequest request, ServletResponse response) {
        if (!initialized) {
            throw new AuthenticationException("l2e.login.firebase.app.not.init");
        }

        String token = request.getParameter(loginConfig.getTokenParameter());

        if (LOG.isDebugEnabled()) {
            LOG.debug("TOKEN GOT: " + token);
        }

        Assert.hasText(token);

        final LoginResult result = new LoginResult();
        final CountDownLatch latch = new CountDownLatch(1);

        FirebaseAuth.getInstance().verifyIdToken(token).addOnSuccessListener(new OnSuccessListener<FirebaseToken>() {
            public void onSuccess(FirebaseToken firebaseToken) {
                Realm realm = new Realm().setUserId(firebaseToken.getUid()).setEmail(firebaseToken.getEmail())
                        .setAuthenticated(true);
                result.setSuccess(token, realm);
                latch.countDown();
            };
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(Exception ex) {
                latch.countDown();
                LOG.error(ex.getLocalizedMessage(), ex);
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            LOG.error("Wait for verification interrupted.", e);
        }

        return Optional.ofNullable(result);
    }

    public FirebaseLoginFilter setRoleService(RoleService roleService) {
        this.roleService = roleService;
        return this;
    }
}
