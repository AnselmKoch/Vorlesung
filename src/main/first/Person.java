package src.main.first;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*Dieses Programm erstellt in diesem Fall zwei Personen, einmal Anselm dessen Attribute durch den Konstruktor gegeben sind
 und einmal Max, dessen Werte man in der Konsole eingeben kann.
 Es können belibieg viele Objekte(Personen) mit beiden Konstruktoren erstellt werden.

  Version: 09.11.2020

  @author: Anselm Koch ,Matthias Vollmer, Robin Schüle, Martin Marsal
 */


public class Person implements Comparable<Person>, Cloneable, SimpleTreeNode{

    private String vorname;
    private String name;
    private String beruf;
    private String geburtsort;
    private int geburtsJahr;
    private float hoehe;

    private static final String commaSpace = ", ";

    private static Person[] personArray = new Person[4];

    public static void main(String[] args) throws IOException {

        Person vater = new Person("Anselm", "Koch", "Student", "Nordheim", 1955, 1.75F);
        Person mutter = new Person("Anselma", "Koch", "Studentin", "Nordheim", 1965, 1.75F);
        Person sohn = new Person("Fabian", "Koch", "Schüler", "Nordheim", 2000, 1.50F);
        Person tochter = new Person("Fabiana", "Koch", "Schülerin", "Nordheim", 2002, 1.50F);
        Person testEnkel = new Person("Jan", "Koch", "-", "Nordheim", 2019, 1F);

       vater.addChild(sohn);
       vater.addChild(tochter);
       vater.getChild(0).addChild(testEnkel);


        Person[] familie = { vater, mutter, sohn, testEnkel, tochter};
        MyIO.writeln("Unsortierte Ausgabe::");
        MyIO.writeln(Arrays.toString(familie));

        Arrays.sort(familie);
        MyIO.writeln("Sortierte Ausgabe:");
        MyIO.writeln(Arrays.toString(familie));
        MyIO.writeln("");


        Person cloneVater = vater.clone();

        MyIO.writeln("Orginale Familie:");
        vater.print();
        MyIO.writeln("");
        MyIO.writeln("Geklonte Familie:");
        cloneVater.print();


    /*
        MyIO.writeln(anselm.toString());
        MyIO.writeln(personTest.toString());
        MyIO.writeln("------------------");

        personTest.compareWith(anselm);
     */

    }

    private SimpleTreeNode treenode = new DefaultTreeNode("");

    public void addChild(SimpleTreeNode child) {
        treenode.addChild(child);
    }

    public int getChildAmount() {
        return treenode.getChildAmount();
    }

    public SimpleTreeNode getChild(int pos) {
        return treenode.getChild(pos);
    }

    public int compareTo(Person o) {
        return (this.name+this.vorname).compareTo(o.name+o.vorname);
    }

    public Person clone(){
        Person newPerson = new Person(vorname, name, beruf,geburtsort , geburtsJahr, hoehe);
        newPerson.treenode = ((DefaultTreeNode)treenode).clone();
        return newPerson;
    }

    public static void sortPersons(Person[] comparables) {
        boolean sorted;
        do{
            sorted = true;
            for(int i = 0; i<comparables.length-1; i++) {
                if(comparables[i].compareTo(comparables[i+1]) > 0) {
                    Person tmp = comparables[i];
                    comparables[i] = comparables[i+1];
                    comparables[i+1] = tmp;
                    sorted = false;
                }
            }
        }while(!sorted);
    }

    public Person(String paraVorname, String paraName, String paraBeruf, String geburtsort, int paraGeburtsJahr, float paraHoehe) {
        this.vorname = paraVorname;
        this.name = paraName;
        this.beruf = paraBeruf;
        this.geburtsort = geburtsort;
        this.geburtsJahr = paraGeburtsJahr;
        this.hoehe = paraHoehe;
    }

