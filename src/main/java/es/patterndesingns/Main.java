package es.patterndesingns;

import es.patterndesingns.creationalpatterns.abstractfactory.factories.LinuxFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.MacOsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.WindowsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.app.Application;
import es.patterndesingns.creationalpatterns.builder.builders.CarBuilder;
import es.patterndesingns.creationalpatterns.builder.builders.CarManualBuilder;
import es.patterndesingns.creationalpatterns.builder.cars.Car;
import es.patterndesingns.creationalpatterns.builder.cars.Manual;
import es.patterndesingns.creationalpatterns.builder.director.Director;
import es.patterndesingns.creationalpatterns.factorymethod.factory.Dialog;
import es.patterndesingns.creationalpatterns.factorymethod.factory.HtmlDialog;
import es.patterndesingns.creationalpatterns.factorymethod.factory.WindowsDialog;
import es.patterndesingns.structuralpatterns.adapter.adapters.SquarePegAdapter;
import es.patterndesingns.structuralpatterns.adapter.round.RoundHole;
import es.patterndesingns.structuralpatterns.adapter.round.RoundPeg;
import es.patterndesingns.structuralpatterns.adapter.square.SquarePeg;
import es.patterndesingns.structuralpatterns.bridge.devices.Device;
import es.patterndesingns.structuralpatterns.bridge.devices.Radio;
import es.patterndesingns.structuralpatterns.bridge.devices.Tv;
import es.patterndesingns.structuralpatterns.bridge.remotes.AdvancedRemote;
import es.patterndesingns.structuralpatterns.bridge.remotes.BasicRemote;
import es.patterndesingns.structuralpatterns.composite.editor.ImageEditor;
import es.patterndesingns.structuralpatterns.composite.shapes.Circle;
import es.patterndesingns.structuralpatterns.composite.shapes.CompoundShape;
import es.patterndesingns.structuralpatterns.composite.shapes.Dot;
import es.patterndesingns.structuralpatterns.composite.shapes.Rectangle;

import java.awt.*;


public class Main {

    //Abstract factory pattern
    public static void abstractFactory() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else if (osName.contains("linux")) {
            factory = new LinuxFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        app.paint();
    }

    //Adapter pattern
    public static void adapter() {
        // Round fits into round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rPeg = new RoundPeg(5);
        if (hole.fits(rPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }

    //Builder pattern
    public static void builder() {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.print());


        CarManualBuilder manualBuilder = new CarManualBuilder();
        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        CarBuilder cityCarBuilder = new CarBuilder();
        director.constructCityCar(cityCarBuilder);
        Car cityCar = cityCarBuilder.getResult();
        System.out.println("\nCity car built:\n" + cityCar.print());

        CarManualBuilder suvBuilder = new CarManualBuilder();
        director.constructSUV(suvBuilder);
        Manual suv = suvBuilder.getResult();
        System.out.println("\nSUV manual built:\n" + suv.print());
    }

    //Bridge pattern
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void bridge() {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    //factory method pattern

    public static void factoryMethod() {
        Dialog dialog;
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
        dialog.renderWindow();
    }

    //Composite pattern

    public static void composite(boolean active) {
        if(active) {
            ImageEditor editor = new ImageEditor();

            editor.loadShapes(
                    new Circle(10, 10, 10, Color.BLUE),

                    new CompoundShape(
                            new Circle(110, 110, 50, Color.RED),
                            new Dot(160, 160, Color.RED)
                    ),

                    new CompoundShape(
                            new Rectangle(250, 250, 100, 100, Color.GREEN),
                            new Dot(240, 240, Color.GREEN),
                            new Dot(240, 360, Color.GREEN),
                            new Dot(360, 360, Color.GREEN),
                            new Dot(360, 240, Color.GREEN)
                    ),

                    new Circle(80, 190, 25, Color.ORANGE)
            );
        } else {
            System.out.println("Composite: no executed.");
        }
    }

    public static void main(String[] args) {

        System.out.println("---- Abstract factory pattern. ----");
        abstractFactory();

        System.out.println("---- Adapter pattern. ----");
        adapter();

        System.out.println("---- Builder pattern. ----");
        builder();

        System.out.println("---- Bridge pattern. ----");
        bridge();

        System.out.println("---- Factory method pattern. ----");
        factoryMethod();

        System.out.println("---- Composite pattern. ----");
        composite(true);

    }
}