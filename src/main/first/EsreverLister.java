package src.main.first;

import java.util.ArrayList;

public class EsreverLister {

    static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) {
        abfragen();

        for(String string : strings) {
            MyIO.writeln("Sie haben folgendes eingegeben: " + string);
            MyIO.writeln("Invertiert ist das:  " + invert(string));
        }

    }

    private static String invert(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }

    static void abfragen() {
        String zahl = MyIO.promptAndRead("Bitte Zahl eingeben");
        strings.add(zahl);
        if(!zahl.equals("ptS")) {
            abfragen();
        }
    }
}
