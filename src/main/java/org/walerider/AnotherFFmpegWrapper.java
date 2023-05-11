package org.walerider;

import com.automation.remarks.video.recorder.ffmpeg.FFmpegWrapper;
import org.apache.commons.lang3.SystemUtils;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.automation.remarks.video.SystemUtils.getPidOf;
import static com.automation.remarks.video.SystemUtils.runCommand;
import static com.automation.remarks.video.recorder.VideoRecorder.conf;

public class AnotherFFmpegWrapper extends FFmpegWrapper {
    public static final String RECORDING_TOOL = "ffmpeg";
    private CompletableFuture<String> future;

    private AnotherFFmpegWrapper ffmpegWrapper;
    private static String RTMP_IP = "rtmp://localhost/stream/";


    @Override
    public void startFFmpeg(String... args) {
        super.startFFmpeg(args);
    }

    @Override
    public File getTemporaryFile() {
        return super.getTemporaryFile();
    }

    private String killFFmpeg() {
        final String SEND_CTRL_C_TOOL_NAME = "SendSignalCtrlC.exe";
        return SystemUtils.IS_OS_WINDOWS ?
                runCommand(SEND_CTRL_C_TOOL_NAME, getPidOf(RECORDING_TOOL)) :
                runCommand("pkill", "-INT", RECORDING_TOOL);
    }
    public void stopFFmpeg(){
        System.out.println("Логирование когда-нибудь будет, но сейчас это:" + killFFmpeg());
    }
    public void anotherFFmpegDoing(String streamName,String ipAddress,String... args){

        final String[] commandsSequence = new String[]{
                FFmpegWrapper.RECORDING_TOOL,
                "-f", conf().ffmpegFormat(),
                "-framerate", String.valueOf(30),
                "-i", conf().ffmpegDisplay(),
                "-video_size", getScreenSize(),
                "-c:v","libx264",
                "-b:v", "5000k",
                "-c:a", "aac",
                "-preset", "ultrafast",
                "-f","flv",
                "-g", "30",
                "-r", "30",
                "-pix_fmt", conf().ffmpegPixelFormat(),
                "-threads", "0",
                ipAddress+streamName
        };

        List<String> command = new ArrayList<>();
        command.addAll(Arrays.asList(commandsSequence));
        command.addAll(Arrays.asList(args));
        this.future = CompletableFuture.supplyAsync(() -> runCommand(command));
    }

    private String getScreenSize() {
        Dimension dimension = conf().screenSize();
        return dimension.width + "x" + dimension.height;
    }
}
