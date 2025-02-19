package es.patterndesingns.creationalpatterns.singleton.threads;

import es.patterndesingns.creationalpatterns.singleton.Singleton;
import es.patterndesingns.creationalpatterns.singleton.SingletonSecurity;

public class ThreadBar implements Runnable{
    private boolean isSecured;

    public ThreadBar(boolean security) {
        this.isSecured = security;
    }

    public boolean isSecured() {
        return isSecured;
    }

    @Override
    public void run() {
        String name = "BAR";
        if(!isSecured()) {
            Singleton singleton = Singleton.getInstance(name);
            System.out.println(singleton.getValue());
        }
        else {
            SingletonSecurity singletonSecurity = SingletonSecurity.getInstance(name);
            System.out.println(singletonSecurity.getValue());
        }
    }
}
