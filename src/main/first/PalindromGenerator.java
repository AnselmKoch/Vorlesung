package src.main.first;

import java.io.*;

/*
 * Funktion: Der Benutzer kann zwei Wörter seiner Wahl in die Konsole eingeben, aus diesen Wörtern werden dann
 * 5 verschiedene Palindrome generiert. Die dabei generierten Palindrome werden unter der Datei "palindrom.txt" gespeichert
 *
 * Version: 26.10.2020
 *
 * @author: Matthias Vollmer, Anselm Koch, Robin Schüle, Martin Marsal
 */

public class PalindromGenerator {

    public static void main(String[] args) throws IOException {
        String text1 = "";
        String text2 = "";

        InputStreamReader keyBoardInputStreamReader = new InputStreamReader(System.in);
        BufferedReader keyboardReader = new BufferedReader(keyBoardInputStreamReader);
        System.out.println("Bitte gib das erste Wort ein!");
        text1 = keyboardReader.readLine();
        System.out.println("Bitte gib das zweite Wort ein!");
        text2 += keyboardReader.readLine();

        String textl1 = invert(text1);
        String textl2 = invert(text2);

        File file = new File("src/palindrom.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(fileOutputStream);

        printStream.println(text1 + text2 + textl2 + textl1);
        printStream.println(text2 + text1 + textl1 + textl2);
        printStream.println(textl2 + textl1 + text1 + text2);
        printStream.println(textl1 + textl2 + text2 + text1);
        printStream.println(text1 + textl2 + text2 + textl1);


    }

    private static String invert(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }
}
