package org.hammerle.itk.pos1.mavenAutoKonfigurator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Benjamin Hammerle
 * @version 10.10.2018
 */
public class Menue implements AutoKonfigurator {
    /**
     * Liste der Plattformen
     */
    private List<Plattform> listePlattformen;
    Scanner scan = new Scanner(System.in);

    /**
     * Konstruktor Menue
     */
    public Menue() {
        listePlattformen = new ArrayList<>();
        fuelleMenue();
    }

    /**
     * Methode fuer Scanner-Eingabe mit Fehler-Ueberpruefung
     * @return Integer
     */
    public int intEingabe() {
        int eingabe = 0;
        boolean korrekt = false;
        do{
            korrekt = true;
            System.out.print("Eingabe: ");
            try {
                eingabe = scan.nextInt();
            }
            catch(InputMismatchException e) {
                scan.next();
                System.out.println("Falsche Eingabe");
                korrekt = false;
            }
        }while(korrekt==false);

        return eingabe;
    }

    /**
     * Methode fuegt eine Plattform hinzu
     * @param plattform
     */
    public void addPlattform(Plattform plattform) {
        this.listePlattformen.add(plattform);
    }

    /**
     * gibt Liste Plattformen aus
     * @return listePlattformen
     */
    public List<Plattform> getListePlattformen() {
        int i = 0;
        for(Plattform pf : this.listePlattformen) {
            System.out.println(i + " = " + pf.getNameP() + "\t\t\t\t Kosten: "+ pf.getPreisP());
            i++;
        }
        return this.listePlattformen;
    }

    /**
     * gibt Liste Plattformen zurueck
     * @return listePlattformen
     */
    public List<Plattform> returnListePlattformen() {
        return this.listePlattformen;
    }

    /**
     * gibt Plattform aus liste zurueck via Index
     * @param index
     * @return plattform
     */
    public Plattform getPlattform(int index) {
        return this.listePlattformen.get(index);
    }

    /**
     * Untermenue Plattform auswaehlen
     * @return Plattform
     */
    public Plattform waehlePlattform() {
        Plattform bestellung = null;
        int auswahl;

        System.out.println("******************************************************");
        System.out.println("Plattform auswaehlen");
        getListePlattformen();
        System.out.println("---------------------");
        System.out.println("9 = BEENDEN");
        System.out.println();
        auswahl = intEingabe();
        System.out.println();

        if(auswahl>=0 && auswahl<returnListePlattformen().size()) {
            bestellung = getPlattform(auswahl);
            waehleAusstattung(bestellung);
        }
        else if(auswahl==9) {
            System.out.println("Auf WIedersehen!");
            System.exit(0);
        }
        else {
            System.out.println("Eingabe ungueltig!");
            waehlePlattform();
        }
        return bestellung;
    }

    /**
     * Untermenue Ausstattung auswaehlen
     * @param plattform
     * @return Ausstattung
     */
    public Ausstattung waehleAusstattung(Plattform plattform) {
        Ausstattung bestellung = null;
        int auswahl;
        boolean pruef = false;
        System.out.println("******************************************************");
        System.out.println("Plattform: " + plattform.getNameP() + "\t\t\t Kosten: "+ plattform.getPreisP());
        System.out.println();
        System.out.println("Ausstattung waehlen:");
        plattform.getListeAusstattung();
        System.out.println("---------------------");
        System.out.println("8 = Plattform aendern");
        System.out.println("9 = BEENDEN");
        System.out.println();
        auswahl = intEingabe();
        System.out.println();

        if(auswahl>=0 && auswahl<plattform.returnListeAusstattung().size()){
            bestellung = plattform.getAusstattung(auswahl);
            pruefBestellung(plattform, bestellung);
        }
        else if(auswahl == 8){
            waehlePlattform();
        }
        else if(auswahl == 9){
            System.out.println("Auf Wiedersehen!");
            System.exit(0);
        }
        else {
            System.out.println("Eingabe ungueltig!");
            waehleAusstattung(plattform);
        }
        return bestellung;
    }

    /**
     * Untermenue Bestellung ueberpruefen, aendern, abschicken, beenden
     * @param auto
     * @param model
     */
    public void pruefBestellung(Plattform auto, Ausstattung model){
        int eingabe;
        int kostenGesamt;
        int lieferZeit = 14;                         // in Tagen
        LocalDate bestellDatum = LocalDate.now();
        LocalDate lieferDatum = bestellDatum.plus(lieferZeit, ChronoUnit.DAYS);
        System.out.println("********************************************************");
        System.out.println("Plattform: " + auto.getNameP()+ "\t\t\t Kosten: " + auto.getPreisP());
        System.out.println("Ausstattung: " + model.getNameA() + "\t\t Kosten: " + model.getPreisA());
        kostenGesamt = auto.getPreisP() + model.getPreisA();
        System.out.println("GESAMT:     \t\t\t\t Kosten: " + kostenGesamt);
        System.out.println("Bestelldatum: " + bestellDatum);
        System.out.println("Lieferdatum:  " + lieferDatum);
        System.out.println("********************************************************");

        System.out.println();
        System.out.println("1 = Plattform aendern");
        System.out.println("2 = Ausstattung aendern");
        System.out.println("-----------------------------");
        System.out.println("8 = Bestellung abschicken");
        System.out.println("9 = BEENDEN");
        System.out.println();
        eingabe = intEingabe();
        System.out.println();

        switch(eingabe) {
            case 1:
                waehlePlattform();
                break;
            case 2:
                waehleAusstattung(auto);
                break;
            case 8:
                System.out.println("Vielen Dank fuer Ihre Bestellung");
                // break;
            case 9:
                System.out.println("Auf Wiedersehen!");
                System.exit(0);
                break;
            default:
                System.out.println("Eingabe ungueltig");
                pruefBestellung(auto, model);
                break;
        }
    }

    /**
     * fuellt ListePlattformen mit Plattformen und dazugehoerigen Ausstattungen
     */
    public void fuelleMenue() {

        Plattform golf = new Plattform("Golf", 10000, "Sport", 2000);
        golf.addAusstattung("Luxus", 3500);
        golf.addAusstattung("Minimal", 500);
        addPlattform(golf);
        Plattform passat = new Plattform("Passat", 12000, "Limosine", 3000);
        passat.addAusstattung("Standart", 0);
        passat.addAusstattung("All Incl", 4000);
        passat.addAusstattung("Sport" , 3600);
        addPlattform(passat);
        Plattform sharan = new Plattform("Sharan", 14000, "Luxus", 5000);
        sharan.addAusstattung("Standart", 0);
        sharan.addAusstattung("Sport", 3500);
        addPlattform(sharan);

    }

}