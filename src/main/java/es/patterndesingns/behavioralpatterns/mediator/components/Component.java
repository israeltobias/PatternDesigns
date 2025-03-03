package es.patterndesingns.behavioralpatterns.mediator.components;

import es.patterndesingns.behavioralpatterns.mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
