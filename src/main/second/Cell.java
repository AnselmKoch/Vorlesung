package src.main.second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Cell extends JPanel implements MouseListener {

    private Cell[] neighbourCells = new Cell[8];
    private final int width , height;
    private boolean alive;
    final int xPos, yPos;
    private final GameOfLife gameOfLife;
    private Color color;
    private int aliveNeighbours;

    public Cell(GameOfLife gameOfLife, int y, int x, int width, int height) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        this.width = width;
        this.height = height;
        this.gameOfLife = gameOfLife;
        this.xPos = x;
        this.yPos = y;
        this.alive = false;
        Random random = new Random();
        this.addMouseListener(this);
        this.die();

    }



    public synchronized void  checkState() {
        for(Cell cell : neighbourCells) {
            if((cell != null) && (cell.isAlive())) {
                this.aliveNeighbours++;
            }
        }

    }

    public synchronized void changeState() {
        if(this.alive) {
            if(aliveNeighbours < 2) {
                die();
            }
            if(aliveNeighbours > 3) {
                die();
            }
        }else{
            if(aliveNeighbours == 3) {
                born();
            }
        }
        this.aliveNeighbours = 0;
    }

    public int freeNeighbourSpace() {
        for(int i = 0; i < neighbourCells.length; i++) {
            if(neighbourCells[i] == null) {
                return i;
            }
        }
        return 99;

    }

    public void born() {
        this.setAlive(true);
        this.setBackground(Color.GREEN);
    }

    public void die() {
        this.setAlive(false);
        this.setBackground(Color.RED);
    }
    public void setNeighbour(Cell neighbour){
        if(this.freeNeighbourSpace() != 99) {
            neighbourCells[this.freeNeighbourSpace()] = neighbour;
        }
    }


    public Cell[] getNeighbourCells() {
        return this.neighbourCells;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public GameOfLife getGameOfLife() {
        return gameOfLife;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!gameOfLife.isRunning()) {
            if(!this.isAlive()) {
                this.born();
            }else{
                this.die();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
