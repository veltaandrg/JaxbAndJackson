package restdemo;

import org.eclipse.jetty.server.*;

public class RestServer {

    public static void main(String... args) {
        new RestServer().run();
    }
    
    public void run() {
        Server server = new Server(8080);
        server.setHandler(new ProductHandler());
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
