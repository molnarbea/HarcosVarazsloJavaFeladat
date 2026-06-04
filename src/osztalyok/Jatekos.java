package osztalyok;

import java.util.Objects;
import java.util.Random;

public class Jatekos {

    private final Random rnd = new Random();

    private Karakter karakter;
    private int eletero = 9;
    private int utoero;
    private int lepes;

    public Jatekos(Karakter karakter, int utoero) {
        if (karakter == null) {
            throw new IllegalArgumentException("A karakter nem lehet null!");
        }
        if (utoero <= 0) {
            throw new IllegalArgumentException("Az ütőerő legyen nagyobb mint 0!");
        }
        
        this.karakter = karakter;
        this.utoero = utoero;
        this.lepes = rnd.nextInt(0, 3);
    }

    public Karakter getKarakter() {
        return karakter;
    }

    public int getEletero() {
        return eletero;
    }

    public int getUtoero() {
        return utoero;
    }

    public int getLepes() {
        return lepes;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public void harcol(Jatekos ellenfel) {
        if (ellenfel == null) {
            throw new IllegalArgumentException("Az ellenfél nem lehet null!");
        }

        int sebzes = ellenfel.getUtoero();
        int ujEletero = this.eletero - sebzes;

        if (ujEletero < 0) {
            ujEletero = 0;
        }

        this.eletero = ujEletero;
    }

    public boolean extraElet() {
        boolean extraElet=false;
        int esely = rnd.nextInt(0, 100);

        if (this.eletero < 9 && this.eletero > 0) {
            if (esely < 20) {
                this.eletero++;
                extraElet = true;
            }
        }
        
        return extraElet;
    }

    public void ujLepes() {
        this.lepes = rnd.nextInt(0, 3);
    }

    @Override
    public String toString() {
        return "Jatekos{karakter=" + karakter + ", eletero=" + eletero + ", utoero=" + utoero + ", lepes=" + lepes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.karakter);
        hash = 43 * hash + this.eletero;
        hash = 43 * hash + this.utoero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jatekos other = (Jatekos) obj;
        if (this.eletero != other.eletero) {
            return false;
        }
        if (this.utoero != other.utoero) {
            return false;
        }
        return this.karakter == other.karakter;
    }
}
