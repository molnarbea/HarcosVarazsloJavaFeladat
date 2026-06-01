package app;

import java.util.Scanner;
import osztalyok.Harcos;
import osztalyok.Varazslo;

public class Program {
    
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Harcos harcos = new Harcos();
        Varazslo varazslo = new Varazslo();

        System.out.println("Start");
        System.out.println("---------------");

        while (harcos.getEletero() > 0 && varazslo.getEletero() > 0) {

            System.out.println("Harcos életerõ: " + harcos.getEletero());
            System.out.println("Varázsló életerõ: " + varazslo.getEletero());
            System.out.println("Harcos mezõ: " + harcos.getLepes());
            System.out.println("Varázsló mezõ: " + varazslo.getLepes());

            System.out.println("---------------");
            if (harcos.getLepes() == varazslo.getLepes()) {
                System.out.println("HARC!");
                System.out.println("---------------");
                varazslo.harcol(harcos);
                harcos.harcol(varazslo);
                if(varazslo.getEletero()>0){
                    varazslo.gyogyit();
                }
            }
            
            varazslo.extraElet();
            harcos.extraElet();
            
            harcos.ujLepes();
            varazslo.ujLepes();
        }

        System.out.println("Harcos életerõ: " + harcos.getEletero());
        System.out.println("Varázsló életerõ: " + varazslo.getEletero());
        
        System.out.println("---------------");
        System.out.println("Játék vége");
        
        if(harcos.getEletero() == 0 && varazslo.getEletero() == 0){
            System.out.println("Döntetlen!");
        }else if(varazslo.getEletero() == 0){
            System.out.println("A harcos gyõzött!");
        }else{
            System.out.println("A varázsló gyõzõtt!");
        }
    }

}
