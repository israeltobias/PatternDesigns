package es.patterndesingns.behavioralpatterns.mediator.mediator;

import es.patterndesingns.behavioralpatterns.mediator.components.Component;

import javax.swing.*;

public interface Mediator {
    void addNewNote(Note note);
    void deleteNote();
    void getInfoFromList(Note note);
    void saveChanges();
    void markNote();
    void clear();
    void sendToFilter(ListModel<Note> listModel);
    void setElementsList(ListModel<Note> list);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void createGUI();
}
