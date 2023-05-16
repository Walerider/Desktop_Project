package org.walerider;

import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.recorder.ffmpeg.WindowsFFmpegRecorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Record extends Thread{
    private static BufferedReader reader;
    public void recLoop() throws IOException {
        boolean flag = false;
        WindowsFFmpegRecorder ffrec = new WindowsFFmpegRecorder();
        reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            reader.readLine();
            String enter = reader.readLine();
            if(enter.equalsIgnoreCase("start") && !flag){
                try {
                    recordinf(ffrec);
                    flag = true;
                } catch (InterruptedException e) {
                    System.out.println("sasai");
                }
            }
            else if(enter.equalsIgnoreCase("stop") && flag){
                try {
                    stopRec(ffrec);
                    flag = false;
                } catch (InterruptedException e) {
                    System.out.println("sasai");
                }
            }
            else if(enter.equals("kill")){
                break;
            }
        }

    }
    @Video
    static void recordinf(WindowsFFmpegRecorder ffrec) throws InterruptedException {
        ffrec.start();
        assert false;
    }
    static void stopRec(WindowsFFmpegRecorder ffrec) throws InterruptedException {
        ffrec.stopAndSave("name");
    }
}
