package Week5.denemeler;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new LinkedList<>();


        long baslangic = 0;
        long bitis =0;

        baslangic = System.currentTimeMillis();
        for(int i =0; i <100000 ; i++){

            a.add(i);

        }
        bitis =System.currentTimeMillis();
        System.out.println("ArrayList" + " sure: " + (bitis - baslangic ));

        baslangic = System.currentTimeMillis();
        for(int i =0; i <100000 ; i++){

            b.add(i);

        }
        bitis =System.currentTimeMillis();
        System.out.println("LinkedHashSet" + " sure: " + (bitis - baslangic ));
        a.clear();
        b.clear();

        baslangic = System.currentTimeMillis();
        for(int i =0; i <100000 ; i++){

            a.add(0,i);

        }
        bitis =System.currentTimeMillis();
        System.out.println("ArrayList basa ekleme" + " sure: " + (bitis - baslangic ));

        baslangic = System.currentTimeMillis();
        for(int i =0; i <1000000 ; i++){

            b.add(0,i);

        }
        bitis =System.currentTimeMillis();
        System.out.println("LinkedHashSet basa ekleme" + " sure: " + (bitis - baslangic ));

    }
}
