package Sesi_6;
import java.util.Scanner;
public class latihan4 {
    static class Kabisat{
        private int tahun;
        private boolean kabisat;
        Kabisat(int tahun){
            this.tahun = tahun;
        }

        public int getTahun() {
            return tahun;
        }

        public boolean isKabisat() {
            if (tahun % 400 == 0){
                kabisat = true;
            }
            if (tahun % 100 == 0){
                kabisat = false;
            }
            if (tahun % 4 == 0){
                kabisat = true;
            }
            return kabisat;
        }




    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("program untuk menentukan TAHUN KABISAT");
        System.out.print("Silahkan masukkan tahun : ");
        Kabisat kabisat = new Kabisat(in.nextInt());
        if (kabisat.isKabisat()) {
            System.out.println(kabisat.tahun+ " merupakan tahun kabisat");
        }else{
            System.out.println(kabisat.tahun+ " bukan tahun kabisat");
        }
        
    }
}
