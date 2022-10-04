package Sesi_6;

import java.util.Scanner;

public class latihan1 {
    public static class Bilangan{
        
        double[] arrayBil = new double[3];
        Bilangan(){
            this.arrayBil[0] = 0;
            this.arrayBil[1] = 0;
            this.arrayBil[2] = 0;
        }
        Bilangan(double x, double y, double z){
            this.arrayBil[0] = x;
            this.arrayBil[1] = y;
            this.arrayBil[2] = z;
        }
        public  double ratarata() {
            double sum = 0;
            for (double i : arrayBil) {
                sum += i;
            }
            return sum/arrayBil.length;
        }
        public double max() {
            double max = arrayBil[0];
            for (int i = 0; i < arrayBil.length; i++) {
                if (arrayBil[i] > max) {
                    max = arrayBil[i];
                }
            }
            return max;
        }
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
        
        double x = 0;
        double y = 0;
        double z = 0;
        System.out.println("Menentukan Bilangan Terbesar, Terkecil, dan Rata-rata");
        System.out.println();
        System.out.print("Masukkan Bilangan Pertama (X) : ");
        x = in.nextInt();
        System.out.print("Masukkan Bilangan Pertama (Y) : ");
        y = in.nextInt();
        System.out.print("Masukkan Bilangan Pertama (Z) : ");
        z = in.nextInt();

        Bilangan bilangan = new Bilangan(x,y,z);
        System.out.println("Hasil : ");
        System.out.println("Rata-ratanya adalah : "+bilangan.ratarata());
        System.out.println(bilangan.max()+" adalah bilangan terbesar");
        System.out.println(bilangan.min()+" adalah bilangan terkecil");

        in.close();
    }
}