    public Person() throws IOException {
        setVorname(MyIO.promptAndRead("Bitte Vornamen der Person eingeben!"));
        setNachname(MyIO.promptAndRead("Bitte Nachnamen der Person eingeben!"));
        setBeruf(MyIO.promptAndRead("Bitte Beruf der Person eingeben!"));
        setGeburtsort(MyIO.promptAndRead("Bitte Geburtsort der Person eingeben!"));
        setGeburtsJahr(MyIO.readInt("Bitte Geburtsjahr der Person eingeben!"));
        setHoehe(MyIO.readFloat("Bitte Körpergröße der Person eingeben (in Meter, anstatt einem Komma einen Punkt verwenden)"));
    }


    public String toString() {
        return this.vorname + ":  Vorname: "  + this.vorname + commaSpace +  "Nachname: " + this.name + commaSpace + " Beruf: " +
                this.beruf + commaSpace + " Geburtsort: " + this.geburtsort + commaSpace + " Geburtsjahr: "
                + this.geburtsJahr + commaSpace + " Groeße(m): " + this.hoehe + commaSpace + "Alter: " + this.getAlter()
                + commaSpace + " Groeße: " + this.hoeheToString();
    }


    public void setVorname(String newVorname) {
        this.vorname = newVorname;
    }
    public void setNachname(String newNachname) {
        this.name = newNachname;
    }
    public void setBeruf(String newBeruf) {
        this.beruf = newBeruf;
    }
    public void setGeburtsJahr(int newGeburtsJahr) {
        this.geburtsJahr = newGeburtsJahr;
    }
    public void setHoehe(float newHoehe) {
        this.hoehe = newHoehe;
    }
    public void setGeburtsort(String newGeburtsort) {
        this.geburtsort = newGeburtsort;
    }


    public int getAlter() {
        int currentYear = new GregorianCalendar().get(Calendar.YEAR);
        return currentYear - this.geburtsJahr;
    }

    public String hoeheToString() {
        if(this.hoehe < 1.52) {
            return "klein";
        }else if(this.hoehe > 1.75) {
            return "groß";
        }
        return "mittel";
    }

    public void print (Person person, String string){
        MyIO.writeln(string + person.toString());
        for (int i = 0; i < person.getChildAmount(); i++) {
            print((Person)person.getChild(i),string+" ");
        }
    }

    public void print (){
        MyIO.writeln(this.toString());
        for (int i = 0; i < this.getChildAmount(); i++) {
            print((Person)this.getChild(i),"  ");
        }
    }


    public void compareWith(Person personToCompareWith) {

        String namePerson = this.vorname;
        String namePersonToCompareWith = personToCompareWith.vorname;

        //Alter
        int alterPerson = this.getAlter();
        int alterPersonToCompareWith = personToCompareWith.getAlter();

        //Wenn Person mit der Verglichen wird älter ist
        if(alterPerson < alterPersonToCompareWith) {
            int difference = alterPersonToCompareWith - alterPerson;
            MyIO.writeln(namePersonToCompareWith + " ist um " + difference + " Jahr(e) älter als " + namePerson );

            //Wenn Person mit der Verglichen wird jünger ist
        }else if(alterPerson > alterPersonToCompareWith) {
            int difference = alterPerson - alterPersonToCompareWith;
            MyIO.writeln(namePerson + " ist um " + difference + " Jahr(e) älter als " + namePersonToCompareWith);
        }else if(alterPerson == alterPersonToCompareWith) {
            MyIO.writeln(namePerson + " und " + namePersonToCompareWith + " sind gleich alt");
        }

        //Größe
        float heightPerson = this.hoehe;
        float heightPersonToCompareWith = personToCompareWith.hoehe;

        //Wenn Person mit der verglichen wird größer ist
        if(heightPerson < heightPersonToCompareWith) {
            float difference = heightPersonToCompareWith - heightPerson;
            MyIO.writeln(namePersonToCompareWith + " ist um " + difference + "m größer als " + namePerson );

            //Wenn Person mit der verglichen wird kleiner ist
        }else if(heightPerson > heightPersonToCompareWith) {
            float difference = heightPerson - heightPersonToCompareWith;
            MyIO.writeln(namePerson + " ist um " + difference + "m größer als " + namePersonToCompareWith);
        }else if(heightPerson == heightPersonToCompareWith) {
            MyIO.writeln(namePerson + " und " + namePersonToCompareWith + " sind gleich groß");
        }
    }
}
