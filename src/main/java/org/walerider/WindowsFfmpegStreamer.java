package org.walerider;

import java.io.File;

public class WindowsFfmpegStreamer extends FFmpegStreamer {
    String name;

    public WindowsFfmpegStreamer(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        getAnotherFfmpegWrapper().anotherFFmpegDoing(name);
    }

    @Override
    public File stopAndSave(String filename) {
        return null;
    }
}
