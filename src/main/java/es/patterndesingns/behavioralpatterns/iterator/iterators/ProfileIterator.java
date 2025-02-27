package es.patterndesingns.behavioralpatterns.iterator.iterators;

import es.patterndesingns.behavioralpatterns.iterator.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
