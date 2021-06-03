package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Dieses Programm erechnet das Ideale für jedes Geschlecht für alle Größen
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IdealWeight extends JFrame implements ActionListener {

    private boolean isFemale = false;
    private int currentA, currentB;

    JRadioButton genderM, genderF; 		// Knöpfe für Geschlecht
    ButtonGroup genderGroup; 			// ... dazu Knopfgruppe
    JPanel genderPanel;					// ... dazu Panel


    JRadioButton heightA, heightB, heightC, heightD, heightE; 	// Kn. Grösse
    ButtonGroup heightGroup; 									// ... Gruppe
    JPanel heightPanel; 										// ... Panel

    JTextField resultText; 				// Textfeld für Ergebnis
    JLabel resultLabl; 					// ... dazu Label
    JPanel resultPanel; 				// ... dazu Panel

    /**
     * Konstruktor, erstellt das Fenster und setzt bestimmte Eigenschaften dass das Programm funktionieren kann
     */
    public IdealWeight() {                                // Konstruktor
        setTitle("Your Ideal Weight");                // Fenstertitel
        setDefaultCloseOperation(EXIT_ON_CLOSE);        // zum Fensterschliessen
        // Geschlechts-Gruppe
        genderM = new JRadioButton("Male", true);                                    // Knopf M. selekt.
        genderF = new JRadioButton("Female", false);                                // Knopf F. nicht s.
        genderGroup = new ButtonGroup();                                            // Gruppe def.
        genderGroup.add(genderM);
        genderGroup.add(genderF);                    // Kn. hinzufuegen
        genderPanel = new JPanel();                                                // G.-Panel
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));    // Layout ... vertikal
        genderPanel.add(new JLabel("Your Gender"));                                // Label &
        genderPanel.add(genderM);
        genderPanel.add(genderF);                    // Knoepfe hinzuf.
        // Hoehen-Gruppe
        heightA = new JRadioButton("60 to 64 inches", false);                        // ... selektiert
        heightB = new JRadioButton("64 to 68 inches", false);                        // nicht selektiert
        heightC = new JRadioButton("68 to 72 inches", false);                        // ...
        heightD = new JRadioButton("72 to 76 inches", false);                        // ...
        heightE = new JRadioButton("76 to 80 inches", false);                        // ...
        heightGroup = new ButtonGroup();                                            // Gruppe def.
        heightGroup.add(heightA);
        heightGroup.add(heightB);                    // Kn.
        heightGroup.add(heightC);
        heightGroup.add(heightD);                    // ... hinzufuegen
        heightGroup.add(heightE);                                                // ...
        heightPanel = new JPanel();                                                // H-Panel
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));    // Layout... vertikal
        heightPanel.add(new JLabel("Your Height"));                                // Label &
        heightPanel.add(heightA);
        heightPanel.add(heightB);                    // Kn. hinzufuegen
        heightPanel.add(heightC);
        heightPanel.add(heightD);                    // ...
        heightPanel.add(heightE); // ...
        // Ergebnis-Panel
        resultText = new JTextField(17);                                            // Textfeld
        resultText.setEditable(false);                                            // ... nur Ausgabe
        resultLabl = new JLabel("Ideal Weight");                                    // Label def.
        resultPanel = new JPanel();                                                // Panel def.
        resultPanel.add(resultLabl);                                                // Label hinzufuegen
        resultPanel.add(resultText);                                                // Textfeld ...
        // Gesamt-Fenster
        getContentPane().setLayout(new BorderLayout());                            // Layout: Border
        getContentPane().add(genderPanel, BorderLayout.WEST);                    // G-Panel hinzuf.
        getContentPane().add(heightPanel, BorderLayout.EAST);                    // H-Panel ...
        getContentPane().add(resultPanel, BorderLayout.SOUTH);                    // Ergebnis-Panel ..
        // Action
        genderM.addActionListener(this);
        genderM.setActionCommand("Male");
        genderF.addActionListener(this);
        genderF.setActionCommand("Female");
        heightA.addActionListener(this);
        heightA.setActionCommand("60 to 64 inches");
        heightB.addActionListener(this);
        heightB.setActionCommand("64 to 68 inches");
        heightC.addActionListener(this);
        heightC.setActionCommand("68 to 72 inches");
        heightD.addActionListener(this);
        heightD.setActionCommand("72 to 76 inches");
        heightE.addActionListener(this);
        heightE.setActionCommand("76 to 80 inches");
    }

    /**
     * Erstellt die 1. Instanz des Programms
     * @param args
     */
        public static void main (String[]args){
            IdealWeight weightApp = new IdealWeight();
            weightApp.setSize(300, 225);
            weightApp.setVisible(true);

        }


    /**
     * Errechnet das Idealgewicht für das Männliche Geschlecht
     * @param a minimale Größe
     * @param b maximale Größe
     * @return
     */
    public String rechnungM(double a, double b) {
        double aM = Math.round(((a*a)/30)*10)/10.0;
        double bM = Math.round(((b*b)/30)*10)/10.0;
        return aM +"-"+bM+" Pfund";
    }

    /**
     * Errechnet das Idealgewicht für das Weibliche Geschlecht
     * @param a minimale Größe
     * @param b maximale Größe
     * @return
     */
    public String rechnungF(double a, double b) {
        double aM = Math.round(((a*a)/28)*10)/10.0;
        double bM = Math.round(((b*b)/28)*10)/10.0;
        return aM +"-"+bM+" Pfund";
    }

    /**
     * Ändert den Text für den Output
     * @param a übergibt den Rechenmethoden den Integer a
     * @param b übergibt den Rechenmethoden den Integer b
     */
    private void changeString(int a, int b) {
        if(isFemale) {
            resultText.setText(rechnungF(a,b));
        }else{
            resultText.setText(rechnungM(a,b));
        }
    }

    /**
     * Wird bei Aktivierung eines JRadioButtons ausgeführt:
     * Überprüft welcher Knopf und verändert daraufhin die Werte die für die Rechnung notwendig sind
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Female":
                isFemale = true;
                changeString(currentA,currentB);
                break;

            case"Male":
                isFemale=false;
                changeString(currentA,currentB);
                break;

            case "60 to 64 inches":
                currentA=60;
                currentB=64;
                changeString(currentA,currentB);
                break;
            case "64 to 68 inches":
                currentA = 64;
                currentB = 68;
                changeString(currentA,currentB);
                break;
            case "68 to 72 inches":
                currentA = 68;
                currentB = 72;
                changeString(currentA,currentB);
                break;
            case "72 to 76 inches":
                currentA=72;
                currentB=76;
                changeString(currentA,currentB);
                break;
            case "76 to 80 inches":
                currentA = 76;
                currentB = 80;
                changeString(currentA,currentB);
                break;
        }
    }
}
