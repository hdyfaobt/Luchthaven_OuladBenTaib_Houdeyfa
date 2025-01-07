package mensen;
import adres.Adres;



public abstract class Persoon {


    // basic attribt
    private String naam;
    private int leeftijd;
    private Adres adres;

    // cnstructor
    public Persoon(String naam, int leeftijd, Adres adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }


    //getter & setter
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }


    public abstract void toonDetails();


    @Override
    public String toString() {
        return "Naam: " + naam + ", Leeftijd: " + leeftijd + ", Adres: " + adres.toString();
    }



}

