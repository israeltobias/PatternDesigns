package es.patterndesingns.behavioralpatterns.observer.editor;

import es.patterndesingns.behavioralpatterns.observer.publisher.EventManager;

import java.io.File;
import java.io.FileNotFoundException;

public class Editor {
    private final EventManager events;
    private File file;
    private static final String OPEN = "open";
    private static final String SAVE = "save";

    public Editor() {
        this.events = new EventManager(OPEN, SAVE);
    }

    public EventManager getEvents() {
        return events;
    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify(OPEN, file);
    }

    public void saveFile() throws FileNotFoundException {
        if(this.file == null) {
            throw new FileNotFoundException("Please open a file first.");
        }
        events.notify(SAVE, file);

    }
}
