package src.main.first;

import java.math.BigInteger;

public class Kgv {
/*Dieses Programm findet das kleinste gemeinsame Vielfache von zwei Zahlen

  Version: 09.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

    private static BigInteger x;
    private static BigInteger y;

    public static void main(String[] args) {
        setBigIntegers();
        MyIO.writeln("Von " + x + " und " + y + " ist das kleinste gemeinsame Vielfache " + String.valueOf(getKgV(x,y)));
        divideXY(x,y);
    }


    public static void divideXY(BigInteger x, BigInteger y) {
        int ergebnis = x.intValue() / y.intValue();
        int rest = x.intValue() % y.intValue();

        MyIO.writeln("Bei " + x + "/" + y + " ist das Ergebnis " + ergebnis + " mit dem Rest " + rest);
    }


    public static BigInteger getKgV(BigInteger x, BigInteger y) {
            //Größte Zahl herausfinden
            int z = (x.intValue() < y.intValue()) ? y.intValue() : x.intValue();
            //Kleinste Zahl herausfinden
            int q = (x.intValue() < y.intValue()) ? x.intValue() : y.intValue();

            //    x*y / ggt(x*y)
            return new BigInteger(String.valueOf((x.intValue() * y.intValue()) / ggt(x.intValue(),y.intValue())));
    }


    public static int ggt(int x, int y) {
        //Größte Zahl herausfinden
        int z = x < y ? y : x;
        //Kleinste Zahl herausfinden
        int q = x < y ? x : y;

        for(int i = 1; i < z; i++) {
            if(i != 1) {
                if ((x % i == 0) && (y % i == 0)) {
                    return i;
                }
            }
        }
        return 1;
    }


    public static void setBigIntegers() {
        try {
            x = MyIO.readBigInt("Bitte den 1. Wert (X) eingeben");
            y = MyIO.readBigInt("Bitte den 2. Wert (Y) eingeben");

        }catch (NumberFormatException exception) {
            MyIO.writeln("Es scheint so als hätten sie keine korrekten Werte eingegeben.");
        }
    }
}
