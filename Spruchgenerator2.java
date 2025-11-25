/*
 * Spruchgenerator 2
 * Autor: Herr Fiedler
 * Lizenz: MIT License
 * Diese Datei darf frei genutzt, verändert und weitergegeben werden.
 * Vollständiger Lizenztext: https://opensource.org/licenses/MIT
 */

import java.util.Random;

public class Spruchgenerator2 {

    public static void main(String[] args) {

        Random rand = new Random();

        // Arrays übersichtlich in Ein-Zeilen-Schreibweise
        String[] personengruppe = {
            "Polizisten", "Lehrer", "Hausfrauen", "Ehemänner", "Anwälte",
            "Beamte", "Handwerker", "Matrosen", "Tennislehrer"
        };

        String[] adverb = {
            "wenigstens", "meistens", "niemals", "schon immer", "selten",
            "auf jeden Fall", "absurderweise", "fast immer", "natürlich"
        };

        String[] eigenschaft = {
            "langweilig", "wunderschön", "durchschnittlich intelligent",
            "ziemlich sexy", "gut im Bett", "schön anzusehen",
            "kräftig behaart", "tierlieb", "reich"
        };

        // Zufallszahlen anhand der tatsächlichen Array-Längen
        int r1 = rand.nextInt(personengruppe.length);
        int r2 = rand.nextInt(adverb.length);
        int r3 = rand.nextInt(eigenschaft.length);

        // Ausgabe
        System.out.println(
            personengruppe[r1] + " sind " + adverb[r2] + " " + eigenschaft[r3] + "!"
        );
    }
}
