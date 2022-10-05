package Sesi_6;

import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class latihan3 {
    //membuat class HargaBayar
    static class HargaBayar{
        //deklarasi variabel pembelian, diskon, dan bayar
        private double pembelian;
        private double diskon;
        private double bayar;
        //constructor dengan parameter pembelian, diskon
        HargaBayar(double pembelian,double diskon){
            this.pembelian = pembelian;
            this.diskon = diskon;
        }
        //function getter untk mengembalikan nilai pembelian
        public double getPembelian() {
            return pembelian;
        }
        //function getter untk mengembalikan nilai pembayaran
        public double getBayar() {
            //mmenghitung nilai pembayaran berdasarkan nilai pembelian dan nilai diskon
            this.bayar = this.pembelian * (100-this.diskon)/100;
            return bayar;
        }
        //function getter untk mengembalikan nilai diskon
        public double getDiskon() {
            return diskon;
        }      

    }
    public static void main(String[] args) {
        //deklarai variabel pembelian dan diskon
        double pembelian = 1000000;
        double diskon = 10;
        //deklarasi objek hargaBayar untuk menampung pembelian dan diskon
        HargaBayar hargaBayar = new HargaBayar(pembelian, diskon);

        //mengubah format cetak angka menjadi format indonesia
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id","ID"));
        //mengubah pattern penulisan grouping ribuan dan menerapkan format indonesia 
        DecimalFormat formatter = new DecimalFormat("#,##0.-",symbols);
  
        //ambil nilai pembelian dari objek hargaBayar dan cetak nilainya
        System.out.printf("A. Pembelian = Rp. %s",formatter.format(hargaBayar.getPembelian()));
        System.out.println();
        //ambil nilai diskon dari objek hargaBayar dan cetak nilainya
        System.out.printf("B. Diskon = %s%%",(int)hargaBayar.getDiskon());
        //ambil nilai pembayaran dari objek hargaBayar dan cetak nilainya
        System.out.println();
        System.out.printf("C. Harga Bayar = Rp. %s",formatter.format(hargaBayar.getBayar()));
    }
}
