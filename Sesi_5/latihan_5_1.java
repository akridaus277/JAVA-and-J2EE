package Sesi_5;

import java.util.Scanner;

public class latihan_5_1 {
    public static void displayData(int[] data) {
        for (int index = 0; index < data.length; index++) {
            System.out.println("data untuk index "+ index +" : "+data[index]);
        }
    }
    public static int getMin(int[] data) {
        int min = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
    public static int getMax(int[] data) {
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan ukuran array : ");
        int arraySize = in.nextInt();
        int[] intData = new int[arraySize];
        for (int i = 0; i < intData.length; i++) {
            System.out.print("Masukkan data untuk index "+i+" : ");
            intData[i] = in.nextInt();
        }
        int max = getMax(intData);
        int min = getMin(intData);
        displayData(intData);

        System.out.println("data max : "+max);
        System.out.println("data min : "+min);

        //

        in.close();;
    }
}
