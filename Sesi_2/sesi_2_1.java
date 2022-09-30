package Sesi_2;
import java.util.Scanner;

public class sesi_2_1 {
    public static void main(String[] args) {
        // int angka1;
        // int angka2;
        // int hasil;

        // Scanner keyboard = new Scanner(System.in);

        // System.out.println("Penjumlahan");
        // System.out.print("Input angka1 : ");
        // angka1  = keyboard.nextInt();
        // System.out.print("Input angka2 : ");
        // angka2  = keyboard.nextInt();

        // //penjumlahan
        // hasil = angka1 + angka2;
        // System.out.println("Hasil = "+hasil);

        // System.out.println("Pengurangan");
        // System.out.print("Input angka1 : ");
        // angka1  = keyboard.nextInt();
        // System.out.print("Input angka2 : ");
        // angka2  = keyboard.nextInt();

        // //pengurangan
        // hasil = angka1 - angka2;
        // System.out.println("Hasil = "+hasil);

        // System.out.println("Perkalian");
        // System.out.print("Input angka1 : ");
        // angka1  = keyboard.nextInt();
        // System.out.print("Input angka2 : ");
        // angka2  = keyboard.nextInt();

        // //perkalian
        // hasil = angka1 * angka2;
        // System.out.println("Hasil = "+hasil);

        // System.out.println("Pembagian");
        // System.out.print("Input angka1 : ");
        // angka1  = keyboard.nextInt();
        // System.out.print("Input angka2 : ");
        // angka2  = keyboard.nextInt();

        // //pembagian
        // hasil = angka1 / angka2;
        // System.out.println("Hasil = "+hasil);

        // System.out.println("Sisa Bagi");
        // System.out.print("Input angka1 : ");
        // angka1  = keyboard.nextInt();
        // System.out.print("Input angka2 : ");
        // angka2  = keyboard.nextInt();

        // //sisa bagi
        // hasil = angka1 % angka2;
        // System.out.println("Hasil = "+hasil);

        int x = 20;
        int y = 40;

        System.out.println("x + y = "+ (x+y) );
        System.out.println("x - y = "+ (x-y) );
        System.out.println("x * y = "+ (x*y) );
        System.out.println("x / y = "+ (x/y) );
        System.out.println("x % y = "+ (x%y) );

        System.out.println("x++ = "+(x++));
        System.out.println("x-- = "+(x--));
        System.out.println("++x = "+(++x));
        System.out.println("--x = "+(--x));

        int a = 5;
        int b = 10;

        b += a;
        System.out.println("Penambahan : "+b);

        b -= a;
        System.out.println("Pengurangan : "+b);

        b *= a;
        System.out.println("Perkalian : "+b);

        b /= a;
        System.out.println("Pembagian : "+b);

        b %= a;
        System.out.println("Sisa Bagi : "+b);

        int nilaiA = 12;
        int nilaiB = 4;
        boolean hasilCompare;

        //A > B ?
        hasilCompare = nilaiA > nilaiB;
        System.out.println("nilaiA > nilaiB ? "+ hasilCompare);

        //A < B ?
        hasilCompare = nilaiA < nilaiB;
        System.out.println("nilaiA < nilaiB ? "+ hasilCompare);

        //A >= B ?
        hasilCompare = nilaiA >= nilaiB;
        System.out.println("nilaiA >= nilaiB ? "+ hasilCompare);

        //A <= B ?
        hasilCompare = nilaiA <= nilaiB;
        System.out.println("nilaiA <= nilaiB ? "+ hasilCompare);

        //A == B ?
        hasilCompare = nilaiA == nilaiB;
        System.out.println("nilaiA == nilaiB ? "+ hasilCompare);

        //A != B ?
        hasilCompare = nilaiA != nilaiB;
        System.out.println("nilaiA != nilaiB ? "+ hasilCompare);

        int bit1 = 8;
        int bit2 = 10;
        int hasilBit;

        hasilBit = bit1 & bit2;
        System.out.println("bit1 & bit2 = "+ hasilBit);

        hasilBit = bit1 | bit2;
        System.out.println("bit1 | bit2 = "+ hasilBit);

        hasilBit = bit1 ^ bit2;
        System.out.println("bit1 ^ bit2 = "+ hasilBit);

        hasilBit = ~bit1;
        System.out.println("~bit1 = "+ hasilBit);

        hasilBit = bit1 << 2;
        System.out.println("bit1 << 2 = "+ hasilBit);

        hasilBit = bit1 >> 2;
        System.out.println("bit1 >> 2 = "+ hasilBit);

        hasilBit = bit1 >>> 3;
        System.out.println("bit1 >>> 3 = "+ hasilBit);
        
        boolean boolX = true;
        boolean boolY = false;
        System.out.println("x && y = "+ (boolX&&boolY));
        System.out.println("x && y = "+ (boolX||boolY));
        System.out.println("!(x && y) = "+ !(boolX&&boolY));

        int angkaX = 5;
        int angkaY = 10;
        System.out.println("angkaX < angkaY = "+ (angkaX < angkaY));
        System.out.println("angkaX > angkaY = "+ (angkaX > angkaY));
        System.out.println("angkaX <= angkaY = "+ (angkaX <= angkaY));
        System.out.println("angkaX >= angkaY = "+ (angkaX >= angkaY));
        System.out.println("angkaX == angkaY = "+ (angkaX == angkaY));
        System.out.println("angkaX != angkaY = "+ (angkaX != angkaY));
        System.out.println("angkaX > angkaY || angkaX < angkaY = "+ (angkaX > angkaY || angkaX < angkaY));
        System.out.println("3 < angkaX && angkaX < 6 = "+ (3 < angkaX && angkaX < 6));
        System.out.println("!(3 < angkaX && angkaX < 6) = "+ !(3 < angkaX && angkaX < 6));

        //membuat variabel belanja dan scanner
        int belanja = 0;
        Scanner scan = new Scanner (System.in);
        
        // //mengambil input
        System.out.print("Total Belanjaan: Rp. ");
        belanja = scan.nextInt();
        scan.nextLine();

        // //mengecek apakah dia belanja di atas 100.000
        if (belanja > 100000) {
            System.out.println("Selamat anda berhak mendapatkan hadiah");
        }
        System.out.println("Terima kasih telah belanja di indomaret");

        //membuat variabel
        int nilaiGue;
        String namaGue ;

        System.out.print("Nama : ");
        namaGue = scan.nextLine();
        System.out.print("Nilai : ");
        nilaiGue = scan.nextInt();
        scan.nextLine();

        if (nilaiGue >= 70) {
            System.out.println("Selamat "+namaGue+", anda lulus!");
        }else{
            System.out.println("Maaf "+namaGue+", anda gagal.");
        }

        int saldo;
        int biayaAdmin = 2000;
        double bunga = 0.02;
        System.out.print("Input saldo anda : ");
        saldo = scan.nextInt();
        scan.nextLine();
        if (saldo >= 10000) {
            System.out.println("cetak : "+(saldo+(saldo*bunga)));
        }else if(saldo < 2000){
            System.out.println("cetak : "+saldo);
        }else{
            System.out.println("cetak : "+(saldo-biayaAdmin));
        }
        scan.close();

    }
}
