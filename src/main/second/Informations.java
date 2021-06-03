package src.main.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Informations extends JPanel implements ActionListener, Serializable {

    private Button north,east,south,west;
    private JTextArea jTextArea;
    private MaXGuIs maXGuIs;

    public Informations(MaXGuIs maXGuIs) {
        this.maXGuIs = maXGuIs;
        setLayout(new BorderLayout());
        north = new Button("N");
        north.addActionListener(this);
        north.setActionCommand("N");
        east = new Button("O");
        east.addActionListener(this);
        east.setActionCommand("O");
        south = new Button("S");
        south.addActionListener(this);
        south.setActionCommand("S");
        west = new Button("W");
        west.addActionListener(this);
        west.setActionCommand("W");
        jTextArea = new JTextArea("TEST");
        jTextArea.setEditable(false);
        add(jTextArea, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(east, BorderLayout.EAST);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
    }

    public void updateTextArea() {
        jTextArea.setText("Spieler " + maXGuIs.getCurrentPlayer().getName() + " ist dran! \n");
        jTextArea.append("Spieler W hat " + maXGuIs.getPlayerWhite().getScore() + " ("+ maXGuIs.getPlayerWhite().getScore().intValue()+ ") "  + " Punkte \n");
        jTextArea.append("Spieler B hat " + maXGuIs.getPlayerBlack().getScore() + " (" + maXGuIs.getPlayerBlack().getScore().intValue() + ") " +  "Punkte \n");
        jTextArea.append("\n");
        jTextArea.append("Wer zuerst bei 49 Punkten ist gewinnt!\n");
        jTextArea.append("...Benutze die 4 Knöpfe um in die gegebene Richtung ein Feld zu gehen...");

    }

    public void renderGameOver(Player player) {
        jTextArea.setText(null);
        jTextArea.setText("Spieler " + player.getName() + " hat gewonnen! \n");
        jTextArea.append("Schließe das Hauptfenster um das Programm zu beenden...\n");
        jTextArea.append("Oder starte einfach ein neues Spiel...\n");
        jTextArea.append("Danke fürs spielen :)");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(maXGuIs.isRunning()) {
            switch (e.getActionCommand()) {
                case "N": maXGuIs.getCurrentPlayer().move("N");
                    maXGuIs.switchCurrentPlayer();break;
                case "O": maXGuIs.getCurrentPlayer().move("O");
                    maXGuIs.switchCurrentPlayer();break;
                case"S": maXGuIs.getCurrentPlayer().move("S");
                    maXGuIs.switchCurrentPlayer();break;
                case "W": maXGuIs.getCurrentPlayer().move("W");
                    maXGuIs.switchCurrentPlayer();break;
            }
            if(maXGuIs.isRunning()) {
                updateTextArea();
            }
        }
    }
}
