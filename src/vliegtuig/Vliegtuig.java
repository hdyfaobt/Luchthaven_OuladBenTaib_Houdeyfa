package vliegtuig;

import mensen.Passagier;
import mensen.Personeel;
import java.util.ArrayList;
import java.util.List;

public class Vliegtuig {

    // Attributen
    private String vertrekLocatie;
    private String aankomstLocatie;
    private int businessPlaatsen;
    private int economyPlaatsen;
    private List<Passagier> passagiers;
    private List<Personeel> personeel;
    private boolean flightChecks;

    // Constructor
    public Vliegtuig(String vertrekLocatie, String aankomstLocatie, int businessPlaatsen, int economyPlaatsen) {
        this.vertrekLocatie = vertrekLocatie;
        this.aankomstLocatie = aankomstLocatie;
        this.businessPlaatsen = businessPlaatsen;
        this.economyPlaatsen = economyPlaatsen;
        this.passagiers = new ArrayList<>();
        this.personeel = new ArrayList<>();
        this.flightChecks = false;
    }

    // Getters en setters
    public String getVertrekLocatie() {
        return vertrekLocatie;
    }

    public void setVertrekLocatie(String vertrekLocatie) {
        this.vertrekLocatie = vertrekLocatie;
    }

    public String getAankomstLocatie() {
        return aankomstLocatie;
    }

    public void setAankomstLocatie(String aankomstLocatie) {
        this.aankomstLocatie = aankomstLocatie;
    }

    public int getBusinessPlaatsen() {
        return businessPlaatsen;
    }

    public void setBusinessPlaatsen(int businessPlaatsen) {
        this.businessPlaatsen = businessPlaatsen;
    }

    public int getEconomyPlaatsen() {
        return economyPlaatsen;
    }

    public void setEconomyPlaatsen(int economyPlaatsen) {
        this.economyPlaatsen = economyPlaatsen;
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    public void setPassagiers(List<Passagier> passagiers) {
        this.passagiers = passagiers;
    }

    public List<Personeel> getPersoneel() {
        return personeel;
    }

    public void setPersoneel(List<Personeel> personeel) {
        this.personeel = personeel;
    }

    public boolean isFlightChecks() {
        return flightChecks;
    }

    public void setFlightChecks(boolean flightChecks) {
        this.flightChecks = flightChecks;
    }

    // Methodes

    public boolean controleerTicket(Passagier passagier) {
        if (passagier == null) {
            System.out.println("Passagier is ongeldig!");
            return false;
        }

        if (passagier.getTicket().contains(vertrekLocatie) && passagier.getTicket().contains(aankomstLocatie)) {
            return true;
        }
        System.out.println("NOT Passagier " + passagier.getNaam() + " heeft een verkeerd ticket! Gegeven ticket: " + passagier.getTicket());
        return false;
    }

    public boolean voegPassagierToe(Passagier passagier, String klasse) {
        if (!controleerTicket(passagier)) {
            System.out.println("NOT Passagier " + passagier.getNaam() + " ticket is niet geldig");
            return false;
        }

        if ("business".equalsIgnoreCase(klasse) && businessPlaatsen > 0) {
            passagiers.add(passagier);
            businessPlaatsen--;
            System.out.println("OK  Passagier " + passagier.getNaam() + " succesvol ingeschreven in " + klasse + " klasse.");
            return true;
        } else if ("economy".equalsIgnoreCase(klasse) && economyPlaatsen > 0) {
            passagiers.add(passagier);
            economyPlaatsen--;
            System.out.println("OK  Passagier " + passagier.getNaam() + " succesvol ingeschreven in " + klasse + " klasse.");
            return true;
        } else {
            System.out.println("NOT Geen beschikbare plaatsen in de " + klasse + " klasse, voor passagier: " + passagier.getNaam());
            return false;
        }
    }

    // Voeg personeel toe met limietcontrole
    public boolean voegPersoneelToeMetLimiet(Personeel persoon, int maxAantalPerFunctie) {
        long aantalMetFunctie = personeel.stream()
                .filter(p -> p.getFunctie().equalsIgnoreCase(persoon.getFunctie()))
                .count();

        if (aantalMetFunctie >= maxAantalPerFunctie) {
            System.out.println("FOUT: Het maximum aantal " + persoon.getFunctie() + "s (" + maxAantalPerFunctie + ") is al bereikt.");
            return false;
        }

        personeel.add(persoon);
        System.out.println("OK: Persoon " + persoon.getNaam() + " toegevoegd als " + persoon.getFunctie());
        return true;
    }

    // Methode om personeel te tonen
    public void toonPersoneel() {
        if (personeel.isEmpty()) {
            System.out.println("Er is geen personeel toegewezen aan dit vliegtuig.");
        } else {
            System.out.println("Lijst van personeel:");
            for (Personeel persoon : personeel) {
                System.out.println("- " + persoon.getNaam() + " (" + persoon.getFunctie() + ")");
            }
        }
    }

    public boolean isKlaarVoorOpstijgen() {
        if (personeel.isEmpty()) {
            System.out.println("Niet genoeg personeel aanwezig.");
            return false;
        }

        boolean heeftPiloot = personeel.stream().anyMatch(p -> p.getFunctie().equalsIgnoreCase("Piloot"));
        if (!heeftPiloot) {
            System.out.println("Er is geen piloot aanwezig.");
            return false;
        }

        if (!flightChecks) {
            System.out.println("Flightchecks zijn niet in orde.");
            return false;
        }

        System.out.println("Vliegtuig is klaar voor opstijgen!");
        return true;
    }

    @Override
    public String toString() {
        return "Vliegtuig van " + vertrekLocatie + " naar " + aankomstLocatie + ", Business plaatsen: " + businessPlaatsen + ", Economy plaatsen: " + economyPlaatsen + ", Aantal passagiers: " + passagiers.size() + ", Aantal personeel: " + personeel.size();
    }


}
