
public class Ausstattung {
    private String nameA;
    private int preisA;

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