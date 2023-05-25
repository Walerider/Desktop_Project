package org.walerider;

import org.apache.commons.lang3.SystemUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.automation.remarks.video.SystemUtils.getPidOf;
import static com.automation.remarks.video.SystemUtils.runCommand;
import static org.walerider.AnotherFFmpegWrapper.RECORDING_TOOL;

public class Main {
    private static String ip;
    private static String hls;
    private static String rtmp;
    private static BufferedReader reader;
    private static FFmpegStreamer ffmpegStreamer;
    public static void main(String[] args) throws IOException{
        String framerate;
        hls = "http://";
        rtmp = "rtmp://";
        ip = "77.246.98.169";
        reader = new BufferedReader(new InputStreamReader(System.in));
        hls = hls + ip+ ":8080/" + "live/";
        ip = rtmp + ip + ":1935/" + "stream/";
        System.out.print("Введите ваш логин:");
        String nickname = reader.readLine();
        System.out.println("Введите желаемое кол-во кадров");
        framerate = reader.readLine();
        hls += nickname + ".m3u8";
        ffmpegStreamer = new WindowsFfmpegStreamer(nickname,ip,framerate);
        CommandsClass cc = new CommandsClass(ffmpegStreamer,ip+nickname, hls);
        while (true){
            System.out.print("Введите команду:");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("-kill") || command.equalsIgnoreCase("-лшдд")){
                kill();
                break;
            }
            else {
                cc.determinant(command);
            }
        }
    }
    private static String kill(){
        final String SEND_CTRL_C_TOOL_NAME = "SendSignalCtrlC.exe";
        return SystemUtils.IS_OS_WINDOWS ?
                runCommand(SEND_CTRL_C_TOOL_NAME, getPidOf(RECORDING_TOOL)) :
                runCommand("pkill", "-INT", RECORDING_TOOL);
    }
}