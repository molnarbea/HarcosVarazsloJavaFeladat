package osztalyok;

public class Harcos extends Jatekos{

    public Harcos() {
        super(Karakter.HARCOS,4);
    }

    @Override
    public String toString() {
        return "Harcos{" + "karakter=" + getKarakter() + ", eletero=" + getEletero() + ", utoero=" + getUtoero() + '}';
    }

    

}
