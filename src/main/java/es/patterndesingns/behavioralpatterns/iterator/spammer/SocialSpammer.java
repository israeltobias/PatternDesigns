package es.patterndesingns.behavioralpatterns.iterator.spammer;

import es.patterndesingns.behavioralpatterns.iterator.iterators.ProfileIterator;
import es.patterndesingns.behavioralpatterns.iterator.profile.Profile;
import es.patterndesingns.behavioralpatterns.iterator.socialnetworks.SocialNetwork;

public class SocialSpammer {
    private final SocialNetwork network;
    private  ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("\nIterating over friends...\n");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("\nIterating over coworkers...\n");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.println("Sent message to: '" + email + "'. Message body: '" + message + "'");
    }
}
