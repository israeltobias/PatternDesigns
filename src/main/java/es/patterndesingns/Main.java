package es.patterndesingns;

import es.patterndesingns.patterns.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("---- Abstract factory pattern. ----");
        AbstractFactoryPattern.execute();

        System.out.println("\n---- Adapter pattern. ----");
        AdapterPattern.execute();

        System.out.println("\n---- Builder pattern. ----");
        BuilderPattern.execute();

        System.out.println("\n---- Bridge pattern. ----");
        BridgePattern.execute();

        System.out.println("\n---- Factory method pattern. ----");
        FactoryMethodPattern.execute();

        System.out.println("\n---- Composite pattern. ----");
        CompositePattern.execute(false);

        System.out.println("\n---- Prototype pattern. ----");
        PrototypePattern.execute();

        System.out.println("\n---- Decorator pattern. ----");
        DecoratorPattern.execute();

        System.out.println("\n---- Singleton pattern. ----");
        SingletonPattern.execute(SingletonEnum.SINGLETON);
      //  SingletonPattern.execute(SingletonEnum.SINGLETON_MULTITHREAD);
       // SingletonPattern.execute(SingletonEnum.SINGLETON_MULTITHREAD_SECURITY);
    }
}