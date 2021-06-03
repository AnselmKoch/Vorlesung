package src.main.second;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameOfLife extends JFrame implements ActionListener, Runnable{

    private final JMenu jMenuGame = new JMenu("Spiel");
    private final JMenuBar jMenuBar = new JMenuBar();
    private final JMenu jMenuOption = new JMenu("Optionen");
    private final JMenuItem neuesFenster = new JMenuItem("Neues Fenster");
    private final JMenuItem spielStart = new JMenuItem("Spiel starten");
    private final JMenuItem spielNeuStarten = new JMenuItem("Spiel neustarten");
    private final int cellWidth, cellHeight;
    private final int cellsOnY, cellsOnX;
    private final int width = 1000, height = 1000;
    private final JFrame jFrame =  this;
    private boolean running = false;


    private final Cell[][] cells;
    private Thread gameThread;
    private Timer generationTimer;
    private int generationDelay;

    public GameOfLife(int cellX, int cellY, int delay) {
        this.cellsOnY = cellY;
        this.cellsOnX = cellX;
        this.cellWidth = width / cellsOnY;
        this.cellHeight = height / cellsOnX;

        this.generationDelay = delay;
        this.setResizable(false);
        this.jFrame.setJMenuBar(jMenuBar);
        jMenuBar.add(jMenuOption);
        jMenuBar.add(jMenuGame);
        jMenuGame.add(spielStart);
        jMenuGame.add(spielNeuStarten);
        jMenuGame.add(neuesFenster);

        this.setLayout(new GridLayout(cellsOnX, cellsOnY));
        this.cells = new Cell[cellsOnY][cellsOnX];
        for(int i = 0; i < cellsOnY; i++) {
            for(int j = 0; j < cellsOnX; j++) {
                cells[i][j] = new Cell(this, i,j,cellWidth,cellHeight);
                this.jFrame.add(cells[i][j]);
            }
        }
        spielStart.addActionListener(this);
        neuesFenster.addActionListener(this);
        neuesFenster.setActionCommand("new");
        spielStart.setActionCommand("start");
        spielNeuStarten.addActionListener(this);
        spielNeuStarten.setActionCommand("reset");
        this.setSize(new Dimension(width,height));

        this.jFrame.setBackground(Color.BLACK);
        this.jFrame.setVisible(true);



        searcchForNeighbours();
    }




    @Override
    public void run() {
            this.generationTimer = new Timer();
            this.generationTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(running) {
                        for (int i = 0; i < cellsOnY; i++) {
                            for (int j = 0; j < cellsOnX; j++) {
                                cells[i][j].checkState();
                            }
                        }
                        for (int i = 0; i < cellsOnY; i++) {
                            for (int j = 0; j < cellsOnX; j++) {
                                cells[i][j].changeState();
                            }
                        }
                    }
                }
            }, 0, generationDelay);
        }

    private void startGenerationProcess() {
        this.gameThread = new Thread(this);
        this.run();
    }

    public static void main(String[] args) {
        new GameOfLifeSetupFrame();
    }
    public static void startGameOfLife(int x, int y, int delay) {
        new GameOfLife(x, y, delay);
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("start")) {
            this.running = true;
            startGenerationProcess();
        }else if(e.getActionCommand().equals("reset")) {
            if(this.isRunning()) {
                this.running = false;
                this.gameThread = null;
                for (Cell[] cell : cells) {
                     for (Cell cell2 : cell) {
                        if (cell2.isAlive()) {
                            cell2.die();
                        }
                    }
                }
            }
        }else if(e.getActionCommand().equals("new")) {
            new GameOfLifeSetupFrame();
        }
    }

    public boolean isRunning() {
        return running;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    private void searcchForNeighbours() {
        for(int i = 0; i < cellsOnY; i++) {
            for(int j = 0; j < cellsOnX; j++) {
                Cell cell = cells[i][j];
                if((i == cellsOnY -1) && (j != cellsOnX -1)) {
                    if(j == 0) {
                        cell.setNeighbour(cells[i][cellsOnX-1]);
                        cell.setNeighbour(cells[i - 1][cellsOnX-1]);
                        cell.setNeighbour(cells[0][0]);
                        cell.setNeighbour(cells[0][1]);
                        cell.setNeighbour(cells[0][cellsOnX-1]);
                    }else{
                        cell.setNeighbour(cells[0][j]);
                        cell.setNeighbour(cells[0][j-1]);
                        cell.setNeighbour(cells[0][j+1]);
                    }
                        cell.setNeighbour(cells[i - 1][j]);
                        cell.setNeighbour(cells[i - 1][j + 1]);
                        cell.setNeighbour(cells[i][j + 1]);
                }

                if((i == cellsOnY -1) && (j != 0)) {
                    if(j == cellsOnX - 1) {
                        cell.setNeighbour(cells[i][0]);
                        cell.setNeighbour(cells[i - 1][0]);
                        cell.setNeighbour(cells[0][0]);
                        cell.setNeighbour(cells[0][cellsOnX - 1]);
                        cell.setNeighbour(cells[0][cellsOnX - 2]);
                    }
                    cell.setNeighbour(cells[i][j-1]);
                    cell.setNeighbour(cells[i-1][j-1]);
                    cell.setNeighbour(cells[i-1][j]);
                }


                if((i == 0) && (j != 0)) {
                    if(j == cellsOnX - 1) {
                        cell.setNeighbour(cells[0][0]);
                        cell.setNeighbour(cells[0][1]);
                        cell.setNeighbour(cells[cellsOnY-1][0]);
                     }else{
                        cell.setNeighbour(cells[cellsOnY-1][j]);
                        cell.setNeighbour(cells[cellsOnY-1][j-1]);
                        cell.setNeighbour(cells[cellsOnY-1][j+1]);
                     }
                    cell.setNeighbour(cells[i][j-1]);
                    cell.setNeighbour(cells[i+1][j-1]);
                }
                if((i == 0) && (j != cellsOnX -1)) {
                    if(j == 0) {
                        cell.setNeighbour(cells[cellsOnY-1][0]);
                        cell.setNeighbour(cells[cellsOnY-1][1]);
                        cell.setNeighbour(cells[0][cellsOnX-1]);
                        cell.setNeighbour(cells[1][cellsOnX-1]);
                        cell.setNeighbour(cells[cellsOnY-1][cellsOnX-1]);
                    }
                    cell.setNeighbour(cells[i+1][j]);
                    cell.setNeighbour(cells[i+1][j+1]);
                    cell.setNeighbour(cells[i][j+1]);
                }

                if((i != 0) && (j == cellsOnX -1)) {
                    if(i != cellsOnY-1) {
                        cell.setNeighbour(cells[i][0]);
                        cell.setNeighbour(cells[i-1][0]);
                        cell.setNeighbour(cells[i+1][0]);
                    }
                    cell.setNeighbour(cells[i-1][j]);
                    cell.setNeighbour(cells[i-1][j-1]);
                }
                if((i != cellsOnY -1) && (j == cellsOnX -1)) {
                    cell.setNeighbour(cells[i+1][j]);
                    cell.setNeighbour(cells[i+1][j-1]);
                    cell.setNeighbour(cells[i][j-1]);
                }
                if((i != cellsOnY -1) && (j == 0)) {
                    if(i != 0) {
                        cell.setNeighbour(cells[i][cellsOnX-1]);
                        cell.setNeighbour(cells[i-1][cellsOnX-1]);
                        cell.setNeighbour(cells[i+1][cellsOnX-1]);
                    }
                        cell.setNeighbour(cells[i + 1][j]);
                        cell.setNeighbour(cells[i + 1][j + 1]);
                        cell.setNeighbour(cells[i][j + 1]);

                }
                if((i != 0) && (j == 0)) {
                    if(cell.freeNeighbourSpace() != 99) {
                        cell.setNeighbour(cells[i-1][j]);
                        cell.setNeighbour(cells[i-1][j+1]);
                    }
                }
                if((i > 0) && (i < cellsOnY -1) && (j > 0) && (j < cellsOnX -1)) {
                    cell.setNeighbour(cells[i+1][j]);
                    cell.setNeighbour(cells[i+1][j-1]);
                    cell.setNeighbour(cells[i+1][j+1]);
                    cell.setNeighbour(cells[i][j+1]);
                    cell.setNeighbour(cells[i][j-1]);
                    cell.setNeighbour(cells[i-1][j]);
                    cell.setNeighbour(cells[i-1][j+1]);
                     cell.setNeighbour(cells[i-1][j-1]);
                }else if((i == 0) && (j == 0)) {
                    cell.setNeighbour(cells[i+1][j]);
                    cell.setNeighbour(cells[i+1][j+1]);
                    cell.setNeighbour(cells[i][j+1]);
                }else if((i == 0) && (j == cellsOnX -1)) {
                    cell.setNeighbour(cells[i+1][j]);
                    cell.setNeighbour(cells[i+1][j-1]);
                    cell.setNeighbour(cells[i][j-1]);
                }else if((i == cellsOnY -1) && (j == cellsOnX -1)) {
                    cell.setNeighbour(cells[i-1][j]);
                    cell.setNeighbour(cells[i-1][j-1]);
                    cell.setNeighbour(cells[i][j-1]);
                }
            }
        }
    }
}
