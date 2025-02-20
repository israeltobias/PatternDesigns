package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.singleton.Singleton;
import es.patterndesingns.creationalpatterns.singleton.threads.ThreadBar;
import es.patterndesingns.creationalpatterns.singleton.threads.ThreadFoo;
import es.patterndesingns.enums.SingletonEnum;

public class SingletonPattern {
    public static String txt = """
            If you see the same value, then singleton was reused (yay!)
            If you see different values, then 2 singletons were created (booo!!)
            RESULT:
            """;

    public static void execute(SingletonEnum type) {
        switch (type) {
            case SINGLETON -> executeSingleton();
            case SINGLETON_MULTITHREAD -> executeSingletonMultithread();
            case SINGLETON_MULTITHREAD_SECURITY -> executeSingletonMultithreadSecurity();
            default -> executeSingleton();
        }
    }

    private static void executeSingleton() {
        System.out.println("** Singleton: " + txt);
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.getValue());
        System.out.println(anotherSingleton.getValue());
        System.out.println();
    }

    private static void executeSingletonMultithread () {
        System.out.println("** Singleton multithread: " + txt);
        createTheeads(false);
    }

    private static void executeSingletonMultithreadSecurity (){
        System.out.println("** Singleton multithread security: " + txt);
        createTheeads(true);
    }

    private static void  createTheeads(boolean isSecured) {
        Thread threadFoo = new Thread(new ThreadFoo(isSecured));
        Thread threadBar = new Thread(new ThreadBar(isSecured));
        threadFoo.start();
        threadBar.start();
    }
}
