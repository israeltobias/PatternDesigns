package es.patterndesingns.creationalpatterns.singleton.threads;

import es.patterndesingns.creationalpatterns.singleton.Singleton;
import es.patterndesingns.creationalpatterns.singleton.SingletonSecurity;

public class ThreadFoo implements Runnable{
    private boolean isSecured;

    public ThreadFoo(boolean security) {
        this.isSecured = security;
    }

    public boolean isSecured() {
        return isSecured;
    }

    @Override
    public void run() {
        String name = "FOO";
        if(isSecured()) {
            Singleton singleton = Singleton.getInstance(name);
            System.out.println(singleton.getValue());
        }
        else {
            SingletonSecurity singletonSecurity = SingletonSecurity.getInstance(name);
            System.out.println(singletonSecurity.getValue());
        }

    }
}
