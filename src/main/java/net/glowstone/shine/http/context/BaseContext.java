package net.glowstone.shine.http.context;

import net.glowstone.shine.api.Server;
import net.glowstone.shine.api.http.Context;
import net.glowstone.shine.api.http.Exchange;
import net.glowstone.shine.api.http.Handler;

public class BaseContext extends Context {
    public BaseContext(Server server) {
        super(server, "/");
        setHandler(new BaseHandler(server));
    }

    private final class BaseHandler extends Handler {
        private final Server server;

        public BaseHandler(Server server) {
            this.server = server;
        }

        @Override
        public void handle(Exchange exchange) {
            if (exchange.isStatic()) {
                exchange.respond(200, "Shine repository.").close();
            } else {
                exchange.respond(404, "Not found.").close();
            }
        }
    }
}
