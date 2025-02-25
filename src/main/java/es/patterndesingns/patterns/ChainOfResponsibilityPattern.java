package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.chainofresponsibility.middleware.Middleware;
import es.patterndesingns.behavioralpatterns.chainofresponsibility.middleware.RoleCheckMiddleware;
import es.patterndesingns.behavioralpatterns.chainofresponsibility.middleware.ThrottlingMiddleware;
import es.patterndesingns.behavioralpatterns.chainofresponsibility.middleware.UserExistsMiddleware;
import es.patterndesingns.behavioralpatterns.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChainOfResponsibilityPattern {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private ChainOfResponsibilityPattern() {
    }
    private static void init() {
        server = new Server();
        System.out.println("admin@example.com:admin_pass");
        System.out.println("user@example.com:user_pass");
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void execute(boolean execute) throws IOException {
        init();
        if (execute) {
            boolean success;
            do {
                System.out.print("Enter email: ");
                String email = reader.readLine();
                System.out.print("Input password: ");
                String password = reader.readLine();
                success = server.logIn(email, password);
            } while (!success);
        }else{
            System.out.println("Chain Of Responsibility: no executed.");
        }
    }
}
