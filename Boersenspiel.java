/*
 * Börsenspiel
 * Autor: Herr Fiedler
 * Lizenz: MIT License
 * Diese Datei darf frei genutzt, verändert und weitergegeben werden.
 * Vollständiger Lizenztext: https://opensource.org/licenses/MIT
 */

import java.util.*;

public class Boersenspiel {

    // Innere Klasse, die eine Aktie beschreibt
    static class Stock {
        String name;   // Name der Aktie
        double price;  // Aktueller Kurs der Aktie

        // Konstruktor: Erstellt eine neue Aktie mit Name und Anfangskurs
        public Stock(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Methode für die Kursänderung
        public void updatePrice() {
            // Zufällige Kursänderung zwischen -10 % und +10 %
            double change = (Math.random() * 0.20) - 0.10;

            // Kurs anpassen
            price += price * change;

            // Untergrenze für den Kurs
            if (price < 1) price = 1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Startkapital des Spielers
        double money = 10_000;

        // Speichert, wie viele Aktien der Spieler besitzt
        Map<String, Integer> depot = new HashMap<>();

        // Liste aller verfügbaren Aktien
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("Apple", 180.0));
        stocks.add(new Stock("Tesla", 220.0));
        stocks.add(new Stock("Microsoft", 320.0));
        stocks.add(new Stock("Amazon", 140.0));
        stocks.add(new Stock("Google", 130.0));
        stocks.add(new Stock("Meta", 290.0));
        stocks.add(new Stock("Commerzbank", 27.0));
        stocks.add(new Stock("Siemens", 160.0));
        stocks.add(new Stock("Mercedes Benz", 110.0));
        stocks.add(new Stock("Geely", 13.0));

        // Anfangs besitzt der Spieler von jeder Aktie 0 Stück
        for (Stock s : stocks) {
            depot.put(s.name, 0);
        }

        // Begrüßung
        System.out.println("====== Aktienmarkt-Simulation ======");
        System.out.println("Startkapital: " + money + " EUR\n");

        boolean playing = true;

        // Hauptschleife des Spiels
        while (playing) {

            // Aktuelle Kurse und Depot anzeigen
            System.out.println("\n--- Aktuelle Kurse ---");
            for (int i = 0; i < stocks.size(); i++) {
                Stock s = stocks.get(i);
                System.out.printf("%d) %-12s | Kurs: %.2f EUR | Besitz: %d\n",
                        i, s.name, s.price, depot.get(s.name));
            }

            // Menüauswahl
            System.out.println("\nGeld verfügbar: " + money + " EUR");
            System.out.println("Was möchtest du tun?");
            System.out.println("1) Aktie kaufen");
            System.out.println("2) Aktie verkaufen");
            System.out.println("3) Runde beenden (Kurse ändern sich)");
            System.out.println("4) Spiel beenden");

            System.out.print("Auswahl: ");
            int choice = sc.nextInt();

            // Auswahl auswerten
            switch (choice) {

                // -----------------------------
                // AKTIE KAUFEN
                // -----------------------------
                case 1 -> {
                    System.out.print("Welche Aktie (Index)? ");
                    int index = sc.nextInt();

                    // Eingabe prüfen
                    if (index < 0 || index >= stocks.size()) {
                        System.out.println("Ungültige Eingabe!");
                        continue;
                    }

                    Stock s = stocks.get(index);

                    System.out.print("Wie viele kaufen? ");
                    int amount = sc.nextInt();

                    double cost = amount * s.price;

                    // Reicht das Geld?
                    if (cost > money) {
                        System.out.println("Nicht genug Geld!");
                    } else {
                        money -= cost;  // Geld abziehen
                        depot.put(s.name, depot.get(s.name) + amount);
                        System.out.println("Gekauft: " + amount + "x " + s.name);
                    }
                }

                // -----------------------------
                // AKTIE VERKAUFEN
                // -----------------------------
                case 2 -> {
                    System.out.print("Welche Aktie (Index)? ");
                    int index = sc.nextInt();

                    // Eingabe prüfen
                    if (index < 0 || index >= stocks.size()) {
                        System.out.println("Ungültige Eingabe!");
                        continue;
                    }

                    Stock s = stocks.get(index);

                    System.out.print("Wie viele verkaufen? ");
                    int amount = sc.nextInt();

                    int owned = depot.get(s.name);

                    // Hat der Spieler so viele Aktien?
                    if (amount > owned) {
                        System.out.println("So viele besitzt du nicht!");
                    } else {
                        double earnings = amount * s.price;
                        money += earnings;  // Geld hinzufügen
                        depot.put(s.name, owned - amount);
                        System.out.println("Verkauft: " + amount + "x " + s.name);
                    }
                }

                // -----------------------------
                // RUNDE BEENDEN → Kurse ändern sich
                // -----------------------------
                case 3 -> {
                    System.out.println("\nDie Kurse ändern sich...");
                    for (Stock s : stocks) {
                        s.updatePrice();
                    }
                }

                // -----------------------------
                // SPIEL BEENDEN
                // -----------------------------
                case 4 -> {
                    playing = false;
                }

                // Ungültige Eingabe
                default -> System.out.println("Ungültige Eingabe.");
            }
        }

        // ---------------------------------------
        // ENDABRECHNUNG
        // ---------------------------------------
        double depotWert = 0;

        // Wert aller Aktien im Depot berechnen
        for (Stock s : stocks) {
            depotWert += depot.get(s.name) * s.price;
        }

        // Ergebnisse anzeigen
        System.out.println("\n====== Spielende ======");
        System.out.printf("Restgeld: %.2f EUR\n", money);
        System.out.printf("Depotwert: %.2f EUR\n", depotWert);
        System.out.printf("Gesamtvermögen: %.2f EUR\n", (money + depotWert));
        System.out.println("========================");
    }
}
