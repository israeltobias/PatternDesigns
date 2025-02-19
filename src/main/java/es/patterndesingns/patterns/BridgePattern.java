package es.patterndesingns.patterns;

import es.patterndesingns.structuralpatterns.bridge.devices.Device;
import es.patterndesingns.structuralpatterns.bridge.devices.Radio;
import es.patterndesingns.structuralpatterns.bridge.devices.Tv;
import es.patterndesingns.structuralpatterns.bridge.remotes.AdvancedRemote;
import es.patterndesingns.structuralpatterns.bridge.remotes.BasicRemote;

public class BridgePattern {

    public static void execute() {
        testDevice(new Tv());
        testDevice(new Radio());
    }
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
}
