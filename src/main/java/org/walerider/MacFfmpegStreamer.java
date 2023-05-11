package org.walerider;

import java.io.File;

public class MacFfmpegStreamer extends FFmpegStreamer {
    private String streamName;
    private String ipAddress;
    public MacFfmpegStreamer(String name, String ipAddress) {
        this.streamName = name;
        this.ipAddress = ipAddress;
    }

    @Override
    public void start() {
        getAnotherFfmpegWrapper().anotherFFmpegDoing(streamName,ipAddress);
    }

    @Override
    public File stopAndSave(String filename) {
        return null;
    }
}
