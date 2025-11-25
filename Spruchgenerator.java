/*
 * Spruchgenerator
 * Autor: Herr Fiedler
 * Lizenz: MIT License
 * Diese Datei darf frei genutzt, verändert und weitergegeben werden.
 * Vollständiger Lizenztext: https://opensource.org/licenses/MIT
 */



public class Spruchgenerator {

    public static void main(String[] args) {
    
        //int randomNum = (int)(Math.random() * 101);  // 0 to 100
        //System.out.println(randomNum);

        /* ARRAY Personengruppe */
        String[] personengruppe = new String[9]; // Deklaration und Erstellung eines Arrays. 

        personengruppe[0] = "Polizistinnen";
        personengruppe[1] = "Lehrerinnen"; 
        personengruppe[2] = "Hausfrauen";
        personengruppe[3] = "Ehemänner"; 
        personengruppe[4] = "Anwälte"; 
        personengruppe[5] = "Beamte"; 
        personengruppe[6] = "Handwerker"; 
        personengruppe[7] = "Matrosen"; 
        personengruppe[8] = "Tennislehrer"; 

        /* ARRAY Adverb */
        String[] adverb = new String[9]; // Deklaration und Erstellung eines Arrays. 

        adverb[0] = "wenigstens";
        adverb[1] = "meistens"; 
        adverb[2] = "niemals";
        adverb[3] = "schon immer"; 
        adverb[4] = "selten"; 
        adverb[5] = "auf jeden Fall"; 
        adverb[6] = "absurderweise"; 
        adverb[7] = "fast immer"; 
        adverb[8] = "natürlich"; 

        /* ARRAY Eigenschaft */
        String[] eigenschaft = new String[9]; // Deklaration und Erstellung eines Arrays. 

        eigenschaft[0] = "langweilig";
        eigenschaft[1] = "wunderschön"; 
        eigenschaft[2] = "durchschnittlich intelligent";
        eigenschaft[3] = "ziemlich attraktiv"; 
        eigenschaft[4] = "flexibel"; 
        eigenschaft[5] = "schön anzusehen"; 
        eigenschaft[6] = "kräftig behaart"; 
        eigenschaft[7] = "tierlieb"; 
        eigenschaft[8] = "reich"; 

        /* Zufallszahl random1 für Personengruppe */
        int random1 = (int)(Math.random() * 9); // 9 mögliche Eigenschaften
       // System.out.println("Zufallszahl für Personengruppe: " + random1);
        
        /* Zufallszahl random1 für Adverb */
        int random2 = (int)(Math.random() * 9); // 9 mögliche Eigenschaften
        // System.out.println("Zufallszahl für Adverb: " + random2);

        /* Zufallszahl random3 für Eigenschaft */
        int random3 = (int)(Math.random() * 9); // 9 mögliche Eigenschaften
        // System.out.println("Zufallszahl für Eigenschaft: " + random3);

        /* AUSGABE */
         System.out.println("Zufallszahlen: "+random1+" "+random2+" "+random3);
        System.out.println(personengruppe[random1]+" sind "+adverb[random2]+" "+eigenschaft[random3]+" !"); //der dritte Wert wird ausgegeben, weil die Indexzahl 2 die dritte Zelle bezeichnet



    }}