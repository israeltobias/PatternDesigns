package es.patterndesingns.behavioralpatterns.mediator.mediator;

public class Note {
    private int id;
    private String name;
    private String text;

    public Note() {
        name = "New note";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name;
    }
}
