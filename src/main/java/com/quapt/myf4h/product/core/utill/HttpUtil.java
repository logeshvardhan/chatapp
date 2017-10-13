package com.quapt.myf4h.product.core.utill;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public enum HttpUtil {
    INSTANCE;

    public static final String CONTENT_TYPE_JSON = "application/json";

    public Cookie getHttpOnlyCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        return cookie;
    }

    public Optional<String> readCookie(HttpServletRequest request, String name) {

        String token = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Optional<Cookie> myCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(name))
                    .findFirst();

            if (myCookie.isPresent()) {
                token = myCookie.get().getValue();
            }
        }

        return Optional.ofNullable(token);
    }
    
    /*public Optional<String> resetCookie(HttpServletRequest request, String name) {

        String token = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Optional<Cookie> myCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(name))
                    .findFirst();

            if (myCookie.isPresent()) {
                token = myCookie.get().getValue();
            }
        }

        return Optional.ofNullable(token);
    }*/

    public void produceJson(HttpServletResponse response) {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(CONTENT_TYPE_JSON);
    }

    /**
     * This will check if request is for state change.
     * 
     * <p>
     * Note: don't add GET request to the list, it means you are failing REST design.
     * </p>
     * 
     * @param request the request to verify.
     * @return 'true' if request is for state change.
     */
    public boolean isStateChangeRequest(HttpServletRequest request) {
        Pattern stateChangeMethods = Pattern.compile("^(PUT|POST|DELETE)$");

        return stateChangeMethods.matcher(request.getMethod()).matches();
    }
}
