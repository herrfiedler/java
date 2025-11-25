/*
 * AbenteuerGeschichte
 * Autor: Herr Fiedler
 * Lizenz: MIT License
 * Diese Datei darf frei genutzt, verändert und weitergegeben werden.
 * Vollständiger Lizenztext: https://opensource.org/licenses/MIT
 */


import java.util.Scanner;

public class AbenteuerGeschichte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variablen
        String spielername = "Fremder";
        int schwert = 0;
        int goldsack = 0;

        // Einführung
        System.out.println("Hallo " + spielername + ", willkommen zur interaktiven Geschichte!");
        System.out.print("Gib den Namen des ersten Protagonisten ein: ");
        String protagonist1 = scanner.nextLine();

        System.out.print("Gib den Namen des zweiten Protagonisten ein: ");
        String protagonist2 = scanner.nextLine();

        System.out.println("\nEs war einmal ein mutiger Abenteurer namens " + protagonist1 +
                " und seine treue Begleiterin " + protagonist2 + ".");
        System.out.println("Die beiden waren auf dem Weg zum geheimnisvollen Drachenberg.");

        // Entscheidung Höhle
        System.out.println("\nUnterwegs stoßen sie auf eine dunkle Höhle. Möchtest du, dass sie die Höhle betreten? (ja/nein)");
        String decision1 = scanner.nextLine().toLowerCase();

        if (decision1.equals("ja")) {
            System.out.println("\n" + protagonist1 + " und " + protagonist2 +
                    " betreten die Höhle und entdecken eine alte Schatztruhe.");
            System.out.println("In der Truhe liegen ein rostiges Schwert und ein kleiner Sack mit Gold.");
            System.out.println("Leider könnt ihr nur EINEN Gegenstand tragen.");

            // Eine Entscheidung: Schwert oder Gold?
            System.out.println("\nWas möchtet ihr mitnehmen? (schwert/gold)");
            String itemDecision = scanner.nextLine().toLowerCase();

            if (itemDecision.equals("schwert")) {
                schwert = 1;
                System.out.println("Ihr nehmt das rostige Schwert mit.");
            } else {
                goldsack = 1;
                System.out.println("Ihr nehmt den kleinen Goldsack mit.");
            }

        } else {
            System.out.println("\nIhr betretet die Höhle nicht und geht weiter.");
        }

        // Entscheidung Weg
        System.out.println("\nNach einigen Stunden erreichen sie eine Weggabelung. Norden oder Süden? (norden/süden)");
        String decision2 = scanner.nextLine().toLowerCase();

        if (decision2.equals("norden")) {
            System.out.println("\nIm Norden finden sie ein friedliches Dorf und ruhen sich aus.");
        } else {
            System.out.println("\nIm Süden treffen sie auf einen wilden Fluss.");
        }

        // Drache
        System.out.println("\nEin böser Drache springt aus einem Gebüsch hervor. Kämpfen oder weglaufen? (kämpfen/weglaufen)");
        String decision3 = scanner.nextLine().toLowerCase();

        if (decision3.equals("weglaufen")) {
            System.out.println("\nIhr versucht wegzulaufen, aber der Drache ist schneller. Er tötet euch. ENDE.");
        } else {
            System.out.println("\nIhr stellt euch dem Drachen!");

            // Prüfen, ob das Schwert vorhanden ist
            if (schwert == 1) {
                System.out.println("Mit dem rostigen Schwert kämpft ihr tapfer und besiegt den Drachen!");
                System.out.println("Ihr seid die HELDEN DER GESCHICHTE!");
            } else {
                System.out.println("Ihr habt kein Schwert! Der Drache ist zu stark.");
                System.out.println("Der Drache besiegt euch... ENDE DER GESCHICHTE.");
            }
        }

        scanner.close();
        System.out.println("\nDanke, dass du die Geschichte mitgestaltet hast!");
    }
}
