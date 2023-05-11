package org.walerider;

import java.io.File;

public class WindowsFfmpegStreamer extends FFmpegStreamer {
    private String streamName;
    private String ipAddress;

    public WindowsFfmpegStreamer(String name,String ip) {
        this.streamName = name;
        this.ipAddress = ip;
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
