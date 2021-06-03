package src.main.second;

import src.main.first.Fraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Version 2.0
 */

public class MaXGuIs implements Serializable {

    private Player playerWhite, playerBlack;
    private Player currentPlayer;
    private boolean running = true;
    private Spielfeld spielfeld;
    private transient JPanel contentPane;
    private Informations informations;
    private int gameNr;
    private transient JMenuBar jMenuBar;
    private transient JMenu jMenu;
    private transient ActionListener menuListener;
    private transient JMenuItem saveItem;
    private transient JMenuItem openItem;
    private transient JFileChooser jFileChooser;
    private transient JFrame jFrame;
    public static long serialVersionUID = 33;
    private Feld[][] felds = new Feld[8][8];
    private int playerWhiteX,playerWhiteY, playerBlackX, playerBlackY;
    private Fraction playerWhitePoints, playerBlackPoints;
    private Character saveCurrentPlayer;

    public static void main(String[] args) {
        StartGame startGame = new StartGame();
    }

    public MaXGuIs() {
    }

    public void setupFrame(int gamesNr) {
        this.jFrame = new JFrame();
        this.menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFileChooser = new JFileChooser();
                if(e.getActionCommand().equalsIgnoreCase("save")) {
                    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = jFileChooser.showOpenDialog(MaXGuIs.this.getjFrame());
                    if (result == JFileChooser.APPROVE_OPTION) {
                        safeGame(jFileChooser.getSelectedFile().getAbsolutePath());
                    }
                }else{
                    int result = jFileChooser.showOpenDialog(MaXGuIs.this.getjFrame());
                    if(result == JFileChooser.APPROVE_OPTION) {
                        StartGame.createNewMax((MaXGuIs)loadObject(jFileChooser.getSelectedFile()));
                    }
                }

            }
        };
        this.gameNr = gamesNr;
        this.getjFrame().setSize(750,900);
        this.getjFrame().setVisible(true);
        this.getjFrame().setResizable(false);
        contentPane = new JPanel();
        this.getjFrame().setContentPane(contentPane);
        this.getjFrame().setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        this.getjFrame().setTitle("Max Nr." + this.gameNr);
        this.jMenuBar = new JMenuBar();
        this.jMenu = new JMenu();
        this.saveItem = new JMenuItem("Spiel speichern");
        this.openItem = new JMenuItem("Spiel öffnen");
        this.saveItem.setActionCommand("save");
        this.openItem.setActionCommand("open");
        this.saveItem.addActionListener(menuListener);
        this.openItem.addActionListener(menuListener);
        this.jMenuBar.add(jMenu);
        this.jMenuBar.add(this.saveItem);
        this.jMenuBar.add(this.openItem);
        this.getjFrame().setJMenuBar(jMenuBar);
    }

    /**
     * Erstellt neue Spielinstanz
     */
    public void startGame() {
        this.spielfeld = new Spielfeld(this);
        this.informations = new Informations(this);
        informations.setPreferredSize(new Dimension(500,150));
        spielfeld.setPreferredSize(new Dimension(750,700));
        contentPane.add(spielfeld);
        contentPane.add(informations);
        this.playerBlack = new Player(4,4,'B',this);
        this.playerWhite = new Player(3,3, 'W',this);
        this.spielfeld.getFeld(4,4).setInformation(playerBlack.getName().toString());
        this.spielfeld.getFeld(3,3).setInformation(playerWhite.getName().toString());
        this.spielfeld.setFieldInformation(4, 4, "B");
        this.spielfeld.setFieldInformation(3, 3, "W");
        this.spielfeld.drawSpielfeld();

        this.currentPlayer = playerWhite;
    }

    /**
     * Macht dasselbe wie die obrige startGame Methode außer dass Objekte nicht neu
     * sondern mit den gespeicherten Daten instanziiert wird
     * @param maXGuIs übergibt das geladene MaxGuis Objekt
     */
    public void startGame(MaXGuIs maXGuIs) {
        this.spielfeld = new Spielfeld(maXGuIs, maXGuIs.felds);
        this.informations = new Informations(maXGuIs);
        informations.setPreferredSize(new Dimension(500,150));
        spielfeld.setPreferredSize(new Dimension(750,700));
        contentPane.add(maXGuIs.spielfeld);
        contentPane.add(maXGuIs.informations);
        this.playerBlack = new Player(maXGuIs.playerBlackX, maXGuIs.playerBlackY, 'B', maXGuIs);
        this.playerWhite = new Player(maXGuIs.playerWhiteX, maXGuIs.playerWhiteY, 'W', maXGuIs);
        this.spielfeld.setFieldInformation(maXGuIs.playerBlackX, maXGuIs.playerBlackY, "B");
        this.spielfeld.setFieldInformation(maXGuIs.playerWhiteX, maXGuIs.playerWhiteY, "W");
        this.playerWhite.setScore(playerWhitePoints);
        this.playerBlack.setScore(playerBlackPoints);
        this.spielfeld.drawSpielfeld();

        if(maXGuIs.saveCurrentPlayer == 'W') {
            this.currentPlayer = playerWhite;
        }else{
            this.currentPlayer = playerBlack;
        }
    }

    /**
     * Lädt das Objekt
     * @param file übergibt die File aus der dass Objekt geladen werden soll
     * @return returnt das geladene Objekt
     */
    private Object loadObject(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try {
                Object newMax = objectInputStream.readObject();
                return newMax;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Speichert wichtige Daten in den Attributen dass z.B das Spielfeld mit den vorherigen Daten neu instanziiert werden kann
     * @param path
     */
    private void safeGame(String path) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyMMddHHmmss");
        playerBlackX = playerBlack.getxLocation();
        playerBlackY = playerBlack.getyLocation();
        playerWhiteX = playerWhite.getxLocation();
        playerWhiteY = playerWhite.getyLocation();
        playerWhitePoints = playerWhite.getScore();
        playerBlackPoints = playerBlack.getScore();
        saveCurrentPlayer = currentPlayer.getName();
        for(int i = 0; i < spielfeld.spielfeld.length; i++) {
            for(int j = 0; j < spielfeld.spielfeld[i].length; j++) {
                felds[i][j] = spielfeld.spielfeld[i][j];
            }
        }
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(path + "\\" + "MaX" + this.gameNr  + dateFormat.format(date) + ".mx");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public boolean isDone() {
        if(playerWhite.getScore().intValue() >= 49) {
            informations.renderGameOver(playerWhite);
            this.running = false;
            return true;
        }else if(playerBlack.getScore().intValue() >= 49) {
            informations.renderGameOver(playerBlack);
            this.running = false;
            return true;
        }
        return false;
    }

    public void switchCurrentPlayer() {
        if(currentPlayer.getName().equals(playerWhite.getName())) {
            currentPlayer = playerBlack;
        }else{
            currentPlayer = playerWhite;
        }
    }

    public Feld[][] getFelds() {
        return this.felds;
    }

    public Informations getDirections() {
        return this.informations;
    }
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
    public boolean isRunning() {
        return this.running;
    }
    public Informations getInformations() {
        return this.informations;
    }
    public void setContentPane(JPanel jPanel) {
        this.contentPane = jPanel;
    }
    public JPanel getContentPane() {
        return this.contentPane;
    }
    public Spielfeld getSpielfeld(
    ) {
        return this.spielfeld;
    }
    public void setSpielfeld(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }
    public MaXGuIs getMaXGuI() {
        return this;
    }
    public void setInformations(Informations informations) {
        this.informations = informations;
    }
    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }
    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }

    public Player getPlayerWhite() {
        return this.playerWhite;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player getPlayerBlack() {
        return this.playerBlack;
    }

    public JFrame getjFrame() {
        return jFrame;
    }
}
