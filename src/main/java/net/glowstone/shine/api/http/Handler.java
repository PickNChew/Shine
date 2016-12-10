package net.glowstone.shine.api.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public abstract class Handler implements HttpHandler {

    @Override
    public final void handle(HttpExchange httpExchange) throws IOException {
        Exchange exchange = new Exchange(httpExchange);
        handle(exchange);
        if (!exchange.isClosed()) {
            exchange.close();
        }
    }

    public abstract void handle(Exchange exchange);
}
