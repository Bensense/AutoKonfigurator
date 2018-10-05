
import java.util.ArrayList;
import java.util.List;

public class Plattform {
    private String nameP;
    private int preisP;
    private List<Ausstattung> listeAusstattungen;

    public Plattform() {

    }
    public Plattform(String nameP, int preisP, String nameA, int preisA) {
        setNameP(nameP);
        setPreisP(preisP);
        listeAusstattungen = new ArrayList<>();
        Ausstattung a = new Ausstattung(nameA, preisA);
        listeAusstattungen.add(a);
    }

    public void addAusstattung(String nameA, int preisA) {
        Ausstattung a = new Ausstattung(nameA, preisA);
        listeAusstattungen.add(a);
    }
    public List<Ausstattung> returnListeAusstattung() {
        return this.listeAusstattungen;
    }
    public List<Ausstattung> getListeAusstattung() {
        int i = 0;
        for(Ausstattung a : this.listeAusstattungen) {
            System.out.println(i + " = " + a.getNameA() + "   \t\t Kosten: " + a.getPreisA());
            i++;
        }
        return this.listeAusstattungen;
    }
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