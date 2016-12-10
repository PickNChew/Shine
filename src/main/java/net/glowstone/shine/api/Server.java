package net.glowstone.shine.api;

import com.sun.net.httpserver.HttpServer;
import net.glowstone.shine.api.http.ContextManager;

import java.util.logging.Logger;

public interface Server {

    void shutdown();

    Logger getLogger();

    HttpServer getHttpServer();

    int getPort();

    ContextManager getContextManager();

}
