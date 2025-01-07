package adres;

public class Adres {
    private int nummer;       // Numéro de rue
    private String straatNaam; // Nom de la rue
    private String postCode;   // Code postal
    private String woonplaats; // Ville

    // Constructeur
    public Adres(int nummer, String straatNaam, String postCode, String woonplaats) {
        this.nummer = nummer;
        this.straatNaam = straatNaam;
        this.postCode = postCode;
        this.woonplaats = woonplaats;
    }

    // Getters
    public int getNummer() {
        return nummer;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    // Setters
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    // Méthode toString() pour afficher l'adresse sous forme de texte
    @Override
    public String toString() {
        return nummer + " " + straatNaam + ", " + postCode + " " + woonplaats;
    }
}
