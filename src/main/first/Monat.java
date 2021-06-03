package src.main.first;

public enum Monat {
    Januar (1), Februar(2), März(3), April(4),
    Mai(5), Juni(6), Juli(7), August(8),
    September(9), Oktober(10), November(11), Dezember(12);

    private final int monatID;

    Monat(int monatID) {
        this.monatID = monatID;
    }

    public int getNumber() {
        return this.monatID;
    }

    public static void main(String[] args) {
        MyIO.writeln("Alle Monate die ein e enthalten und deren Nummer ungerade ist: ");
        for(Monat m : Monat.values()) {
            if((m.toString().contains("e") && (m.getNumber() % 2 != 0))) {
                MyIO.writeln(m.toString() + " " + m.getNumber());
            }
        }

        MyIO.writeln("----------------------");

        MyIO.writeln("Alle Monate die ein u enthalten und deren Nummer gerade ist:");
        for(Monat m : Monat.values()) {
            if((m.toString().contains("u") && (m.getNumber() % 2 == 0))) {
                MyIO.writeln(m.toString() + " " + m.getNumber());
            }
        }
    }

}
