package es.patterndesingns;

import es.patterndesingns.creationalpatterns.abstractfactory.factories.LinuxFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.MacOsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.factories.WindowsFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.interfaces.GUIFactory;
import es.patterndesingns.creationalpatterns.abstractfactory.app.Application;
import es.patterndesingns.structuralpatterns.adapter.adapters.SquarePegAdapter;
import es.patterndesingns.structuralpatterns.adapter.round.RoundHole;
import es.patterndesingns.structuralpatterns.adapter.round.RoundPeg;
import es.patterndesingns.structuralpatterns.adapter.square.SquarePeg;

public class Main {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
       // osName= "windows 98";
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else if (osName.contains("linux")){
            factory = new LinuxFactory();
        } else {
            factory = new WindowsFactory();;
        }
        app = new Application(factory);
        return app;
    }

    public static void abstractFactory() {
        Application app = configureApplication();
        app.paint();
    }

    public static void adapter(){
        // Round fits round, no surprise.
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

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

    public static void main(String[] args) {

        System.out.println("---- Abstract factory pattern. ----");
        abstractFactory();

        System.out.println("---- Adapter pattern. ----");
        adapter();

    }
}