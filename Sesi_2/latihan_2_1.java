package Sesi_2;

import java.util.function.Function;

public class latihan_2_1 {

    public static void main(String[] args) {
        String bintang = "*";
        int berulang = 5;

        int maxBilangan = 20;
        for (int i = 0; i < maxBilangan; i++) {
            if (i%2!=0) {
                System.out.print(i+" ");
            }
        }
        System.out.println();

        int angka1[] = {3,1,42,24,12};

        for (int i : angka1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int i ;
        for (i = 0; i < 4; i++) {
            if (i >= 3) {
                break;
            }
            System.out.println("Selamat Belajar!");
            if (i >= 2) {
                continue;
            }
            System.out.println("hidup java!");
            System.out.println(i);
        }
        System.out.println(i);

        int currentCount = 0;
        System.out.println("Hasil Output : ");
        do {
            System.out.println("Perulangan ke- : "+currentCount);
            currentCount++;
        } while (currentCount <=10);
        
        System.out.println(1.00 - 9*0.10);
    }
}
