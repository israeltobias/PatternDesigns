package es.patterndesingns.patterns;

import es.patterndesingns.behavioralpatterns.observer.editor.Editor;
import es.patterndesingns.behavioralpatterns.observer.listener.EmailNotificationListener;
import es.patterndesingns.behavioralpatterns.observer.listener.LogOpenListener;

public class ObserverPattern {

    private ObserverPattern() {
        super();
    }

    public static void execute() {
        Editor editor = new Editor();
        editor.getEvents().subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.getEvents().subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
