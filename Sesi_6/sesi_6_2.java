package Sesi_6;



public class sesi_6_2 {

    public static class BangunDatar{
        float luas(){
            System.out.println("Menghitung luas bangun datar");
            return 0;
        }
        float keliling(){
            System.out.println("Menghitung keliling bangun datar");
            return 0;
        }
    }
    public static class Persegi extends BangunDatar{
        float sisi;
        Persegi(){
            this.sisi=0;
        }
        Persegi(float sisi){
            this.sisi=sisi;
        }
        float luas(){
            return this.sisi*this.sisi;
        }
        float keliling(){
            return this.sisi*4;
        }
    }
    public static class Lingkaran extends BangunDatar{
        float r;
        Lingkaran(){
            this.r=0;
        }
        Lingkaran(float r){
            this.r=r;
        }
        float luas(){
            return 22/7*r*r;
        }
        float keliling(){
            return 22/7*r*2;
        }
    }
    public static class PersegiPanjang extends BangunDatar{
        float panjang, lebar;
        PersegiPanjang(){
            this.panjang=0;
            this.lebar=0;
        }
        PersegiPanjang(float panjang, float lebar){
            this.panjang=panjang;
            this.lebar=lebar;
        }
        float luas(){
            return this.panjang*this.lebar;
        }
        float keliling(){
            return 2*(this.panjang+this.lebar);
        }
    }
    public static class Segitiga extends BangunDatar{
        float alas,tinggi;
        Segitiga(){
            this.alas=0;
            this.tinggi=0;
        }
        Segitiga(float alas, float tinggi){
            this.alas=alas;
            this.tinggi=tinggi;
        }
        float luas(){
            return this.alas*this.tinggi/2;
        }
        float keliling(){
            return 3*this.alas;
        }

        
    }
    public static void main(String[] args) {
        BangunDatar bangunDatar = new BangunDatar();

        Persegi persegi = new Persegi(2);
        Lingkaran lingkaran = new Lingkaran(7);
        PersegiPanjang persegiPanjang = new PersegiPanjang(2,4);
        Segitiga segitiga = new Segitiga(2,4);

        System.out.println("Luas Persegi = "+persegi.luas());
        System.out.println("Keliling Persegi = "+persegi.keliling());
        System.out.println("Luas Lingkaran = "+lingkaran.luas());
        System.out.println("Keliling Lingkaran = "+lingkaran.keliling());
        System.out.println("Luas Persegi Panjang = "+persegiPanjang.luas());
        System.out.println("Keliling Persegi Panjang = "+persegiPanjang.keliling());
        System.out.println("Luas Segitiga = "+segitiga.luas());
        System.out.println("Keliling Segitiga = "+segitiga.keliling());
        System.out.println();

        



    }
}
