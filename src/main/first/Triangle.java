package src.main.first;

public class Triangle {

    /*Dieses Programm gibt ein Dreieck mit einer beliebigen Anzahl an Schichten aus.

  Version: 09.11.2020

  @author: Anselm Koch, Matthias Vollmer, Robin Schüle, Martin Marsal
 */

    static int stars = 1;
    static String starString = "";
    static String spaceString = "";
    static int n;


    public static void main(String[] args) {
        MyIO.writeln("Wir malen Dreiecke!");
        n = MyIO.readInt("Bitte eingeben wie viele Schichten das Dreieck haben soll");
        drawTriangle(n);
        MyIO.writeln(n + " Zeilen und " + stars + " Sterne!");
    }

    public static void drawTriangle(int n) {
        for(int i = 1; i < n; i++) {
            //Es werden n-i viele Leerzeichen vor die Sterne gesetzt
            addSpaceToString(n-i);
            starString += "* ";
            stars += 1 * i+1;
            MyIO.writeln(spaceString + starString);
        }
    }

    public static void addSpaceToString(int n) {
        spaceString = "";
        for(int i = 1; i < n; i++) {
            spaceString += " ";
        }
    }
}
