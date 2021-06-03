package src.main.second;

import src.main.first.Fraction;

import java.io.Serializable;

public class Player  implements Serializable {

    private int xLocation,yLocation;
    private Fraction score;
    private transient Character name;
    private MaXGuIs maXGuIs;

    public Player(int x, int y, Character name, MaXGuIs maXGuIs) {
        this.maXGuIs = maXGuIs;
        this.xLocation = x;
        this.yLocation = y;
        this.name = name;
        this.score = new Fraction(1,1);
    }

    public void move(String direction) {
        switch (direction) {
            case "N":
                System.out.println("N");
                if(xLocation >= 1) {
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, "-");
                    setxLocation(xLocation -= 1);
                    if(!maXGuIs.getSpielfeld().getFeld(xLocation,yLocation).getInformation().equals("-")) {
                        addToScore(maXGuIs.getSpielfeld().getFeld(xLocation, yLocation).getFraction());
                    }
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, getName().toString());
                    maXGuIs.isDone();
                }
                break;
            case "O":
                System.out.println("O");
                if(yLocation <= 6) {
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, "-");
                    setyLocation(yLocation += 1);
                    if(!maXGuIs.getSpielfeld().getFeld(xLocation,yLocation).getInformation().equals("-")) {
                        addToScore(maXGuIs.getSpielfeld().getFeld(xLocation, yLocation).getFraction());
                    }
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, getName().toString());
                    maXGuIs.isDone();
                }
                break;
            case "S":
                System.out.println("S");
                if(xLocation <= 6) {
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, "-");
                    setxLocation(xLocation += 1);
                    if(!maXGuIs.getSpielfeld().getFeld(xLocation,yLocation).getInformation().equals("-")) {
                        addToScore(maXGuIs.getSpielfeld().getFeld(xLocation, yLocation).getFraction());
                    }
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, getName().toString());
                    maXGuIs.isDone();
                }
                break;
            case "W":
                System.out.println("W");
                if(yLocation >= 1) {
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, "-");
                    setyLocation(yLocation -= 1);
                    if(!maXGuIs.getSpielfeld().getFeld(xLocation,yLocation).getInformation().equals("-")) {
                        addToScore(maXGuIs.getSpielfeld().getFeld(xLocation, yLocation).getFraction());
                    }
                    maXGuIs.getSpielfeld().setFieldInformation(xLocation, yLocation, getName().toString());
                    maXGuIs.isDone();
                }
                break;
        }
    }

    public void setScore(Fraction fraction) {
        this.score = fraction;
    }


    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public void addToScore(Fraction fraction) {
        if(score != null) {
            Fraction newFraction = score.add(fraction);
            score = newFraction;
        }
    }

    public Fraction getScore() {
        return score;
    }
}
