package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Dieses Programm dient als Art safe, es wird erst beendet wenn man eine richtige Zahlenkombination eingibt,
 * jenachdem ob man eine richtige Zahl oder nicht eingegeben hat ändert sich die Hintergrundfarbe
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Safe extends Frame implements ActionListener {

    /**
     * Erstellen von Knöpfen und wieder eine ArrayList aus Faulheit
     * inputNumbers ist das Passwort und lastInput sind die Zahlen die korrekt waren
     */
    private String inputNumbers = "19032021";
    private String lastInput = "";
    private ArrayList<Button> arrayListButton = new ArrayList<>();
    private Button button0 = new Button("0");
    private Button button1 = new Button("1");
    private Button button2 = new Button("2");
    private Button button3 = new Button("3");
    private Button button4 = new Button("4");
    private Button button5 = new Button("5");
    private Button button6 = new Button("6");
    private Button button7 = new Button("7");
    private Button button8 = new Button("8");
    private Button button9 = new Button("9");

    /**
     * Wird bei Knopfdruck durchgeführt:
     * Fügt dem lastInput die letzte gedrückte Zahl zu, vergleicht dann jeden Buchstaben von LastInput mit denen vom richtigen Passwort
     * Sollte eine eingebene Zahl nicht korrekt sein wird der String geleert und der Hintergrund wird rot gefärbt.
     * Ist die eingegeben Zahl richtig wird der Hintergrund nur grün gefärbt
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        lastInput += e.getActionCommand();
        for(int i = 0; i < lastInput.length(); i++) {
            if(!(lastInput.charAt(i) == inputNumbers.charAt(i))) {
                lastInput = "";
                setBackground(Color.RED);
                break;
            }else{
                setBackground(Color.GREEN);
            }
        }
        if(lastInput.contains(inputNumbers)) {
            System.out.println("Passwort korrekt!");
            System.exit(0);
        }
    }

    /**
     * Erstellt das Fenster und fügt diesem die Knöpfe, den ActionListener etc. zu
     */
    public Safe( ) {
        setSize(new Dimension(500,500));
        setLayout(new FlowLayout());
        button0.setActionCommand("0");
        button1.setActionCommand("1");
        button2.setActionCommand("2");
        button3.setActionCommand("3");
        button4.setActionCommand("4");
        button5.setActionCommand("5");
        button6.setActionCommand("6");
        button7.setActionCommand("7");
        button8.setActionCommand("8");
        button9.setActionCommand("9");
        arrayListButton.add(button0);
        arrayListButton.add(button1);
        arrayListButton.add(button2);
        arrayListButton.add(button3);
        arrayListButton.add(button4);
        arrayListButton.add(button5);
        arrayListButton.add(button6);
        arrayListButton.add(button7);
        arrayListButton.add(button8);
        arrayListButton.add(button9);
        for(Button button : arrayListButton) {
            button.addActionListener(this);
            add(button);
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
    }
}
