package org.hammerle.itk.pos1.mavenAutoKonfigurator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Hammerle
 * @version 10.10.2018
 */
public class Plattform {
    /**
     * Name der Plattform
     */
    private String nameP;
    /**
     * Preis der Plattform
     */
    private int preisP;
    /**
     * Liste der Ausstattungen fuer Plattform
     */
    private List<Ausstattung> listeAusstattungen;

    /**
     * Konstruktor Plattform
     * @param nameP Name der Plattform
     * @param preisP Preis der Plattform
     * @param nameA Name einer Ausstattung
     * @param preisA Preis einer Ausstattung
     */
    public Plattform(String nameP, int preisP, String nameA, int preisA) {
        setNameP(nameP);
        setPreisP(preisP);
        listeAusstattungen = new ArrayList<>();
        Ausstattung a = new Ausstattung(nameA, preisA);
        listeAusstattungen.add(a);
    }

    /**
     * Ausstattung in ListeAusstattungen hinzufuegen
     * @param nameA
     * @param preisA
     */
    public void addAusstattung(String nameA, int preisA) {
        Ausstattung a = new Ausstattung(nameA, preisA);
        listeAusstattungen.add(a);
    }

    /**
     * gibt ListeAusstattungen retour
     * @return ListeAusstattungen
     */
    public List<Ausstattung> returnListeAusstattung() {
        return this.listeAusstattungen;
    }

    /**
     * gibt Liste Ausstattungen aus
     * @return ListeAusstattungen
     */
    public List<Ausstattung> getListeAusstattung() {
        int i = 0;
        for(Ausstattung a : this.listeAusstattungen) {
            System.out.println(i + " = " + a.getNameA() + "   \t\t Kosten: " + a.getPreisA());
            i++;
        }
        return this.listeAusstattungen;
    }

    /**
     * gibt Ausstattung aus ListeAusstattungen zurueck
     * @param index
     * @return Ausstattung
     */
    public Ausstattung getAusstattung(int index) {
        return listeAusstattungen.get(index);
    }
    public void setNameP(String nameP) {
        this.nameP = nameP;
    }
    public String getNameP() {
        return this.nameP;
    }
    public void setPreisP(int preisP) {
        this.preisP = preisP;
    }
    public int getPreisP() {
        return this.preisP;
    }

}