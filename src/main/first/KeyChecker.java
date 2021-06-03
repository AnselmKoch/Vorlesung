package src.main.first;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        if(ch == 'O') {
            if(lulxd.klick == false) {
                lulxd.klick = true;
            }else {
                lulxd.klick = false;
            }
            System.out.println("LUL");
        }
    }

    public static void click() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
