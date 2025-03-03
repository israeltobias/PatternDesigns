package es.patterndesingns.behavioralpatterns.mediator.components;

import es.patterndesingns.behavioralpatterns.mediator.mediator.Mediator;
import es.patterndesingns.behavioralpatterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Filter extends JTextField implements Component{
    private transient Mediator mediator;
    private transient ListModel<Note> listModel;

    public Filter() {
        super();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel<Note> listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.isEmpty()) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add(listModel.getElementAt(i));
        }
        DefaultListModel<Note> defaultListModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().toLowerCase().contains(s.toLowerCase())) {
                defaultListModel.addElement(note);
            }
        }
        mediator.setElementsList(defaultListModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
