package com.quapt.myf4h.product.rest.resources;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quapt.myf4h.product.core.response.RestResponse;
import com.quapt.myf4h.product.core.type.ResponseType;
import com.quapt.myf4h.product.security.utill.SecurityContextHolder;

@RestController
@RequestMapping("/login/firebase/user")
public class LoginHandler {

    private SecurityContextHolder securityContextHolder = SecurityContextHolder.INSTANCE;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<Object> handle() {
        RestResponse<Object> response = null;

        if (securityContextHolder.getRealm().isPresent()) {
            response = new RestResponse<Object>(ResponseType.SUCCESS, securityContextHolder.getRealm().get());
        } else {
            response = new RestResponse<Object>(ResponseType.ERROR, "");
        }

        return response;
    }
}
