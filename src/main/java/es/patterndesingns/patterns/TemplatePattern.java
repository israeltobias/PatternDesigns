package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.template.networks.Facebook;
import es.patterndesingns.behavioralpatterns.template.networks.Network;
import es.patterndesingns.behavioralpatterns.template.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemplatePattern {

    TemplatePattern() {
        super();
    }

    public static void execute() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("""
                Choose social network for posting message.
                1 - Facebook
                2 - Twitter
                """);
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        assert network != null;
        network.post(message);
    }
}
