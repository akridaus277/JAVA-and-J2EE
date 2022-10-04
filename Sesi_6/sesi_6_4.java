package Sesi_6;

public class sesi_6_4 {
    public static void main(String[] args) {
        sesi_6_3 data =new sesi_6_3();
        data.setMenu("Ayam Goreng");
        data.setHarga(17000);
        data.setSpesial(true);

        System.out.println("Menu makanan : "+data.getMenu());
        System.out.println("Harga Makanan : Rp. "+data.getHarga());
        System.out.println("Menu Spesial : "+data.isSpesial());

    }
}
