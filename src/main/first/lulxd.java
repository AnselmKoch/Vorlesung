package src.main.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class lulxd extends KeyAdapter{

    public static boolean klick = false;

    public static void main(String[] args) throws AWTException {

        JTextField textField = new JTextField();

        textField.addKeyListener(new KeyChecker());

        JFrame jframe = new JFrame();

        jframe.add(textField);

        jframe.setSize(400, 350);

        jframe.setVisible(true);

        while(klick == true) {
            KeyChecker.click();
        }
    }
}
