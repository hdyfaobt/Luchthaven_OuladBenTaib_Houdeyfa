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
        System.out.println("Passagier heeft een verkeerd ticket! Gegeven ticket: " + passagier.getTicket());
        return false;
    }

    public boolean voegPassagierToe(Passagier passagier, String klasse) {
        if (!controleerTicket(passagier)) {
            System.out.println("Passagier ticket is niet geldig");
            return false;
        }

        if ("business".equalsIgnoreCase(klasse) && businessPlaatsen > 0) {
            passagiers.add(passagier);
            businessPlaatsen--;
            System.out.println("Passagier " + passagier.getNaam() + " succesvol ingeschreven in " + klasse + " klasse.");
            return true;
        } else if ("economy".equalsIgnoreCase(klasse) && economyPlaatsen > 0) {
            passagiers.add(passagier);
            economyPlaatsen--;
            System.out.println("Passagier " + passagier.getNaam() + " succesvol ingeschreven in " + klasse + " klasse.");
            return true;
        } else {
            System.out.println("Geen beschikbare plaatsen in de " + klasse + " klasse.");
            return false;
        }
    }

    public void voegPersoneelToe(Personeel persoon) {
        personeel.add(persoon);
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
