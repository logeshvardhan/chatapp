package com.quapt.myf4h.product.core.exception;

import java.util.Optional;

/**
 * Unchecked exception, that can be raised by application other than business validation exception.
 * 
 * @author sabir
 *
 */
public class ApplicationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 2959993579764609473L;

    private String code;

    private Object[] args;

    public ApplicationException(String code) {
        super(code);
        this.code = code;
    }

    public ApplicationException(String code, Object[] args) {
        super(code);
        this.args = args;
        this.code = code;
    }

    public ApplicationException(Throwable throwable, String code) {
        super(code, throwable);
        this.code = code;
    }

    public ApplicationException(Throwable throwable, String code, Object[] args) {
        super(code, throwable);
        this.args = args;
        this.code = code;
    }

    public Optional<String> getCode() {
        return Optional.ofNullable(code);
    }

    public Optional<Object[]> getArgs() {
        return Optional.ofNullable(args);
    }
}
