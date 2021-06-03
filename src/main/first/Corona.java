package src.main.first;

public class Corona {

    public static int n;

    public static void main(String[] args) {
        if(checkNegative(n = MyIO.readInt("Bitte nichtnegative Zahl eingeben!")) == true) {
            printNumbers(n);
        }else{
            MyIO.writeln("Zahl war negativ");
        }
    }

    public static boolean checkNegative(int x) {
        return x >= 0;
    }

    public static void printNumbers(int x) {
        for(int i = 0; i <= x; i++) {
            switch (checkVielfaches(i)) {
                case 1: MyIO.writeln(String.valueOf(i)); break;
                case 3: MyIO.writeln("Tra"); break;
                case 5: MyIO.writeln("Tri"); break;
                case 7: MyIO.writeln("Lala"); break;
                case 99: MyIO.writeln("Corona"); break;
            }
        }
    }


    /**
     * Diese Methode prüft ob die Zahl x ein Vielfaches von 3,5,7 oder zwei davon gleichzeitig ist
     * @param x wer für den nach Vielfachen geprüft werden soll
     * @return
     * 1: kein vielfaches
     * 3: 3 ist vielfaches
     * 5: 5 ist vielfaches
     * 7: 7 ist vielfaches
     * 99: zwei sind gleichzeitig vielfaches
     */
    public static int checkVielfaches(int x) {
        if(x % 3 == 0) {
            if(x % 7 == 0) {
                return 99;
            }
            if(x % 5 == 0) {
                return 99;
            }
            return 3;
        }
        if(x % 5 == 0) {
            if(x % 7 == 0) {
                return 99;
            }
            if(x % 3 == 0) {
                return 99;
            }
            return 5;
        }
        if(x % 7 == 0) {
            if(x % 3 == 0) {
                return 99;
            }
            if(x % 5 == 0) {
                return 99;
            }
            return 7;
        }
        return 1;
    }
}
