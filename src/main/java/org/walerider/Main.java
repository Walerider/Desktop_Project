package org.walerider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader;
    private static FFmpegStreamer ffmpegStreamer;
    public static void main(String[] args) throws IOException{
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите тип вашей системы:");
        String system = reader.readLine();
        System.out.print("Введите ваш логин:");
        String nickname = reader.readLine();
        if(system.equalsIgnoreCase("windows") || system.equalsIgnoreCase("цштвщцы")) {
            ffmpegStreamer = new WindowsFfmpegStreamer(nickname);
        }
        else if(system.equalsIgnoreCase("mac") || system.equalsIgnoreCase("macos") ||
        system.equalsIgnoreCase("ьфс") || system.equalsIgnoreCase("ьфсщы")){
            ffmpegStreamer = new MacFfmpegStreamer(nickname);
        }
        while (true){
            System.out.print("Введите команду:");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("start") || command.equalsIgnoreCase("ыефре")){
                System.out.println("Поток пошёл(Ссылка для стрима: rtmp://localhost/stream/" + nickname + ").");
                ffmpegStreamer.start();
            }
            if (command.equalsIgnoreCase("stop") || command.equalsIgnoreCase("ыещз")){
                ffmpegStreamer.stop();
            }
            if(command.equalsIgnoreCase("kill") || command.equalsIgnoreCase("лшдд")){
                break;
            }
            System.out.println();
        }
    }

}