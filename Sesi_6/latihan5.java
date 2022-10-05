package Sesi_6;
import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class latihan5 {
    //membuat class Pos
    static class Pos{
        //deklarasi order, pos, inventory , total

        //array object order memiliki bentuk sebagai berikut
        //{{kode barang,qty},....}
        private Object[][] order; //variabel order untuk menampung inputan order user

        //array object pos memiliki bentuk sebagai berikut
        //{{item ke-,nama barang, harga barang, qty, diskon, subtotal},....}
        private Object[][] pos ; //variabel pos untuk 

        //variabel total untuk menyimpan grand total
        private double total = 0;
        //variabel inventory sebagai tabel acuan produk
        private Object[][] inventory = {
            //{kode barang,nama barang, harga barang, diskon}
            {1,"Mouse Bluetooth 5.0",149999.0,10},
            {2,"Headphone External",246000.0,5},
            {3,"Power Bank 10.000 mAh",136000.0,0},
            {4,"Tripod Camera", 267999.0,20},
            {5,"Smart Watch Xiomi", 899000.0,10}
        };
        //constructor dengan parameter order akan menampung inputan order user
        Pos(Object[][] order){
            this.order = order;
        }
        //function getter untk mengembalikan array object order
        public Object[][] getOrder() {
            return order;
        }
        //function getter untk mengembalikan array object pos
        public Object[][] getPos() {
            //menentukan size row array objek pos berdasarkan banyaknya elemen array objek order
            //size column adalah 6 yang berisi nomor item ke-, nama barang, harga, qty, diskon, subtotal
            this.pos = new Object[this.order.length][6]; 
            
            for (int i = 0; i < this.order.length; i++) {
                //kode barang ke-i , mengacu pada kode barang item ke-i pada array objek order
                this.pos[i][0] = (int) order[i][0];
                //nama barang ke-i, mengacu pada nama barang di array objek inventory berdasarkan kode barang
                this.pos[i][1] = inventory[(int) this.pos[i][0]-1][1];
                //harga barang ke-i, mengacu pada harga barang di array objek inventory berdasarkan kode barang
                this.pos[i][2] = (double) inventory[(int) this.pos[i][0]-1][2];
                //qty barang ke-i , mengacu pada qty item ke-i pada array objek order
                this.pos[i][3] = (int) order[i][1];
                //diskon barang ke-i, mengacu pada diskon barang di array objek inventory berdasarkan kode barang
                this.pos[i][4] = (int) inventory[(int) this.pos[i][0]-1][3];
                //subtotal barang ke-i, menghitung nilai subtotal berdasarkan harga barang,qty,diskon barang ke-i
                this.pos[i][5] = (double) this.pos[i][2] * (int) this.pos[i][3] * (100 - (int) this.pos[i][4])/100;
            }
            return this.pos;
        }
        //function getter untk menghitung grand total dan mengembalikan nilainya
        public double getTotal(){
            //menghitung grand total dari seluruh subtotal pada array objek pos
             for (int i = 0; i < this.pos.length; i++) {
                this.total += (double) this.pos[i][5];
            }
            return this.total;
        }

        

    }
    public static void main(String[] args) {
        System.out.println("PROGRAM JAVA TENTANG PENJUALAN BARANG");
        
        System.out.print("Masukkan Jumlah Beli : ");
        //Membuat objek scanner
        Scanner in = new Scanner(System.in);
        //user input berapa jenis barang yang akan dibeli
        int qty = in.nextInt();
        Object[][] order  = new Object[qty][2];

        //variabel valid untuk chek inputan user valid atau tidak
        boolean valid;

        for (int i = 0; i < qty; i++) {
            //cek inputan kode barang hanya menerima inputan integer
            //selama inputan tidak valid maka terus meminta user untuk input kode barang
            do{
                valid = false;
                System.out.print("Masukkan Kode Barang Ke-"+(i+1)+" : ");
                if (in.hasNextInt()) {
                    order[i][0] = in.nextInt();
                    valid = true;
                }else{
                    in.nextLine();
                    System.out.println("Maaf input anda tidak valid");
                }
            }while(!valid);
            //cek inputan qty barang hanya menerima inputan integer
            //selama inputan tidak valid maka terus meminta user untuk input qty barang
            do{
                valid = false;
                System.out.print("Masukkan qty Ke-"+(i+1)+" : ");
                if (in.hasNextInt()) {
                    order[i][1] = in.nextInt();
                    valid = true;
                }else{
                    in.nextLine();
                    System.out.println("Maaf input anda tidak valid");
                }
            }while(!valid);

        }
        System.out.println();
        //deklarasi objek pos dengan parameter inputan order dari user
        Pos pos = new Pos(order);

        //mengubah format cetak angka menjadi format indonesia
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id","ID"));
        //mengubah pattern penulisan grouping ribuan dan menerapkan format indonesia 
        DecimalFormat formatter = new DecimalFormat("#,##0.00",symbols);

        System.out.printf("%-7s %-30s %-16s %-7s %-7s %-16s","No","Nama Barang","Harga","QTY","Diskon","Sub Total");
        System.out.println();
        //menampung array objek pos dari objek pos
        Object[][] pos_final = pos.getPos();
        //menampilkan data pada array objek pos_final
        for (int i = 0; i < pos_final.length; i++) {
            System.out.printf("%-7d %-30s %-16s %-7s %-7s %-16s",
            i+1, //barang ke-i
            pos_final[i][1], //barang ke-i
            "Rp. "+formatter.format(pos_final[i][2]), //harga barang ke-i
            pos_final[i][3],//qty barang ke-i
            pos_final[i][4]+"%", //diskon barang ke-i
            "Rp. "+formatter.format(pos_final[i][5]) //subtotal barang ke-i
            )
            ;
            System.out.println();
 
        }
        System.out.println();
        //ambil nilai grand total dari objek pos dan menampilkannya
        System.out.println("Total Bayar : Rp. " + formatter.format(pos.getTotal()));
        in.close();
    }
}
