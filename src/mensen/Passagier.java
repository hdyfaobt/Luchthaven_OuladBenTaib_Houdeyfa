package mensen;

import adres.Adres;

public class Passagier {
    private String naam;
    private int leeftijd;
    private Adres adres;
    private String ticket;
    private double bagageGewicht;
    private String klasse; // Toegevoegd attribuut

    public Passagier(String naam, int leeftijd, Adres adres, String ticket, double bagageGewicht, String klasse) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
        this.ticket = ticket;
        this.bagageGewicht = bagageGewicht;
        this.klasse = klasse; // Stel klasse in
    }

    // Getters en setters
    public String getNaam() {
        return naam;
    }

    public String getTicket() {
        return ticket;
    }

    public String getKlasse() { // Getter voor klasse
        return klasse;
    }

    public void setKlasse(String klasse) { // Setter voor klasse
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return "Passagier: " + naam + ", Ticket: " + ticket + ", Klasse: " + klasse;
    }
}
