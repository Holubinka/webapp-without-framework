package com.holubinka.web;

import java.util.Map;
import java.util.Objects;

public class Request {

    private final String method;
    private final String uri;
    private Map<String, String[]> params;

    private Request(String method, String uri, Map<String, String[]> params) {
        this.method = method;
        this.uri = uri;
        this.params = params;
    }

    private Request(String method, String uri) {
        this.method = method;
        this.uri = uri;
    }

    public static Request of(String method, String uri, Map<String, String[]> params) {
        return new Request(method, uri, params);
    }

    public static Request of(String method, String uri) {
        return new Request(method, uri);
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String[] getParam(String name) {
        return params.get(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(method, request.method) &&
                Objects.equals(uri, request.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri);
    }
}
