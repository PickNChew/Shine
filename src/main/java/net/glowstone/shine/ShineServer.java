package net.glowstone.shine;

import com.sun.net.httpserver.HttpServer;
import net.glowstone.shine.api.Server;
import net.glowstone.shine.api.http.ContextManager;
import net.glowstone.shine.http.ShineContextManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public class ShineServer implements Server {

    private final int port;
    private final Logger logger;
    private final ContextManager contextManager;
    private HttpServer server;

    private ShineServer(int port) throws IOException {
        this.port = port;
        this.logger = Logger.getLogger("Shine");
        startServer();
        this.contextManager = new ShineContextManager(this);
    }

    private void startServer() throws IOException {
        getLogger().info("Starting Shine server on port " + this.port + "...");
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        this.server.start();
        logger.info("Server started.");
    }

    @Override
    public void shutdown() {
        System.exit(0);
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public HttpServer getHttpServer() {
        return this.server;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public ContextManager getContextManager() {
        return contextManager;
    }

    public static void main(String[] args) throws IOException {
        ShineServer server = new ShineServer(1475);
    }
}
