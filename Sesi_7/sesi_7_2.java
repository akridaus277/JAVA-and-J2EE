package Sesi_7;
import java.util.Scanner;
//BUBBLE SORT
public class sesi_7_2 {
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

        
        //Proses bubble sort
        System.out.println("\n\nProses Bubble Sort");
        for (int i = 0; i < jlh_data-1; i++) {
            System.out.println("Iterasi ke-"+(i+1)+" : ");
            for (int j = 0; j < jlh_data; j++) {
                System.out.print(data[j]+" ");
            }
            System.out.println("Apakah data sudah benar urutannya?");

            String pesan = "    Tidak ada pengurutan";

            for (int j = 0; j < jlh_data - i - 1; j++){
                if (data[j] > data[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
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
        scan.close();
    }
}
