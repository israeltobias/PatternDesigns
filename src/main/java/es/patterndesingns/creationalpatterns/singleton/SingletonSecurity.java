package es.patterndesingns.creationalpatterns.singleton;

public class SingletonSecurity {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile SingletonSecurity instance;

    private final String value;

    public static SingletonSecurity getInstance() {
        return instance;
    }

    public String getValue() {
        return value;
    }

    private SingletonSecurity(String value) {
        this.value = value;
    }

    public static SingletonSecurity getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
        SingletonSecurity result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonSecurity.class) {
            if (instance == null) {
                instance = new SingletonSecurity(value);
            }
            return instance;
        }
    }
}
