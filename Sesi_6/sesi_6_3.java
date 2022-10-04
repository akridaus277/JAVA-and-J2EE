package Sesi_6;

public class sesi_6_3 {
    private String menu;
    private double harga;
    private boolean spesial;
    

    
    // Setter
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
    public void setSpesial(boolean spesial) {
        this.spesial = spesial;
    }

    //Getter
    public double getHarga() {
        return harga;
    }
    public String getMenu() {
        return menu;
    }
    public boolean isSpesial() {
        return spesial;
    }
}
