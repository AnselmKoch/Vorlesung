package src.main.second;

import src.main.first.Fraction;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Spielfeld extends JPanel implements Serializable {

    public Feld[][] spielfeld = new Feld[8][8];

    private MaXGuIs maXGuIs;

    public Spielfeld(MaXGuIs maXGuIs, Feld[][] felds) {
        this.maXGuIs = maXGuIs;
        this.setLayout(new GridLayout(8,8));
        this.spielfeld = felds;
        for(int i = 0; i <= spielfeld.length-1; i++) {
            for(int j = 0; j <= spielfeld[i].length-1; j++) {
                this.add(spielfeld[i][j]);
            }
        }
        drawSpielfeld();
    }
    public Spielfeld(MaXGuIs maXGuIs) {
        this.maXGuIs = maXGuIs;
        this.setLayout(new GridLayout(8,8));
        for(int i = 0; i <= spielfeld.length-1; i++) {
            for(int j = 0; j <= spielfeld[i].length-1; j++) {
                Fraction fraction = randomFraction();
                spielfeld[i][j] = new Feld(fraction.toString(),fraction, j,i);
                this.add(spielfeld[i][j]);
            }
        }
        drawSpielfeld();
    }

    public void drawSpielfeld() {
        for(int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if(j != 7) {
                  spielfeld[i][j].setText(spielfeld[i][j].getInformation() + " ");
                }else{
                    spielfeld[i][j].setText(spielfeld[i][j].getInformation() + " ");
                }
            }
        }
    }

    public Feld getFeld(int x, int y) {
        return spielfeld[x][y];
    }

    public void setFieldInformation(int x, int y, String newInformation) {
        spielfeld[x][y].setInformation(newInformation);
    }
    public void setFieldValue(int x, int y, float value) {
        spielfeld[x][y].setValue(new Fraction((int)value,(int)value));
    }

    public Fraction randomFraction() {
        Fraction returnFraction = new Fraction(randomInt(), randomInt());

        while((returnFraction.numerator.intValue() <= 10) || (returnFraction.denominator.intValue() <= 10)) {
            returnFraction = new Fraction(randomInt(), randomInt());
        }
        return returnFraction;
    }

    public int randomInt() {
        return ThreadLocalRandom.current().nextInt(10,999);
    }
}
