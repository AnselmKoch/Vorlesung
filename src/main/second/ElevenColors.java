package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Dieses Progrmam öffnet ein Fenster mit mehreren Knöpfen die jeweils die Hintergrundfarbe des Fensters öffnen
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElevenColors extends Frame implements ActionListener {

    /**
     * Buttons erstellen, die ArrayList ist aus Faulheit da um nicht jeden Knopf einzelnd aufrufen zu müssen
     */
    private static ArrayList<Button> arrayListButton = new ArrayList<>();
    private static Button buttonBlack = new Button("Schwarz");
    private static Button buttonBlue = new Button("Blau");
    private static Button buttonCyan = new Button("Cyan");
    private static Button buttonGray = new Button("Gray");
    private static Button buttonGreen = new Button("Grün");
    private static Button buttonMagenta = new Button("Magenta");
    private static Button buttonOrange = new Button("Orange");
    private static Button buttonPink = new Button("Pink");
    private static Button buttonRed = new Button("Rot");
    private static Button buttonWhite = new Button("Weiß");
    private static Button buttonYellow = new Button("Gelb");

    /**
     * Main-Methode, erstellt eine Instanz von ElevenColors
     */
    public static void main(String[] args) {
        ElevenColors elevenColors = new ElevenColors();
    }

    /**
     * Konstruktor, erstellt das Frame, fügt diesem die Knöpfe hinzu und gibt diesen direkt den ActionCommand und der Listener
     */
    public ElevenColors() {
        setSize(new Dimension(500,500));
        arrayListButton.add(buttonBlue);
        buttonBlue.setActionCommand("blue");
        arrayListButton.add(buttonOrange);
        buttonOrange.setActionCommand("orange");
        arrayListButton.add(buttonCyan);
        buttonCyan.setActionCommand("cyan");
        arrayListButton.add(buttonGray);
        buttonGray.setActionCommand("gray");
        arrayListButton.add(buttonBlack);
        buttonBlack.setActionCommand("black");
        arrayListButton.add(buttonGreen);
        buttonGreen.setActionCommand("green");
        arrayListButton.add(buttonMagenta);
        buttonMagenta.setActionCommand("magenta");
        arrayListButton.add(buttonPink);
        buttonPink.setActionCommand("pink");
        arrayListButton.add(buttonRed);
        buttonRed.setActionCommand("red");
        arrayListButton.add(buttonWhite);
        buttonWhite.setActionCommand("white");
        arrayListButton.add(buttonYellow);
        buttonYellow.setActionCommand("yellow");

        setLayout(new FlowLayout());

        for(Button button : arrayListButton) {
            button.addActionListener(this);
            add(button);
        }
        setVisible(true);
    }

    /**
     * Wird bei Knopfdruck ausgeführt:
     * Frägt den ActionCommand ab um zu sehen welcher Knopf gedrückt wurde und ändert je nach Knopf die Hintergrundfarbe
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "orange": setBackground(Color.ORANGE);repaint();break;
            case"black": setBackground(Color.black);repaint();break;
            case"blue": setBackground(Color.BLUE);repaint();break;
            case"cyan": setBackground(Color.cyan);repaint();break;
            case"green": setBackground(Color.GREEN);repaint();break;
            case"magenta": setBackground(Color.MAGENTA);repaint();break;
            case"pink": setBackground(Color.PINK);repaint();break;
            case"gray": setBackground(Color.GRAY);repaint();break;
            case"red": setBackground(Color.red);repaint();break;
            case"white": setBackground(Color.white);repaint();break;
            case"yellow": setBackground(Color.yellow);repaint();break;
        }
    }
}
