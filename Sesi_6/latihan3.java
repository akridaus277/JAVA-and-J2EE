package Sesi_6;

import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class latihan3 {
    static class HargaBayar{
        private double pembelian;
        private double diskon;
        private double bayar;

        HargaBayar(double pembelian,double diskon){
            this.pembelian = pembelian;
            this.diskon = diskon;
        }

        public double getPembelian() {
            return pembelian;
        }

        public double getBayar() {
            this.bayar = this.pembelian * (100-this.diskon)/100;
            return bayar;
        }

        public double getDiskon() {
            return diskon;
        }      

    }
    public static void main(String[] args) {
        double pembelian = 1000000;
        double diskon = 10;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id","ID"));
        DecimalFormat formatter = new DecimalFormat("#,##0",symbols);

        HargaBayar hargaBayar = new HargaBayar(pembelian, diskon);
  
        System.out.printf("A. Pembelian = Rp. %s,-",formatter.format(hargaBayar.getPembelian()));
        System.out.println();
        System.out.printf("A. Diskon = %s%%",formatter.format(hargaBayar.getDiskon()));
        System.out.println();
        System.out.printf("A. Harga Bayar = Rp. %s,-",formatter.format(hargaBayar.getBayar()));
    }
}
