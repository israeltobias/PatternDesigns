package es.patterndesingns.patterns;

import es.patterndesingns.structuralpatterns.facade.facade.VideoConversionFacade;

import java.io.File;

public class FacadePattern {

    public static void execute() {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
