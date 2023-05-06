package org.walerider;
import com.automation.remarks.video.recorder.VideoRecorder;

import static org.awaitility.Awaitility.await;


public abstract class FFmpegStreamer extends VideoRecorder {
    private AnotherFFmpegWrapper anotherFfmpegWrapper;

    public FFmpegStreamer() {
        this.anotherFfmpegWrapper = new AnotherFFmpegWrapper();
    }
    public void stop(){
        getAnotherFfmpegWrapper().stopFFmpeg();
    }

    public AnotherFFmpegWrapper getAnotherFfmpegWrapper() {
        return anotherFfmpegWrapper;
    }
}