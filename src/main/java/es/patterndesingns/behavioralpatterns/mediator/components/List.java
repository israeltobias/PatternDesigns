package es.patterndesingns.behavioralpatterns.mediator.components;

import es.patterndesingns.behavioralpatterns.mediator.mediator.Mediator;
import es.patterndesingns.behavioralpatterns.mediator.mediator.Note;

import javax.swing.*;

public class List extends JList<Note> implements Component {
    private transient Mediator mediator;
    private final DefaultListModel<Note> listModel;

    public List(DefaultListModel<Note> listModel) {
        super(listModel);
        this.listModel = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        note.setId(listModel.size());
        listModel.addElement(note);
        int index = listModel.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(listModel);
    }

    public void deleteElement() {
        //int index = this.getSelectedIndex();
        int index = this.getSelectedValue().getId();
        try {
            listModel.remove(index);
            mediator.sendToFilter(listModel);
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public Note getCurrentElement() {
        return getSelectedValue();
    }

    public int lenght() {
        return listModel.size();
    }

    @Override
    public String getName() {
        return "List";
    }

}
