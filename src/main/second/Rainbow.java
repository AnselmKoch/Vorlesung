package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Dieses Programm kann unendlich Fenster öffnen die alle jeweils im Sekundentakt ihre Farben ändern, diese Farben sind Regenbogenfarben
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Rainbow extends Frame implements ActionListener {

    /**
     * currentColor anfangs start damit man weiß dass es der 1. Durchlauf ist
     * Timer ist dafür verantwortlich dass etwas im Sekundentakt durchgeführt wird
     * Der Knopf sorgt dafür dass neue Instanzen von Rainbow erstellt werden
     * doRainbow ist dafür da dass das Frame weiß ob es die Hintergrundfarbe ändern soll und ob es den Knopf anzeigen soll
     */
    private String currentColor = "start";
    private Timer timerChangeColor;
    private Button newFrameButton = new Button("Neues Regenbogenfenster öffnen");
    private boolean doRainbow;

    /**
     * Erstellt eine neue Instanz von Rainbow
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Rainbow rainbow = new Rainbow(true);
    }

    /**
     * Die Main-Methode, erstellt die 1. Instant von Rainbow
     * @param args
     */
    public static void main(String[] args) {
        Rainbow rainbow = new Rainbow(false);
    }

    /**
     * Erstellt das Fenster und sorgt dafür dass jede Sekunde die Hintergrundfarbe geändert wird
     */
    public Rainbow(boolean doRainbow) {
        setSize(new Dimension(500,500));
        setLayout(new FlowLayout());
        setVisible(true);
        if(!doRainbow) {
            newFrameButton.addActionListener(this);
            add(newFrameButton);
        }
        if(doRainbow) {
            setBackground(Color.RED);
            timerChangeColor = new Timer();
            timerChangeColor.schedule(new TimerTask() {
                @Override
                public void run() {
                    switch (currentColor) {
                        case "start":
                            setBackground(Color.red);
                            currentColor = "red";
                            repaint();
                            break;
                        case "red":
                            setBackground(Color.ORANGE);
                            currentColor = "orange";
                            repaint();
                            break;
                        case "orange":
                            setBackground(Color.YELLOW);
                            currentColor = "yellow";
                            repaint();
                            break;
                        case "yellow":
                            setBackground(Color.GREEN);
                            currentColor = "green";
                            repaint();
                            break;
                        case "green":
                            setBackground(Color.BLUE);
                            currentColor = "blue";
                            repaint();
                            break;
                        case "blue":
                            setBackground(new Color(102,0,153));
                            currentColor = "magenta";
                            repaint();
                            break;
                        case "magenta":
                            setBackground(Color.RED);
                            currentColor = "red";
                            repaint();
                            break;
                    }
                }
            }, 0, 1000);
        }
    }
}

