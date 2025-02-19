package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.singleton.Singleton;
import es.patterndesingns.creationalpatterns.singleton.threads.ThreadBar;
import es.patterndesingns.creationalpatterns.singleton.threads.ThreadFoo;

public class SingletonPattern {
    public static String txt = """
            If you see the same value, then singleton was reused (yay!)
            If you see different values, then 2 singletons were created (booo!!)
            RESULT:
            """;
    public static void executeSingleton() {
        System.out.println("** Singleton: " + txt);
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.getValue());
        System.out.println(anotherSingleton.getValue());
        System.out.println();
    }

    public static void executeSingletonMultithread () {
        System.out.println("** Singleton multithread: " + txt);
        createTrheads(false);
    }

    public static void executeSingletonMultithreadSecurity (){
        System.out.println("** Singleton multithread security: " + txt);
        createTrheads(true);
    }

    public static void  createTrheads(boolean isSecured) {
        Thread threadFoo = new Thread(new ThreadFoo(isSecured));
        Thread threadBar = new Thread(new ThreadBar(isSecured));
        threadFoo.start();
        threadBar.start();
    }
}
