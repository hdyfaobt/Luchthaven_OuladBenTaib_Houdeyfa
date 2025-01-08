package main;

import adres.Adres;
import mensen.Passagier;
import mensen.Personeel;
import vliegtuig.Vliegtuig;

public class Main {
    public static void main(String[] args) {


        // Maak Adres objecten aan
        Adres adresHoudeyfa = new Adres(13, "Rue de la Tannerie", "1081", "Koekelberg");
        Adres adresRonaldo = new Adres(7, "Rua de Portugal", "4000", "Lisboa");
        Adres adresYana = new Adres(20, "Avenue des Pilotes", "1050", "Bruxelles");
        Adres adresRania = new Adres(52, "Stationsstraat", "1831", "Diegem");

        // Maak Passagier
        Passagier[] passagiers = {
                new Passagier("Houdeyfa Oulad", 20, adresHoudeyfa, "TNG-LON", 23.0, "economy"),
                new Passagier("Hamid Oulad", 51, adresHoudeyfa, "TNG-LON", 25.0, "economy"),
                new Passagier("Cristiano Ronaldo", 37, adresRonaldo, "TNG-LON", 20.0, "business"),
                new Passagier("Georgina Rodriguez", 29, adresRonaldo, "TNG-RAK", 18.0, "business"),
                new Passagier("Lionel Messi", 36, adresRonaldo, "TNG-LON", 19.0, "economy"),
                new Passagier("Kylian Mbappé", 24, adresRonaldo, "TNG-LON", 21.0, "business"),
                new Passagier("Ibrahima Konate", 40, adresRonaldo, "TNG-LON", 20.0, "economy"),
                new Passagier("Neymar Jr", 31, adresRonaldo, "TNG-LON", 22.0, "business"),
                new Passagier("Antoine Griezmann", 32, adresRonaldo, "TNG-LON", 21.0, "economy"),
                new Passagier("Luis Suarez", 36, adresRonaldo, "TNG-LON", 23.0, "economy"),
                new Passagier("Sergio Ramos", 37, adresRonaldo, "TNG-LON", 19.0, "economy"),
                new Passagier("Zlatan Ibrahimovic", 42, adresRonaldo, "TNG-LON", 22.0, "business"),
                new Passagier("Paul Pogba", 30, adresRonaldo, "TNG-LON", 20.0, "economy"),
                new Passagier("Eden Hazard", 32, adresRonaldo, "TNG-LON", 18.0, "economy"),
                new Passagier("Kevin De Bruyne", 31, adresRonaldo, "TNG-LON", 19.0, "economy"),
                new Passagier("Indiana Jones", 41, adresRonaldo, "TNG-LON", 19.0, "business"),
                new Passagier("Romelu Lukaku", 30, adresRonaldo, "TNG-LON", 21.0, "economy"),
                new Passagier("Thierry Henry", 46, adresRonaldo, "TNG-LON", 23.0, "business"),
                new Passagier("Didier Drogba", 45, adresRonaldo, "TNG-LON", 22.0, "business"),
                new Passagier("Frank Lampard", 45, adresRonaldo, "TNG-LON", 24.0, "economy"),
                new Passagier("Steven Gerrard", 44, adresRonaldo, "TNG-LON", 20.0, "economy"),
                new Passagier("John Terry", 43, adresRonaldo, "TNG-LON", 21.0, "business")

        };

        // Maak Personeel
        Personeel[] personeel = {
                new Personeel("Jedo", 35, adresYana, "Piloot", "TNG-LON"),
                new Personeel("Basidi", 40, adresYana, "Piloot", "TNG-LON"),
                new Personeel("Rania", 20, adresRania, "Steward", "TNG-LON"),
                new Personeel("Sirine", 25, adresRania, "Steward", "TNG-LON"),
                new Personeel("Leyssa", 27, adresRania, "Steward", "TNG-LON"),
                new Personeel("Assia", 30, adresRania, "Steward", "TNG-LON")
        };

        // Maak een Vliegtuig object aan
        Vliegtuig vliegtuig = new Vliegtuig("TNG", "LON", 5, 15);

        // Voeg passagiers toe op basis van hun klasse
        System.out.println("\n=== Passagiers toevoegen ===");
        for (Passagier passagier : passagiers) {
            vliegtuig.voegPassagierToe(passagier, passagier.getKlasse());
        }

        // Voeg personeel toe
        System.out.println("\n=== Personeel toevoegen ===");
        for (Personeel p : personeel) {
            vliegtuig.voegPersoneelToeMetLimiet(p, p.getFunctie().equals("Piloot") ? 2 : 4);
        }

        // Stel flightchecks in
        vliegtuig.setFlightChecks(true);

        // Controleer of het vliegtuig klaar is voor opstijgen
        System.out.println("\nKlaar voor opstijgen: " + vliegtuig.isKlaarVoorOpstijgen());

        // Print details van het vliegtuig
        System.out.println("\n=== Vliegtuig Details ===");
        System.out.println(vliegtuig);

        // Toon passagiersdetails
        System.out.println("\n=== Passagiers Details ===");
        for (Passagier passagier : vliegtuig.getPassagiers()) {
            System.out.println(passagier);
        }
    }
}
