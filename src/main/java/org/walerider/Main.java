package org.walerider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String ip;
    private static String hls;
    private static String rtmp;
    private static BufferedReader reader;
    private static FFmpegStreamer ffmpegStreamer;
    public static void main(String[] args) throws IOException{
        String type;
        hls = "http://";
        rtmp = "rtmp://";
        ip = "localhost/";
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Выберите тип стриминга(1:Компьютер -> Компьютер | 2:Компьютер -> Телефон):");
        type = reader.readLine();
        if(type.equalsIgnoreCase("1")){
            ip = rtmp + ip;
        }
        else if (type.equalsIgnoreCase("2")){
            ip = hls + ip + "hls/";
        }
        else {
            System.out.println("Выставляю по умолчанию Компьютер -> Компьютер");
            ip = rtmp + ip;
        }
        System.out.print("Введите тип вашей системы:");
        String system = reader.readLine();
        System.out.print("Введите ваш логин:");
        String nickname = reader.readLine();
        if(system.equalsIgnoreCase("windows") || system.equalsIgnoreCase("цштвщцы") ||
           system.equalsIgnoreCase("win") || system.equalsIgnoreCase("цшт")) {
            ffmpegStreamer = new WindowsFfmpegStreamer(nickname,ip);
        }
        else if(system.equalsIgnoreCase("mac") || system.equalsIgnoreCase("macos") ||
        system.equalsIgnoreCase("ьфс") || system.equalsIgnoreCase("ьфсщы")){
            ffmpegStreamer = new MacFfmpegStreamer(nickname,ip);
        }
        while (true){
            System.out.print("Введите команду:");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("start") || command.equalsIgnoreCase("ыефре")){
                System.out.println("Поток пошёл(Ссылка для стрима:"+ ip + nickname + ").");
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