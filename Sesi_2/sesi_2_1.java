package Sesi_2;
import java.util.Scanner;

public class sesi_2_1 {
    public static void main(String[] args) {
        int angka1;
        int angka2;
        int hasil;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Penjumlahan");
        System.out.print("Input angka1 : ");
        angka1  = keyboard.nextInt();
        System.out.print("Input angka2 : ");
        angka2  = keyboard.nextInt();

        //penjumlahan
        hasil = angka1 + angka2;
        System.out.println("Hasil = "+hasil);

        System.out.println("Pengurangan");
        System.out.print("Input angka1 : ");
        angka1  = keyboard.nextInt();
        System.out.print("Input angka2 : ");
        angka2  = keyboard.nextInt();

        //pengurangan
        hasil = angka1 - angka2;
        System.out.println("Hasil = "+hasil);

        System.out.println("Perkalian");
        System.out.print("Input angka1 : ");
        angka1  = keyboard.nextInt();
        System.out.print("Input angka2 : ");
        angka2  = keyboard.nextInt();

        //perkalian
        hasil = angka1 * angka2;
        System.out.println("Hasil = "+hasil);

        System.out.println("Pembagian");
        System.out.print("Input angka1 : ");
        angka1  = keyboard.nextInt();
        System.out.print("Input angka2 : ");
        angka2  = keyboard.nextInt();

        //pembagian
        hasil = angka1 / angka2;
        System.out.println("Hasil = "+hasil);

        System.out.println("Sisa Bagi");
        System.out.print("Input angka1 : ");
        angka1  = keyboard.nextInt();
        System.out.print("Input angka2 : ");
        angka2  = keyboard.nextInt();

        //sisa bagi
        hasil = angka1 % angka2;
        System.out.println("Hasil = "+hasil);



    }
}
