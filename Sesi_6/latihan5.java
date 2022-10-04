package Sesi_6;
import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class latihan5 {
    static class Pos{
        private Object[][] order; 
        private Object[][] pos ;
        private Object[][] inventory = {
            {1,"Mouse Bluetooth 5.0",149999.0,10},
            {2,"Headphone External",246000.0,5},
            {3,"Power Bank 10.000 mAh",136000.0,0},
            {4,"Tripod Camera", 267999.0,20},
            {5,"Smart Watch Xiomi", 899000.0,10}
        };
        
        Pos(Object[][] order){
            this.order = order;
        }
        public Object[][] getOrder() {
            return order;
        }
        public Object[][] getPos() {
            this.pos = new Object[this.order.length][6];
            for (int i = 0; i < this.order.length; i++) {
                this.pos[i][0] = (int) order[i][0];
                this.pos[i][1] = inventory[(int) this.pos[i][0]-1][1];
                this.pos[i][2] = (double) inventory[(int) this.pos[i][0]-1][2];
                this.pos[i][3] = (int) order[i][1];
                this.pos[i][4] = (int) inventory[(int) this.pos[i][0]-1][3];
                this.pos[i][5] = (double) this.pos[i][2] * (int) this.pos[i][3] * (100 - (int) this.pos[i][4])/100;
            }
            return this.pos;
        }
        public double getTotal(){
            double sum = 0;
            for (int i = 0; i < this.pos.length; i++) {
                sum += (double) this.pos[i][5];
            }
            return sum;
        }

        

    }
    public static void main(String[] args) {
        System.out.println("PROGRAM JAVA TENTANG PENJUALAN BARANG");
        System.out.print("Masukkan Jumlah Beli : ");
        Scanner in = new Scanner(System.in);
        int qty = in.nextInt();
        Object[][] order  = new Object[qty][2];
        for (int i = 0; i < qty; i++) {
            System.out.print("Masukkan Kode Barang Ke-"+(i+1)+" : ");
            order[i][0] = in.nextInt();
            System.out.print("Masukkan qty Ke-"+(i+1)+" : ");
            order[i][1] = in.nextInt();
        }
        System.out.println();
        Pos pos = new Pos(order);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id","ID"));
        DecimalFormat formatter = new DecimalFormat("#,##0.00",symbols);
        System.out.printf("%-7s %-30s %-16s %-7s %-7s %-16s","No","Nama Barang","Harga","QTY","Diskon","Sub Total");
        System.out.println();
        Object[][] test = pos.getPos();
        for (int i = 0; i < test.length; i++) {
            System.out.printf("%-7d %-30s %-16s %-7s %-7s %-16s",
            i+1,
            test[i][1],
            "Rp. "+formatter.format(test[i][2]),
            test[i][3],
            test[i][4]+"%",
            "Rp. "+formatter.format(test[i][5])
            )
            ;
            System.out.println();
 
        }
        System.out.println();
        System.out.println("Total Bayar : Rp. " + formatter.format(pos.getTotal()));

        // for (Object[] objects : pos.getPos()) {
        //     int i = 1;
        //     System.out.printf("%-7s %-30s %-7s %-7s %-7s %-7s",i,objects[1],objects[2],objects[3],objects[4],objects[5]);
        //     System.out.println();
        //     i++;
        // }
    }
}
