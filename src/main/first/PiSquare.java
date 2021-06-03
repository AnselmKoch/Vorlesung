package src.main.first;

public class PiSquare {

    /*Dieses Programm kann mithilfe von dem eingegeben Wert so nah wie möglich an Pi kommen

  Version: 09.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

    public static void main(String[] args) {
        MyIO.writeln(String.valueOf(piSquare(MyIO.readLong("Bitte n eingeben!"))));
    }


    public static double piSquare(long n) {
        double zwischenergebnis = 0;

        for(int i = 0; i <= n; i++) {
            if(i!=0) {
                zwischenergebnis += 6.0 / (i * i);
            }
        }
        return java.lang.Math.sqrt(zwischenergebnis);
    }


}
