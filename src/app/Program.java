package app;

import java.util.Scanner;
import osztalyok.Harcos;
import osztalyok.Varazslo;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        int korokSzama = 0;

        System.out.println("Szerinted ki fog nyerni(varazslo/harcos/dontetlen)?");
        System.out.print("Tipp: ");
        String tipp = sc.nextLine().trim().toLowerCase();

        while (!tipp.equals("varazslo") && !tipp.equals("harcos") && !tipp.equals("dontetlen")) {
            System.out.println("Helytelen tipp, próbáld újra!(varazslo/harcos/dontetlen)");
            System.out.print("Tipp: ");
            tipp = sc.nextLine().trim().toLowerCase();
        }

        System.out.println("\n🎮 Start 🎮");

        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {
            korokSzama++;
            System.out.println("---------------");
            System.out.println("\n---------------");
            System.out.println(korokSzama + ". KÖR");
            System.out.println("❤️ Harcos életerő: " + harcos.getEletero());
            System.out.println("❤️ Varázsló életerő: " + varazslo.getEletero());

            System.out.println("\n⚔️ Harcos mező: " + harcos.getLepes());
            System.out.println("✨ Varázsló mező: " + varazslo.getLepes());

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
            System.out.println("");

            if (harcos.getLepes() == varazslo.getLepes()) {
                
                System.out.println("\n*********");
                System.out.println("🔥 HARC 🔥");
                System.out.println("*********\n");
                
                varazslo.harcol(harcos);
                harcos.harcol(varazslo);
                
                System.out.println("✨ A varázsló ütő ereje: " + varazslo.getUtoero());
                System.out.println("⚔️ A harcos ütő ereje: " + harcos.getUtoero());

                if (varazslo.getEletero() > 0) {
                    varazslo.gyogyit();
                    System.out.println("❤️ A varázsló gyógyítja magát, plusz 1 élet");
                }
            }

            if (harcos.extraElet()) {
                System.out.println("---------------");
                System.out.println("❤️ A harcos 1 extra életet kapott!");
            }
            
            if (varazslo.extraElet()) {
                System.out.println("---------------");
                System.out.println("❤️ A varázsló 1 extra életet kapott!");
            }

            harcos.ujLepes();
            varazslo.ujLepes();

        }

        System.out.println("---------------");
        System.out.println("❤️ Harcos életerő: " + harcos.getEletero());
        System.out.println("❤️ Varázsló életerő: " + varazslo.getEletero());

        System.out.println("---------------");
        System.out.println("🏁 Játék vége 🏁");
        System.out.println("\n🎮 Lejátszott körök száma: " + korokSzama);

        String gyoztes;
        if (harcos.getEletero() == 0 && varazslo.getEletero() == 0) {
            System.out.println("⚖️ Döntetlen!");
            gyoztes = "dontetlen";
        } else if (varazslo.getEletero() == 0) {
            System.out.println("⚔️ A harcos győzött!");
            gyoztes = "harcos";
        } else {
            System.out.println("✨ A varázsló győzőtt!");
            gyoztes = "varazslo";
        }

        if (gyoztes.equals(tipp)) {
            System.out.println("🏆 Gratulálok, jól tippeltél!");
        } else {
            System.out.println("😢 Sajnos nem talált a tipped!");
        }
    }

}
