package src.main.first;

/*Dieses Programm potenziert einen beliebigen Wert (X) Y-Mal mit sich selber

  Version: 02.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

public class PowerTower {

    //Ergebnis von der 1. und weiteren Potenzierungen zwischenspeichern
    static double ergebnis;

    public static void main(String args[]) {
        double x = MyIO.readInt("Bitte gib die Zahl an, die sich selber potenzieren soll");
        int y = MyIO.readInt("Bitte die Anzahl der Male eingeben wie oft die 1. Zahl mit sich selber potenziert werden soll");

        MyIO.writeln(String.valueOf(powerTower(x,y)));
    }

    private static double potenzieren(double x, int y) {
        if(y != 0) {
            for (int i = 0; i < y; i++) {
                if (i == 0) {
                    ergebnis = java.lang.Math.pow(x, y);
                } else {
                    ergebnis = java.lang.Math.pow(ergebnis, x);
                }
            }
        }else{
            ergebnis = 1;
        }
        return ergebnis;
    }

    //Andere Lösung
   private static double powerTower(double x, int n) {
        if (n <= 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else {
            return java.lang.Math.pow(x, powerTower(x, n - 1));
        }
    }
}
