package src.main.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeSetupFrame extends JFrame implements ActionListener {

    private int cellsOnX;
    private int cellsOnY;
    private int delay;

    private boolean shouldStart = true;

    private JTextField prefCellsOnX = new JTextField();
    private JTextField prefCellsOnY = new JTextField();
    private JTextField prefGenerationDelay = new JTextField();
    private JLabel labelCellX = new JLabel("Zellen auf der X-Achse");
    private JLabel labelCellY = new JLabel("Zellen auf der Y-Achse");
    private JLabel labelDelay = new JLabel("Geschwindigkeit in Millisek.");
    private JButton startGameOfLifeButton = new JButton("Starte das Spiel des Lebens");


    public GameOfLifeSetupFrame() {
        setLayout(new GridLayout(4,0));
        this.add(labelCellX);
        this.add(prefCellsOnX);
        labelCellX.setLabelFor(prefCellsOnY);
        this.add(labelCellY);
        this.add(prefCellsOnY);
        labelCellY.setLabelFor(prefCellsOnY);
        this.add(labelDelay);
        this.add(prefGenerationDelay);
        labelDelay.setLabelFor(prefGenerationDelay);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        prefGenerationDelay.setText("1000");
        prefCellsOnX.setText("75");
        prefCellsOnY.setText("75");
        this.add(startGameOfLifeButton);
        startGameOfLifeButton.addActionListener(this);
        setVisible(true);
        setSize(new Dimension(300,200));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            cellsOnX = Integer.parseInt(prefCellsOnX.getText());
        }catch (NumberFormatException numberFormatException) {
            callError(prefCellsOnX);
        }
        try {
            cellsOnY = Integer.parseInt(prefCellsOnY.getText());
        }catch (NumberFormatException numberFormatException) {
            callError(prefCellsOnY);
        }
        try {
            delay = Integer.parseInt(prefGenerationDelay.getText());
        }catch (NumberFormatException numberFormatException) {
           callError(prefGenerationDelay);
        }

        shouldStart = true;
        if(cellsOnX <= 0) {
            callError(prefCellsOnX);
        }else{
            prefCellsOnX.setBackground(Color.WHITE);
        }
        if(cellsOnY <= 0) {
            callError(prefCellsOnY);
        }else{
            prefCellsOnY.setBackground(Color.WHITE);
        }
        if(delay <= 0) {
            callError(prefGenerationDelay);
        }else{
            prefGenerationDelay.setBackground(Color.WHITE);
        }

        if(shouldStart) {
            GameOfLife.startGameOfLife(cellsOnX, cellsOnY, delay);
        }
    }

    private void callError(JTextField jTextField) {
        jTextField.setBackground(Color.RED);
        shouldStart = false;
    }
}
