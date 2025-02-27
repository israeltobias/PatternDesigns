package es.patterndesingns.behavioralpatterns.iterator.socialnetworks;

import es.patterndesingns.behavioralpatterns.iterator.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
