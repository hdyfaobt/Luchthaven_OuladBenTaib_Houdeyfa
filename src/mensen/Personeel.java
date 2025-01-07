package mensen;
import adres.Adres;

public class Personeel extends Persoon{

private String functie;

    public Personeel(String naam, int leeftijd, Adres adres, String functie) {
        super(naam, leeftijd, adres);
        this.functie = functie;
    }

//get&set
    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
//override
    @Override
    public void toonDetails() {
        System.out.println("Personeel details: " + toString() + ", Functie: " + functie);
    }
}
