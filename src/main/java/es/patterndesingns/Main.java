package es.patterndesingns;

import es.patterndesingns.enums.SingletonEnum;
import es.patterndesingns.patterns.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

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

        System.out.println("\n---- Facade pattern. ----");
        FacadePattern.execute();

        System.out.println("\n---- Flyweight pattern. ----");
        FlyweightPattern.execute(false);

        System.out.println("\n---- Proxy pattern. ----");
        ProxyPattern.execute();


        System.out.println("\n---- Chain of responsibility pattern. ----");
        ChainOfResponsibilityPattern.execute(false);

        System.out.println("\n---- Command pattern. ----");
        CommandPattern.execute(false);

        System.out.println("\n---- Iterator pattern. ----");
        IteratorPattern.execute(true);

        System.out.println("\n---- Mediator pattern. ----");
        MediatorPattern.execute(false);

        System.out.println("\n---- Memento pattern. ----");
        MementoPattern.execute(false);
    }
}