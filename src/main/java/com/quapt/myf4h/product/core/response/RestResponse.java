package com.quapt.myf4h.product.core.response;

import com.quapt.myf4h.product.core.type.ResponseType;

/**
 * Standard response for REST calls.
 * 
 * @author sabir
 *
 * @param <T> the response object type.
 */
public final class RestResponse<T> {

    private ResponseType result;

    private T object;

    public RestResponse(ResponseType result, T object) {
        this.result = result;
        this.object = object;
    }

    public ResponseType getResult() {
        return result;
    }

    public T getObject() {
        return object;
    }

}
