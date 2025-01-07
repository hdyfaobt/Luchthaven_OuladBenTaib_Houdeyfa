package main;
import adres.Adres;
import mensen.Passagier;
import mensen.Personeel;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }





    Adres adresHamid = new Adres(13, "rue de la tannerie", "1081", "Koekeleberg");
    Adres adresRania = new Adres(52, "Stationsstraat", "1831", "Diegem");

    // Créer un Passagier avec un ticket et un bagage
    Passagier passagier1 = new Passagier("Hamid", 51, adresHamid, "FLY0512", 15.5);

    // Créer un objet Personeel avec une fonction spécifique
    Personeel piloot = new Personeel("Rania", 20, adresRania, "Piloot");




































}