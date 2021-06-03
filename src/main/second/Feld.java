package src.main.second;

import src.main.first.Fraction;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Feld extends JLabel implements Serializable {

    private String information;
    private int xLocation, yLocation;
    private Fraction fraction;


    public Feld(String konstInformation, Fraction fraction, int konstX, int konstY) {
        setBorder(BorderFactory.createLineBorder(Color.black,5));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        this.information = konstInformation;
        this.xLocation = konstX;
        this.yLocation = konstY;
        this.fraction = fraction;
    }


    public String toString() {
        return "  " + this.information + "  ";
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String newInformation) {
        this.information = newInformation;
        this.setText(newInformation);
    }

    public boolean isPlayerPosition(Player player) {
        if((this.xLocation == player.getxLocation()) && (this.yLocation == player.getyLocation())) {
            return true;
        }else{
            return false;
        }
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public Fraction getValue() {
        return fraction;
    }

    public void setValue(Fraction fraction) {
        this.fraction = fraction;
    }

    public Fraction getFraction() {
        return fraction;
    }
}
