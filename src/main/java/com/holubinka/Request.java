package com.holubinka;

import java.util.Objects;

public class Request {

    private final String method;
    private final String uri;

    public Request(String method, String uri) {
        this.method = method;
        this.uri = uri;
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
