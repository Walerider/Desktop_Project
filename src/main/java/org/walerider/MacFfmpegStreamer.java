package org.walerider;

import java.io.File;

public class MacFfmpegStreamer extends FFmpegStreamer {
    String streamName;
    public MacFfmpegStreamer(String name) {
        this.streamName = name;
    }

    @Override
    public void start() {
        getAnotherFfmpegWrapper().anotherFFmpegDoing(streamName);
    }

    @Override
    public File stopAndSave(String filename) {
        return null;
    }
}
