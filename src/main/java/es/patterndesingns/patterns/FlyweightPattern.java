package es.patterndesingns.patterns;

import es.patterndesingns.structuralpatterns.flyweight.forest.Forest;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlyweightPattern {
    static int canvasSize = 500;
    static int treesToDraw = 1000000;
    static int treeTypes = 2;

    private FlyweightPattern() {
    }

    public static void execute(boolean isActive) {
        if (isActive) {
            Forest forest = new Forest();
            for (int i = 0; i < treesToDraw / treeTypes; i++) {
                forest.plantTree(random(0, canvasSize), random(0, canvasSize),
                        "Summer Oak", Color.GREEN, "Oak texture stub");
                forest.plantTree(random(0, canvasSize), random(0, canvasSize),
                        "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
            }
            forest.setSize(canvasSize, canvasSize);
            forest.setVisible(true);


            System.out.println(treesToDraw + " trees drawn");
            System.out.println("---------------------");
            System.out.println("Memory usage:");
            System.out.println("Tree size (8 bytes) * " + treesToDraw);
            System.out.println("+ TreeTypes size (~30 bytes) * " + treeTypes);
            System.out.println("---------------------");
            System.out.println("Total: " + ((treesToDraw * 8 + treeTypes * 30) / 1024 / 1024) +
                    "MB (instead of " + ((treesToDraw * 38) / 1024 / 1024) + "MB)");
        } else {
            System.out.println("Composite: no executed.");
        }

    }
    private static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt((max - min) + 1) + min;
    }
}
