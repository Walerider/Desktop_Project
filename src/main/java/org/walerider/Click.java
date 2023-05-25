package org.walerider;

import java.awt.*;
import java.awt.event.InputEvent;

public class Click extends Thread {
    int x,y;

    public void setXY(int x,int y) {
        this.y = y;
        this.x = x;
        run();
    }

    @Override
    public void run(){
        super.run();
        try {
            Robot bot = new Robot();
            bot.mouseMove(x, y);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            stop();
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
}
