package src.main.second;

/**
 * @authors Anselm Koch 208900, Robin Schüle 208957 , Matthias Vollmer 208961, Martin Marsal 209390
 *
 * Mithilfe dieses Programms kann man auf einem 2D-Gitter malen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MyPaint extends JFrame implements MouseListener {

    /**
     * Breite und Höhe definiert wie groß das Fenster sein soll
     *
     * tilesPerAxis definiert wie viele bemalbare Tiles auf eine Achse kommen sollen (Breite oder Höhe) / 10 = 100, also 100 Tiles pro Achse
     * also 100*100 bemalbare Tiles insgesamt
     *
     * backGroundColor definiert die Hintergrundfarbe auf die gemalt wird
     * drawColor definiert die Farbe mit der gemalt wird
     *
     * drawTiles ist da um durch alle Tiles durchitererien zu können
     */
    private final int WIDTH = 1000, HEIGHT = 1000;
    private final int tilesPerAxis = 10;
    private final Color backGroundColor = Color.DARK_GRAY, drawColor = Color.WHITE;
    private final int xAxisTiles = WIDTH / tilesPerAxis, yAxisTiles = HEIGHT / tilesPerAxis;
    private JPanel[] drawTiles = new JPanel[xAxisTiles * yAxisTiles];

    public static void main(String[] args) {
        MyPaint myPaint = new MyPaint();
    }

    public MyPaint() {
        renderDrawTiles();
        setLayout(new GridLayout(xAxisTiles, yAxisTiles));
        setSize(new Dimension(WIDTH,HEIGHT));
        setVisible(true);
    }


    private void renderDrawTiles() {
        /**
         * Wird für die Anzahl an bemalbaren Tiles durchgeführt:
         *
         * erstellt ein JPanel, fügt diesem dem Array hinzu, setzt die Farbe des Tiles
         * und fügt diesem den MouselIstener hinzu, danach wird das JPanel dem JFrame zugefügt
         */
        for(int i = 0; i < (drawTiles.length); i++) {
            JPanel jPanel = new JPanel();
            drawTiles[i] = jPanel;
            jPanel.setBackground(backGroundColor);
            jPanel.addMouseListener(this);
            add(jPanel);
        }
    }


    /**
     * Ändert bei Mausclick die Hintergrundfarbe von jedem bemalten Tile zu der orgininalen Hintergrundfarbe
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < drawTiles.length; i++) {
            if(!drawTiles[i].getBackground().equals(backGroundColor)) {
                drawTiles[i].setBackground(backGroundColor);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Ändert die Farbe des JPanels welches mit der Maus in Berührung kommt
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel jPanel = (JPanel) e.getSource();
        jPanel.setBackground(drawColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
