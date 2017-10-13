package com.quapt.myf4h.product.rest.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quapt.myf4h.product.core.response.RestResponse;
import com.quapt.myf4h.product.core.type.ResponseType;
import com.quapt.myf4h.product.security.utill.SecurityContextHolder;

@RestController
@RequestMapping("/services/v1/users")
public class UserController {

    @RequestMapping("/email")
    public RestResponse<String> getEmail() {
        String email = SecurityContextHolder.INSTANCE.getRealm().get().getEmail();

        return new RestResponse<String>(ResponseType.SUCCESS, email);
    }

}
