package osztalyok;

public class Varazslo extends Jatekos {

    public Varazslo() {
        super("varázsló", 3);
    }

    public void gyogyit() {
        if (getEletero() < 9) {
            setEletero(getEletero() + 1);
        }
    }

    @Override
    public String toString() {
        return "Varazslo{" + "karakter=" + getKarakter() + ", eletero=" + getEletero() + ", utoero=" + getUtoero() + '}';
    }

}
