package Sesi_7;
import java.util.Scanner;
// SELECTION SORT
public class sesi_7_1 {
    public static void main(String[] args) {

        //Membuat objek scanner
        Scanner scan = new Scanner(System.in);

        //Input jumlah data
        System.out.println("Masukkan jumlah data : ");
        int jlh_data = scan.nextInt();

        //Input nilai tiap data
        int[] data = new int[jlh_data]; //array untuk nilai tiap data
        System.out.println();
        for (int i = 0; i < jlh_data; i++) {
            System.out.print("Input nilai data ke-"+ (i+1) +" : ");
            data[i] = scan.nextInt();
        }

        //Tampilkan data sebelum di sorting
        System.out.println();
        System.out.print("Data sebelum disorting : ");
        for (int i = 0; i < jlh_data; i++) {
            System.out.print(data[i]+" ");
        }

        //Proses selection sort
        System.out.println("\n\nProses Selection Sort");
        for (int i = 0; i < jlh_data-1; i++) {
            System.out.println("Iterasi ke-"+(i+1)+" : ");
            for (int j = 0; j < jlh_data; j++) {
                System.out.print(data[j]+" ");
            }
            System.out.println("Apakah data sudah benar urutannya?");
            boolean tukar = false;
            int index  = 0;
            int min = data[0];
            String pesan = "    Tidak ada pengurutan";
            for (int j = i+1; j < jlh_data; j++) {
                if (min > data[j]) {
                    tukar = true;
                    index = j;
                    min = data[j];
                }
            }
            if (tukar == true) {
                //Penukaran data
                pesan = "    Data "+data[i]+" ditukar dengan data "+data[index];
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
            for (int j = 0; j < jlh_data; j++) {
                System.out.print(data[j]+" ");
            }
            System.out.println(pesan+"\n");
        }
        //Tampilkan data setelah disorting
        System.out.print("Data setelah disorting : ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+" ");
        }

        
    }
}
