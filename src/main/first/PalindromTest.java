package src.main.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromTest {

    private static String palindrom = "";

    public static void main(String[] args) throws IOException {

        InputStreamReader keyBoardInputStreamReader = new InputStreamReader(System.in);
        BufferedReader keyboardReader = new BufferedReader(keyBoardInputStreamReader);
        System.out.println("Bitte gib das Wort in der Konsole ein");
        palindrom = keyboardReader.readLine();

        if(palindrom.equalsIgnoreCase(invert(palindrom))) {
            System.out.println("Bei diesem Wort handelt es sich um ein Palindrom");
            System.out.println(palindrom);
            System.out.println(invert(palindrom));
        }else{
            System.out.println("Bei diesem Wort handel es sich um kein Palindrom!");
            System.out.println(palindrom);
            System.out.println(invert(palindrom));
        }
    }

    private static String invert(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }
}
