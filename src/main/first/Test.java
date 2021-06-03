package src.main.first;

public class Test {

    static float bierPreis = 1.20F;
    static float wurstPreis = 4.20F;
    static float käsePreis = 2.30F;
    static float brotPreis = 2.10F;
    static float dvdPreis = 12F;

    static int bierAnzahl;
    static int wurstAnzahl;
    static int käseAnzahl;
    static int brotAnzahl;
    static int dvdAnzahl;

    static float bierInsg;
    static float wurstInsg;
    static float käseInsg;
    static float brotInsg;
    static float dvdInsg;

    static float preisInsg;

    public static void main(String[] args) {

        anzahlAngeben();

        bierInsg = bierPreis * bierAnzahl;
        wurstInsg = wurstPreis * wurstAnzahl;
        käseInsg = käsePreis * käseAnzahl;
        brotInsg = brotPreis * brotAnzahl;
        dvdInsg = dvdPreis * dvdAnzahl;

        preisInsg = bierInsg + wurstInsg + käseInsg + brotInsg + dvdInsg;

        MyIO.writeln("Bier:    " + bierAnzahl + " x " + bierPreis + "EUR    " + bierInsg + "EUR");
        MyIO.writeln("Wurst:    " + wurstAnzahl + " x " + wurstPreis + "EUR    " + wurstInsg + "EUR");
        MyIO.writeln("Käse:    " + käseAnzahl + " x " + käsePreis + "EUR    " + käseInsg + "EUR");
        MyIO.writeln("Brot:    " + brotAnzahl + " x " + bierPreis + "EUR    " + brotInsg + "EUR");
        MyIO.writeln("DvD:    " + dvdAnzahl + " x " + dvdPreis + "EUR    " + dvdInsg + "EUR");
        MyIO.writeln("-------------------------------------------------");
        MyIO.writeln("Gesamt:           " + preisInsg + "EUR");

    }

    static void anzahlAngeben() {
        bierAnzahl = MyIO.readInt("Anzahl von Bier eingeben");
        wurstAnzahl = MyIO.readInt("Anzahl von Wurst eingeben");
        käseAnzahl = MyIO.readInt("Anzahl von Käse eingeben");
        brotAnzahl = MyIO.readInt("Anzahl von Brot eingeben");
        dvdAnzahl = MyIO.readInt("Anzahl von DvD eingeben");
    }
}
