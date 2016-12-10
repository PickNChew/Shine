package net.glowstone.shine.http;

import net.glowstone.shine.api.Server;
import net.glowstone.shine.api.http.Context;
import net.glowstone.shine.api.http.ContextManager;
import net.glowstone.shine.http.context.BaseContext;

import java.util.Arrays;
import java.util.List;

public class ShineContextManager implements ContextManager {

    private final Server server;

    public ShineContextManager(Server server) {
        this.server = server;
        init();
    }

    private final void init() {
        List<Context> contexts = Arrays.asList(new BaseContext(server));
        for (Context context : contexts) {
            this.server.getHttpServer().createContext(context.getPath(), context.getHandler());
        }
    }
}
