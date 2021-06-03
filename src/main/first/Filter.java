package src.main.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Filter {

    public static void main(String[] args) throws IOException {
        String urlString = "";
        String wort = "";
        InputStreamReader keyBoardInputStreamReader = new InputStreamReader(System.in);
        BufferedReader keyboardReader = new BufferedReader(keyBoardInputStreamReader);
        System.out.println("Bitte gib die URL der Website an auf der nach dem Wort gesucht werden soll!");
        urlString = keyboardReader.readLine();
        System.out.println("Bitte gib das Wort an nach dem auf der Website gesucht werden soll!");
        wort += keyboardReader.readLine();

        URL url = new URL(urlString);

        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while(bufferedReader.readLine() != null) {
            if(bufferedReader.readLine() != null) {
                if(bufferedReader.readLine().contains(wort)) {
                    System.out.println("Wort in folgender Zeile gefunden:");
                    System.out.println(bufferedReader.readLine());
                }
            }
        }
    }
}
