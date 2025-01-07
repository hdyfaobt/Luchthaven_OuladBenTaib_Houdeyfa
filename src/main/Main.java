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

        // Maak Passagier objecten aan
        Passagier houdeyfa = new Passagier("Houdeyfa Oulad", 20, adresHoudeyfa, "TNG-LON", 23.0);
        Passagier hamid = new Passagier("Hamid Oulad", 51, adresHoudeyfa, "TNG-LON", 25.0);
        Passagier ronaldo = new Passagier("Cristiano Ronaldo", 37, adresRonaldo, "TNG-LON", 20.0);
        Passagier partnerRonaldo = new Passagier("Georgina Rodriguez", 29, adresRonaldo, "TNG-LON", 18.0);

        // Maak Personeel objecten aan
        Personeel piloot = new Personeel("Yana L'Pilote", 35, adresYana, "Piloot");
        Personeel steward = new Personeel("Rania Al Steward", 20, adresRania, "Steward");

        // Maak een Vliegtuig object aan
        Vliegtuig vliegtuig = new Vliegtuig("TNG", "LON", 2, 3);

        // Voeg passagiers toe
        vliegtuig.voegPassagierToe(houdeyfa, "economy");
        vliegtuig.voegPassagierToe(hamid, "economy");
        vliegtuig.voegPassagierToe(ronaldo, "business");
        vliegtuig.voegPassagierToe(partnerRonaldo, "business");

        // Voeg personeel toe
        vliegtuig.voegPersoneelToe(piloot);
        vliegtuig.voegPersoneelToe(steward);

        // Stel flightchecks in
        vliegtuig.setFlightChecks(true);

        // Controleer of het vliegtuig klaar is voor opstijgen
        System.out.println("Klaar voor opstijgen: " + vliegtuig.isKlaarVoorOpstijgen());

        // Print details van het vliegtuig
        System.out.println(vliegtuig);

        // Print details van passagiers
        System.out.println("\n=== Passagiers Details ===");
        for (Passagier passagier : vliegtuig.getPassagiers()) {
            System.out.println(passagier);
        }

        // Print details van personeel
        System.out.println("\n=== Personeel Details ===");
        for (Personeel persoon : vliegtuig.getPersoneel()) {
            System.out.println(persoon);
        }
    }
}
