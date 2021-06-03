package src.main.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class StartGame extends JFrame implements ActionListener, Serializable {

    public static StartGame instance;
    public static int gamesNr = 1;
    private MaXGuIs maXGuIs;
    private ArrayList<MaXGuIs> activeGames = new ArrayList<>();

    public StartGame() {
        instance = this;
        setSize(new Dimension(300, 300));
        setVisible(true);
        setResizable(false);
        Button button = new Button("Spiel starten");
        add(button);
        setTitle("Hauptfenster");
        button.addActionListener(this);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createNewMax(MaXGuIs maXGuIs) {
        maXGuIs.setupFrame(gamesNr);
        maXGuIs.startGame(maXGuIs);
        maXGuIs.getDirections().updateTextArea();
        gamesNr++;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        maXGuIs = new MaXGuIs();
        maXGuIs.setupFrame(gamesNr);
        maXGuIs.startGame();
        maXGuIs.getDirections().updateTextArea();
        gamesNr ++;
    }

    public MaXGuIs getMaXGuI() {
        return this.maXGuIs;
    }

    public ArrayList<MaXGuIs> getActiveGames() {
        return activeGames;
    }
}