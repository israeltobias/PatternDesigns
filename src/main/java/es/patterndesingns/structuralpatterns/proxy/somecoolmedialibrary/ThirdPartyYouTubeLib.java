package es.patterndesingns.structuralpatterns.proxy.somecoolmedialibrary;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
