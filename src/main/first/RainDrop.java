package src.main.first;

import java.awt.*;

public class RainDrop {

    private int width,height, xPos = -10, yPos;
    private float momentum;
    private Color color;

    public RainDrop(int awidth, int aheight, float amomentu, Color acolor) {
        this.width = awidth;
        this.height = aheight;
        this.momentum = amomentu;
        this.color = acolor;
    }

    public void setxPos(int x) {
        this.xPos = x;
    }

    public void setyPos(int y) {
        this.yPos = y;
    }

    public int updateYPos() {
        return  yPos += momentum;
    }

    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public float getMomentum() {
        return this.momentum;
    }
}
