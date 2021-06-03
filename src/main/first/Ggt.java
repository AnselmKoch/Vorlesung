package src.main.first;

import java.io.IOException;

/*Dieses Programm findet einen gemeinsamen Nenner für zwei beliebige Werte, aber nur falls der Nenner eine gerade Zahl ist

  Version: 02.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

public class Ggt {

    public static void main(String[] args) throws IOException {
        zahlenAbfragen();
    }

    public static void zahlenAbfragen() {
        try{
        int x = MyIO.readInt("Bitte die 1. Zahl eingeben");
        int y = MyIO.readInt("Bitte die 2. Zahl eingeben");
        if(checkIfNegative(x,y)) {
            //Geminsamer Nenner wird ausgerechnet
            getNenner(x, y);
        }
        }catch(NumberFormatException e) {
            MyIO.writeln("Es scheint so als hätten Sie für einen Wert keine Zahl angegeben.");
        }
    }

    public static int getNenner(int x, int y) {
        //Größte Zahl herausfinden
        int z = (x > y) ? y : x;

        //Kleinste Zahl herausfinden
        int q = (x > y) ? x : y;

        //Falls ein eingegebener Wert 0 entspricht ist der gemeinsame Nenner automatisch der andere Wert
        if((x == 0) || (y == 0)) {
            MyIO.writeln("Da einer der Werte 0 entspricht, ist der gemeinsame Nenner "+ q);
            zahlenAbfragen();
        }

        //Falls beide Zahlen geteilt durch i keinen Rest haben
        for(int i = z; i > 1; i--) {
            if((x % i) == 0 && (y % i) == 0) {
                //System gibt den gemeinsamen Nenner aus
                MyIO.write("Da (" + x + " / " + i + ") = " + x/i);
                MyIO.write(" und ");
                MyIO.write( "(" + y + " / " + i + ") = " + y/i);
                MyIO.writeln(", ist " + i +" der größte gemeinsame Nenner.");

                //Progrmam fängt von neu an
                zahlenAbfragen();
            }
        }
        return 0;
    }

    //Abfrage ob eingegeben Werte beide positiv sind
    private static boolean checkIfNegative(int x, int y) {
        if((x >= 0) && (y >= 0)) {
            return true;
        }else {
            MyIO.writeln("Bitte achten Sie darauf NUR positive Zahlen einzugeben");
            return false;
        }
    }
}
