package org.walerider;

import java.lang.reflect.Method;

public class CommandsClass {
    FFmpegStreamer ffmpegStreamer;
    String ip;
    public CommandsClass(FFmpegStreamer ffmpegStreamer, String ip) {
        this.ffmpegStreamer = ffmpegStreamer;
        this.ip = ip;
    }

    private void help(){
        Class thisClass = CommandsClass.class;
        Method[] methods = thisClass.getDeclaredMethods();
        System.out.println("Все команды:");
        for (int i = 0; i < methods.length; i++) {
            String[] method = methods[i].toString().split("\\.");
            if(method[method.length-1].equals("String)")) continue;

            System.out.println("-" + method[method.length-1].split("\\(")[0]);
        }
    }
    private void stop(){ffmpegStreamer.stop();}
    private void start(){
        System.out.println("Стрим по адресу:" + ip);
        ffmpegStreamer.start();
    }
    protected void determinant(String command){
        if(command.equalsIgnoreCase("-help") || command.equalsIgnoreCase("-h")
        || command.equalsIgnoreCase("-рудз") || command.equalsIgnoreCase("-р")){
            help();
        }
        else if(command.equalsIgnoreCase("-start")
        || command.equalsIgnoreCase("-ыефке")){start();}
        else if (command.equalsIgnoreCase("-stop") || command.equalsIgnoreCase("-ытщз")) {stop();}
         else {
            System.out.println("Такой команды нет. Ознакомиться со списком комманд можно с помощью команды -help");
        }
    }
}
