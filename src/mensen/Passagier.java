package mensen;
import adres.Adres;



public class Passagier extends Persoon{


    public Passagier(String naam, int leeftijd, Adres adres) {
        super(naam, leeftijd, adres);
    }

    //attriubuts
    private String ticket;
    private double bagageGewicht;

    public Passagier(String naam, int leeftijd, Adres adres, String ticket, double bagageGewicht) {

        super(naam, leeftijd, adres);
        this.ticket = ticket;
        this.bagageGewicht = bagageGewicht;
    }


    //get&set
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getBagageGewicht() {
        return bagageGewicht;
    }

    public void setBagageGewicht(double bagageGewicht) {
        this.bagageGewicht = bagageGewicht;
    }

    //override
    @Override
    public void toonDetails(){
        System.out.println("Info passagier: " + toString() + ", Ticket nummer " + ticket + ", BagageGewicht: " + bagageGewicht);
    }








































}
