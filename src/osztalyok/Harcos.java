package osztalyok;

public class Harcos extends Jatekos{

    public Harcos() {
        super("harcos",4);
    }

    @Override
    public String toString() {
        return "Harcos{" + "karakter=" + getKarakter() + ", eletero=" + getEletero() + ", utoero=" + getUtoero() + '}';
    }

    

}
