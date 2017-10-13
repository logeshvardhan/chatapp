package com.quapt.myf4h.product.security.core;

import com.quapt.myf4h.product.core.exception.ApplicationException;

public class SecurityException extends ApplicationException {

    /**
     * 
     */
    private static final long serialVersionUID = 6718719119222371150L;

    public SecurityException(String code) {
        super(code);
    }

    public SecurityException(String code, Object[] args) {
        super(code, args);
    }

    public SecurityException(Throwable throwable, String code) {
        super(throwable, code);
    }

    public SecurityException(Throwable throwable, String code, Object[] args) {
        super(throwable, code, args);
    }
}
