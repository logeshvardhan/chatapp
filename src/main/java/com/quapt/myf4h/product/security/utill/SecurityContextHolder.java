package com.quapt.myf4h.product.security.utill;

import java.util.Optional;

import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.core.InheritableSecurityContext;
import com.quapt.myf4h.product.security.core.SecurityContext;

/**
 * 
 * @author sabir
 *
 *         <p>
 *         Note: inspired by spring LocaleContextHolder
 *         </p>
 */
public enum SecurityContextHolder {

    INSTANCE;

    private ThreadLocal<Realm> securityContext = new SecurityContext();

    private ThreadLocal<Realm> inheritableSecurityContext = new InheritableSecurityContext();

    public void setRealm(Realm realm) {
        setRealm(realm, false);
    }

    public void setRealm(Realm realm, boolean inheritable) {
        if (inheritable) {
            inheritableSecurityContext.set(realm);
            securityContext.remove();
        } else {
            securityContext.set(realm);
            inheritableSecurityContext.remove();
        }
    }

    public Optional<Realm> getRealm() {
        Realm realm = securityContext.get();

        if (realm == null) {
            realm = inheritableSecurityContext.get();
        }

        return Optional.ofNullable(realm);
    }
}
