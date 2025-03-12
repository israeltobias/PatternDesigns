package es.patterndesingns.behavioralpatterns.template.networks;

public abstract class Network {

    String userName;
    String password;

    Network() {
        super();
    }

    /**
     * Publish the data to whatever network.
     */
    public void post(String message) {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.userName, this.password)) {
            // Send the post data.
            sendData(message.getBytes());
            logOut();
        }
    }

    abstract boolean logIn(String userName, String password);
    abstract void sendData(byte[] data);
    abstract void logOut();
}
