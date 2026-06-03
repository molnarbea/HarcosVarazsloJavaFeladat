package app;

import java.util.Scanner;
import osztalyok.Harcos;
import osztalyok.Varazslo;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();
        
        int korokSzama=0;

        System.out.println("Szerinted ki fog nyerni(varazslo/harcos/dontetlen)?");
        System.out.print("Tipp: ");
        String tipp = sc.nextLine().trim().toLowerCase();
        
        while(!tipp.equals("varazslo") && !tipp.equals("harcos") && !tipp.equals("dontetlen")){
            System.out.println("Helytelen tipp, próbáld újra!(varazslo/harcos/dontetlen)");
            System.out.print("Tipp: ");
            tipp = sc.nextLine().trim().toLowerCase();
        }

        System.out.println("Start");
        System.out.println("---------------");

        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {

            System.out.println("Harcos életerõ: " + harcos.getEletero());
            System.out.println("Varázsló életerõ: " + varazslo.getEletero());
          
            System.out.println("Harcos mezõ: " + harcos.getLepes());
            System.out.println("Varázsló mezõ: " + varazslo.getLepes());
            
            for (int i = 0; i < 3; i++) {
                if (harcos.getLepes() == i && varazslo.getLepes() == i) {
                    System.out.print("[X] ");
                } else if (harcos.getLepes() == i) {
                    System.out.print("[H] ");
                } else if (varazslo.getLepes() == i) {
                    System.out.print("[V] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println("");

            System.out.println("---------------");
            if (harcos.getLepes() == varazslo.getLepes()) {
                System.out.println("HARC!");
                System.out.println("---------------");
                varazslo.harcol(harcos);
                harcos.harcol(varazslo);
                if (varazslo.getEletero() > 0) {
                    varazslo.gyogyit();
                }
            }

            if(harcos.extraElet()){
                System.out.println("A harcos 1 extra életet kapott!");
            }
            if(varazslo.extraElet()){
                System.out.println("A varázsló 1 extra életet kapott!");
            }

            harcos.ujLepes();
            varazslo.ujLepes();
            korokSzama++;
        }

        System.out.println("Harcos életerõ: " + harcos.getEletero());
        System.out.println("Varázsló életerõ: " + varazslo.getEletero());

        System.out.println("---------------");
        System.out.println("Játék vége");
        System.out.println("Lejátszott körök száma: " + korokSzama);

        String gyoztes;
        if (harcos.getEletero() == 0 && varazslo.getEletero() == 0) {
            System.out.println("Döntetlen!");
            gyoztes = "dontetlen";
        } else if (varazslo.getEletero() == 0) {
            System.out.println("A harcos gyõzött!");
            gyoztes = "harcos";
        } else {
            System.out.println("A varázsló gyõzõtt!");
            gyoztes = "varazslo";
        }

        if (gyoztes.equals(tipp)) {
            System.out.println("Gratulálok, jól tippeltél!");
        } else {
            System.out.println("Sajnos nem talált a tipped!");
        }
    }

}
