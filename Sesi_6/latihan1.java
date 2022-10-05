package Sesi_6;

import java.util.Scanner;

public class latihan1 {
    //membuat class bilangan
    public static class Bilangan{
        //array untuk menampung x, y, z
        double[] arrayBil = new double[3];
        //constructor default mengisi array dengan 0
        Bilangan(){
            this.arrayBil[0] = 0;
            this.arrayBil[1] = 0;
            this.arrayBil[2] = 0;
        }
        //constructor dengan parameter x,y,z mengisi array dengan variabel x,y,z
        Bilangan(double x, double y, double z){
            this.arrayBil[0] = x;
            this.arrayBil[1] = y;
            this.arrayBil[2] = z;
        }
        //fungsi mencari nilai rata-rata x,y,z
        public  double ratarata() {
            double sum = 0;
            for (double i : arrayBil) {
                sum += i;
            }
            return sum/arrayBil.length;
        }
        //fungsi mencari nilai max dari x,y,z
        public double max() {
            double max = arrayBil[0];
            for (int i = 0; i < arrayBil.length; i++) {
                if (arrayBil[i] > max) {
                    max = arrayBil[i];
                }
            }
            return max;
        }
        //fungsi mencari nilai min dari x,y,z
        public double min() {
            double min = arrayBil[0];
            for (int i = 0; i < arrayBil.length; i++) {
                if (arrayBil[i] < min) {
                    min = arrayBil[i];
                }
            }
            return min;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //deklarasi variabel x, y, dan z
        double x = 0;
        double y = 0;
        double z = 0;
        System.out.println("Menentukan Bilangan Terbesar, Terkecil, dan Rata-rata");
        System.out.println();
        //deklarasi variabel valid untuk cek inputan valid atau tidak
        boolean valid;

        //cek inputan variabel x hanya menerima inputan integer
        //selama inputan tidak valid maka terus meminta user untuk input variabel x
        do{
            valid = false;
            System.out.print("Masukkan Bilangan Pertama (X) : ");
            if (in.hasNextInt()) {
                //jika input valid
                x = in.nextInt();
                in.nextLine();
                valid = true;
            }else{
                //jika input tidak valid
                in.nextLine();
                System.out.println("Maaf input anda tidak valid");
            }
        }while(!valid);
        //cek inputan variabel y hanya menerima inputan integer
        //selama inputan tidak valid maka terus meminta user untuk input variabel y
        do{
            valid = false;
            System.out.print("Masukkan Bilangan Pertama (Y) : ");
            if (in.hasNextInt()) {
                y = in.nextInt();
                in.nextLine();
                valid = true;
            }else{
                in.nextLine();
                System.out.println("Maaf input anda tidak valid");
            }
        }while(!valid);
        //cek inputan variabel z hanya menerima inputan integer
        //selama inputan tidak valid maka terus meminta user untuk input variabel z
        do{
            valid = false;
            System.out.print("Masukkan Bilangan Pertama (Z) : ");
            if (in.hasNextInt()) {
                z = in.nextInt();
                in.nextLine();
                valid = true;
            }else{
                in.nextLine();
                System.out.println("Maaf input anda tidak valid");
            }
        }while(!valid);

        //deklarasi objek bilangan untuk menampung x,y,z
        Bilangan bilangan = new Bilangan(x,y,z);
        //menampilkan hasil rata-rata, nilai max, dan nilai min
        System.out.println("Hasil : ");
        System.out.println("Rata-ratanya adalah : "+bilangan.ratarata());
        System.out.println(bilangan.max()+" adalah bilangan terbesar");
        System.out.println(bilangan.min()+" adalah bilangan terkecil");

        in.close();
    }
}
