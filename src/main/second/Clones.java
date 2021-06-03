package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Dieses Programm kann per Knopfdruck zyklisch die Hintergrundfarbe ändern
 * und ebenfalls per Knopfdruck ein neues Fenster mit der exakt selben Funktion öffnen
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Clones extends Frame implements ActionListener {

    /**
     * Knöpfe und WindowAdapter erstellen, currentColor ist dafür da um zu wissen welche Farbe gerade den Hintergrund einnimt
     */
    private Button buttonColor = new Button("Farbe ändern");
    private Button buttonClone = new Button("Fenster Klonen");
    private String currentColor = "black";
    private WindowAdapter windowAdapter = new WindowAdapter() {

        /**
         * Beendet das Programm wenn ein Fenster geschlossen wird
         */
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    };

    /**
     * Die Main-Methode, erstellt eine Instanz von Clones
     */
    public static void main(String[] args) {
        Clones clones = new Clones();
    }

    /**
     * Wird durchgeführt bei Knopfdruck:
     * Fragt per ActionCommand ab welcher Knopf gedrückt wurde.
     * Ändert dann die Hintergrundfarbe und ändert den String currentColor in die momentane Farbe oder erstellt eine neue Instanz von Clones
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("color")) {
            switch(currentColor) {
                case"orange": setBackground(Color.pink);repaint();currentColor="pink";break;
                case"black": setBackground(Color.blue);repaint();currentColor="blue";break;
                case"blue": setBackground(Color.cyan);repaint();currentColor="cyan";break;
                case"cyan": setBackground(Color.gray);repaint();currentColor="gray";break;
                case"green": setBackground(Color.magenta);repaint();currentColor="magenta";break;
                case"magenta": setBackground(Color.orange);repaint();currentColor="orange";break;
                case"pink": setBackground(Color.red);repaint();currentColor="red";break;
                case"gray": setBackground(Color.green);repaint();currentColor="green";break;
                case"red": setBackground(Color.white);repaint();currentColor="white";break;
                case"white": setBackground(Color.yellow);repaint();currentColor="yellow";break;
                case"yellow": setBackground(Color.black);repaint();currentColor="black";break;
            }
        }else{
            Clones clones = new Clones();
        }
    }

    /**
     * Frame wird erstellt und Knöpfe werden diesem hinzugefügt, außerdem bekommen diese einen ActionCommand und ActionListener
     */
    public Clones() {
        setSize(new Dimension(500,500));
        buttonClone.addActionListener(this);
        buttonClone.setActionCommand("clone");
        buttonColor.addActionListener(this);
        buttonColor.setActionCommand("color");
        add(buttonClone);
        add(buttonColor);
        addWindowListener(windowAdapter);
        setLayout(new FlowLayout());
        setBackground(Color.black);
        setVisible(true);
    }
}
