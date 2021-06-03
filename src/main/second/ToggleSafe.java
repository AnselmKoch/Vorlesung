package src.main.second;


/**
 *  @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 *  Dieses Programm entählt in einem Rechteck angereihte Knöpfe welche anfangs nach links alle Knöpfe rotieren lässt,
 *  nach jeder 9. Positionsänderung ändert sich die Drehrichtung
 *
 *  Das Programm muss wie die anderen Safes mit der Eingabe eines Passworts per Knopfdruck geschlossen werden,
 *  sollte diesmal eine falsche Zahl angetippt werden wird ein neues Fenster geöffnet dass aber um 33% schneller rotiert
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ToggleSafe extends JFrame implements ActionListener {

    /**
     * Die ArrayList activeSafes ist dazu da um zu wissen wie viele Safes erfolgreich geöffnet wurden
     * countSteps ist da um zu wissen wann das Programm die Drehrichtung ändern soll
     * lastDelay und delay ist da um die Geschwindigkeit der Rotation zu ermitteln
     *
     * boolean turnLeft ist dazu da unterscheiden zu können in welche Richtung sich die Knöpfe drehen,
     * der Timer dass das Programm immer 1 Sekunde wartet und die zwei Strings sind dazu da um
     * das Passwort mit den angeklickten Zahlen zu vergleichen
     */
    private static ArrayList<ToggleSafe> activeSafes = new ArrayList<>();
    private boolean turnLeft = true;
    private String lastInput = "", inputNumbers = "8529630741";
    private int countSteps = 0;
    private static int lastDelay;
    private int delay;
    private Timer turnTimer;
    private JButton[] jButtonsArray = new JButton[10];
    private JPanel northPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");

    public static void main(String[] args) {
        ToggleSafe toggleSafe = new ToggleSafe(1000);
    }

    /**
     * Konstruktor, fügt dem Frame die Knöpfe und die einzelnen Panels hinzu
     * und fügt der ArrayList das Objekt hinzu.
     *
     * @param delay übergibt dem Objekt die Geschwindigkeit mit der dieses Rotieren soll
     */
    public ToggleSafe(int delay) {
        this.delay = delay;
        lastDelay = this.delay;
        activeSafes.add(this);
        jButtonsArray[0] = button0;
        jButtonsArray[1] = button1;
        jButtonsArray[2] = button2;
        jButtonsArray[3] = button3;
        jButtonsArray[4] = button4;
        jButtonsArray[5] = button5;
        jButtonsArray[6] = button6;
        jButtonsArray[7] = button7;
        jButtonsArray[8] = button8;
        jButtonsArray[9] = button9;
        northPanel.add(button0);
        northPanel.add(button1);
        northPanel.add(button2);
        eastPanel.add(button3);
        eastPanel.add(button4);
        southPanel.add(button7);
        southPanel.add(button6);
        southPanel.add(button5);
        westPanel.add(button9);
        westPanel.add(button8);


        /**
         * Sorgt dafür dass die Knöpfe in einem Rechteck angereit werden
         */
        southPanel.setLayout(new GridLayout(1,3));
        northPanel.setLayout(new GridLayout(1,3));
        eastPanel.setLayout(new GridLayout(2,1));
        westPanel.setLayout(new GridLayout(2,1));
        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        for(JButton jButton : jButtonsArray) {
            jButton.addActionListener(this);
        }
        setSize(new Dimension(150,170));
        setVisible(true);

        turnTimer = new Timer();
        turnTimer.schedule(new TimerTask() {

            /**
             * Wenn es sich nach links dreht wird jede Zahl +1 gerechnet, außer es ist die Zahl 9 dann wird die Zahl zu 0 gemacht
             * Wenn es sich nach rechts dreht wird jede Zahl -1 gerechnet, außer es ist die Zahl 0 dann wird die Zahl zu 9 gemacht
             */
            @Override
            public void run() {
                for(JButton jButton:jButtonsArray) {
                    if(turnLeft) {
                        int currentInt = Integer.parseInt(jButton.getText());
                        if(currentInt != 9) {
                            jButton.setText(String.valueOf(currentInt + 1));
                            jButton.setActionCommand(String.valueOf(currentInt + 1));
                        }else{
                            jButton.setText("0");
                            jButton.setActionCommand("0");
                        }
                    }else{
                        int currentInt = Integer.parseInt(jButton.getText());
                        if(currentInt != 0) {
                            jButton.setText(String.valueOf(currentInt - 1));
                            jButton.setActionCommand(String.valueOf(currentInt - 1));
                        }else{
                            jButton.setText("9");
                            jButton.setActionCommand("9");
                        }
                    }
                }

                /**
                 * Addiert am Ende +1 auf countSteps, sollte countSteps bereits >=8 sein (9 Schritte) wird dieser = 0 gesetzt
                 * und ändert die Drehrichtung
                 */
                if(countSteps >= 8 ) {
                    countSteps = 0;
                    if(turnLeft) {
                        turnLeft = false;
                    }else{
                        turnLeft = true;
                    }
                }else{
                    countSteps++;
                }
            }
        },0,this.delay);
    }

    /**
     * Wird bei Knopfdruck ausgesucht, bekommt die zu dem Knopf gehörige Zahl übergeben
     *
     * Fügt die übergebene Zahl dem String lastInput hinzu und vergleicht anschließend jeden
     * Character von beiden Strings mit einander, sollten sie nicht übereinstimmen
     * wird der String geleert und eine neue Instanz von ToggleSafe wird erstellt, diese bekommt 33% weniger Delay als der vorherige
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        lastInput += e.getActionCommand();
        for(int i = 0; i < lastInput.length(); i++) {
            if(!(lastInput.charAt(i) == inputNumbers.charAt(i))) {
                lastInput = "";
                ToggleSafe toggleSafe = new ToggleSafe((int)(lastDelay - (lastDelay * 0.33F)));
                break;
            }
        }

        /**
         * Sollte das Passwort übereinstimmen wird das Objekt aus der ArrayList entfernt und anschließend überprüft,
         * ob es noch Objekte in der ArrayList gibt, falls nein wird das Programm beendet
         */
        if(lastInput.contains(inputNumbers)) {
            System.out.println("Passwort korrekt!");
            this.setVisible(false);
            activeSafes.remove(this);
            if(activeSafes.size() == 0) {
                System.out.println("Programm beendet!");
                System.exit(0);
            }
        }
    }
}