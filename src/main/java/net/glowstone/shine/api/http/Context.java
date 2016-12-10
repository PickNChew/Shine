package net.glowstone.shine.api.http;

import com.sun.net.httpserver.*;
import net.glowstone.shine.api.Server;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Context extends HttpContext {

    private final String path;
    private Handler handler;
    private final Server server;

    public Context(Server server, String path) {
        this.server = server;
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public HttpHandler getHandler() {
        return handler;
    }

    @Override
    public HttpServer getServer() {
        return server.getHttpServer();
    }

    @Override
    public Authenticator getAuthenticator() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Collections.emptyMap();
    }

    @Override
    public List<Filter> getFilters() {
        return Collections.emptyList();
    }

    @Override
    public Authenticator setAuthenticator(Authenticator authenticator) {
        return null;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPath(String path) {
    }

    public void setServer(Server server) {
    }

    @Deprecated
    @Override
    public final void setHandler(HttpHandler handler) {
    }
}
