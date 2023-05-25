package org.walerider;

import java.io.File;

public class MacFfmpegStreamer extends FFmpegStreamer {
    private String streamName;
    private String ipAddress;
    private String framerate;
    public MacFfmpegStreamer(String name, String ipAddress,String framerate) {
        this.streamName = name;
        this.ipAddress = ipAddress;
        this.framerate = framerate;
    }

    @Override
    public void start() {
        getAnotherFfmpegWrapper().anotherFFmpegDoing(streamName,ipAddress,framerate);
    }

    @Override
    public File stopAndSave(String filename) {
        return null;
    }
}
