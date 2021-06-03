package src.main.first;

import java.io.*;

public class FileMirror {

    public static void main(String[] args) throws IOException {

       String dateiName1 = "";
       String dateiName2 = "";


       //Input von Tastatur in der Konsole
       InputStreamReader keyBoardInputStreamReader = new InputStreamReader(System.in);
       BufferedReader keyboardReader = new BufferedReader(keyBoardInputStreamReader);


       //Benutzer soll einmal den Pfad zur Quelldatei und danach den Pfad zur Zieldatei angeben.
       System.out.println("Bitte geben Sie den Pfad zu der Quelldatei inkl. Dateityp am Ende ein aus der Sie den Text kopiert haben wollen! Achten Sie darauf, dass sich die Namen der jewiligen Dateien von einander unterscheiden müssen.");
       dateiName1 = keyboardReader.readLine();
       System.out.println("Bitte geben Sie nun den Pfad zu der Zieldatei inkl. Dateityp am Ende ein in der Sie den Text kopiert haben wollen! Achten Sie darauf, dass sich die Namen der jewiligen Dateien von einander unterscheiden müssen.");
       dateiName2 = keyboardReader.readLine();


       File sourceDatei = new File(dateiName1);
       File targetDatei = new File(dateiName2);


       //Falls es Zieldatei noch nicht geben sollte wird diese erstellt
       if(!targetDatei.exists()) {
           targetDatei.createNewFile();
       }



       //Input aus der Quelldatei
       FileInputStream sourceFileInputStream = new FileInputStream(sourceDatei);
       InputStreamReader sourceInputStreamReader = new InputStreamReader(sourceFileInputStream);
       BufferedReader sourceBufferedReader = new BufferedReader(sourceInputStreamReader);


       //Output in die Zieldatei
       FileOutputStream targetFileOutputStream = new FileOutputStream(targetDatei);
       PrintStream targetPrintStream = new PrintStream(targetFileOutputStream);


       //Jede Zeile der Quelldatei in die Zieldatei invertiert kopieren
       String line = sourceBufferedReader.readLine();
       while (line != null) {
           targetPrintStream.println(invert(line));
           line = sourceBufferedReader.readLine();
       }

   }


   //Invertiert einen String
    private static String invert(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }
}
