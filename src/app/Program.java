package app;

import java.util.Scanner;
import osztalyok.Harcos;
import osztalyok.Varazslo;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        String tipp = tippBekeres(sc);

        int korokSzama = jatek(harcos, varazslo);

        String gyoztes = eredmenyKiiras(harcos, varazslo, korokSzama);

        tippEllenorzes(tipp, gyoztes);
    }

    public static String tippBekeres(Scanner sc) {
        System.out.println("Szerinted ki fog nyerni(varazslo/harcos/dontetlen)?");
        System.out.print("Tipp: ");
        String tipp = sc.nextLine().trim().toLowerCase();
        while (!tipp.equals("varazslo") && !tipp.equals("harcos") && !tipp.equals("dontetlen")) {
            System.out.println("Helytelen tipp, próbáld újra!(varazslo/harcos/dontetlen)");
            System.out.print("Tipp: ");
            tipp = sc.nextLine().trim().toLowerCase();
        }
        return tipp;
    }

    public static int jatek(Harcos harcos, Varazslo varazslo) {
        int korokSzama = 0;

        System.out.println("\n🎮 Start 🎮");

        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {
            korokSzama++;
            egyKor(harcos, varazslo, korokSzama);
        }

        return korokSzama;
    }

    public static void kiirAllapot(Harcos harcos, Varazslo varazslo) {
        System.out.println("❤️ Harcos életerő: " + harcos.getEletero());
        System.out.println("❤️ Varázsló életerő: " + varazslo.getEletero());

        System.out.println("\n⚔️ Harcos mező: " + harcos.getLepes());
        System.out.println("✨ Varázsló mező: " + varazslo.getLepes());
    }

    public static void kiirPalya(Harcos harcos, Varazslo varazslo) {
        for (int i = 0; i < 3; i++) {
            if (harcos.getLepes() == i && varazslo.getLepes() == i) {
                System.out.print("[🔥] ");
            } else if (harcos.getLepes() == i) {
                System.out.print("[⚔️] ");
            } else if (varazslo.getLepes() == i) {
                System.out.print("[✨] ");
            } else {
                System.out.print("[ ] ");
            }
        }
        System.out.println();
    }

    public static void egyKor(Harcos harcos, Varazslo varazslo, int korSzam) {
        System.out.println("---------------");
        System.out.println("\n---------------");
        System.out.println(korSzam + ". KÖR");

        kiirAllapot(harcos, varazslo);
        kiirPalya(harcos, varazslo);

        if (harcos.getLepes() == varazslo.getLepes()) {
            harc(harcos, varazslo);
        }

        extraElet(harcos, varazslo);

        harcos.ujLepes();
        varazslo.ujLepes();
    }

    public static void harc(Harcos harcos, Varazslo varazslo) {
        System.out.println("---------------");
        System.out.println("🔥 HARC 🔥");
        System.out.println("---------------");

        varazslo.harcol(harcos);
        harcos.harcol(varazslo);

        System.out.println("✨ Varázsló ütő ereje: " + varazslo.getUtoero());
        System.out.println("⚔️ Harcos ütő ereje: " + harcos.getUtoero());

        if (varazslo.getEletero() > 0) {
            varazslo.gyogyit();
            System.out.println("❤️  A varázsló gyógyítja magát, plusz 1 élet");
        }
    }

    public static void extraElet(Harcos harcos, Varazslo varazslo) {
        if (harcos.extraElet()) {
            System.out.println("❤️ A harcos 1 extra életet kapott!");
        }

        if (varazslo.extraElet()) {
            System.out.println("❤️ A varázsló 1 extra életet kapott!");
        }
    }

    public static String eredmenyKiiras(Harcos harcos, Varazslo varazslo, int korok) {

        System.out.println("---------------");
        System.out.println("❤️ Harcos életerő: " + harcos.getEletero());
        System.out.println("❤️ Varázsló életerő: " + varazslo.getEletero());
        System.out.println("\n---------------");
        System.out.println("🏁 Játék vége 🏁");
        System.out.println("🎮 Lejátszott körök száma: " + korok);

        if (harcos.getEletero() == 0 && varazslo.getEletero() == 0) {
            System.out.println("⚖️ Döntetlen!");
            return "dontetlen";

        } else if (varazslo.getEletero() == 0) {
            System.out.println("⚔️ Harcos nyert!");
            return "harcos";

        } else {
            System.out.println("✨ Varázsló nyert!");
            return "varazslo";
        }
    }

    public static void tippEllenorzes(String tipp, String gyoztes) {
        if (gyoztes.equals(tipp)) {
            System.out.println("🏆 Gratulálok, jól tippeltél!");
        } else {
            System.out.println("😢 Sajnos nem talált a tipped!");
        }
    }
}
