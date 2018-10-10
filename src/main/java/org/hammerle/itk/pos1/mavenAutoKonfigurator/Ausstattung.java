package org.hammerle.itk.pos1.mavenAutoKonfigurator;

/**
 * @author Benjamin Hammerle
 * @version 10.10.2018
 */
public class Ausstattung {
    /**
     * Name der Ausstattung
     */
    private String nameA;
    /**
     * Preis der Ausstattung
     */
    private int preisA;


    /**
     * Konstruktor Ausstattung
     * @param nameA der Ausstattung
     * @param preisA der Ausstattung
     */
    public Ausstattung(String nameA, int preisA) {
        setNameA(nameA);
        setPreisA(preisA);
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public void setPreisA(int preisA) {
        this.preisA = preisA;
    }
    public String getNameA() {
        return this.nameA;
    }
    public int getPreisA() {
        return this.preisA;
    }
}