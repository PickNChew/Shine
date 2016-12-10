package net.glowstone.shine.api.http;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.nio.charset.Charset;

public class Exchange {

    private final HttpExchange exchange;
    private boolean closed = false;

    public Exchange(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public Exchange respond(int code) {
        return respond(code, new byte[0]);
    }

    public Exchange respond(int code, String data) {
        if (data == null) {
            return respond(code, new byte[0]);
        }
        return respond(code, data.getBytes(Charset.forName("UTF-8")));
    }

    public Exchange respond(int code, byte[] data) {
        try {
            getExchange().sendResponseHeaders(code, data.length);
            getExchange().getResponseBody().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Exchange header(String title, String content) {
        getExchange().getRequestHeaders().add(title, content);
        return this;
    }

    public void close() {
        try {
            getExchange().getResponseBody().close();
            closed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isStatic() {
        return getExchange().getRequestURI().toString().equals(getExchange().getHttpContext().getPath());
    }

    public boolean isClosed() {
        return closed;
    }

    public HttpExchange getExchange() {
        return exchange;
    }
}
