package es.patterndesingns.structuralpatterns.flyweight.trees;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    private TreeFactory() {
    }

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        return treeTypes.computeIfAbsent(name, _ -> new TreeType(name, color, otherTreeData));
    }
}
