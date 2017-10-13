package com.quapt.myf4h.product.security.core;

import com.quapt.myf4h.product.core.exception.ApplicationException;

public class AuthenticationException extends ApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = -2949478145674260082L;

    public AuthenticationException(String code) {
        super(code);
    }

    public AuthenticationException(String code, Object[] args) {
        super(code, args);
    }

    public AuthenticationException(Throwable throwable, String code) {
        super(throwable, code);
    }

    public AuthenticationException(Throwable throwable, String code, Object[] args) {
        super(throwable, code, args);
    }

}
