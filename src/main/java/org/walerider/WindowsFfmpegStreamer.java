package org.walerider;

import java.io.File;

public class WindowsFfmpegStreamer extends FFmpegStreamer {
    private String streamName;
    private String ipAddress;
    private String framerate;

    public WindowsFfmpegStreamer(String streamName, String ipAddress, String framerate) {
        this.streamName = streamName;
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
