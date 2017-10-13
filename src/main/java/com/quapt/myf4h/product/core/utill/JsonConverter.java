package com.quapt.myf4h.product.core.utill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

public enum JsonConverter {

    INSTANCE;

    private ObjectMapper mapper = new ObjectMapper();

    public <T> Optional<String> getJson(T object) {
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(json);
    }

    public <T> Optional<T> getObject(String json, Class<T> clazz) {
        T object = null;

        try {
            object = mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(object);
    }
}
