package Sesi_5;

import java.util.Scanner;

public class sesi_5_1 {
    public static void main(String[] args) {
        System.out.println("Array");
        int[] contoh = new int[4];

        contoh[0] = 1;
        contoh[1] = 2;
        contoh[2] = 3;
        contoh[3] = contoh[2]+2;

        System.out.println("panjang array : "+(contoh.length-1));
        System.out.println(contoh[2]);
        System.out.println(contoh[3]);
        double[] arrayDouble = new double[2];
        arrayDouble[0] = 1.0;
        System.out.println(arrayDouble[0]);
        System.out.println(arrayDouble[1]);

        //for i
        for (int i = 0; i < contoh.length; i++) {
            System.out.println("Data index : "+i+" value : "+contoh[i]);
        }
        //for each
        int i = 0;
        for(int nilai: contoh){
            System.out.println("Data index : "+ i++ +" value : "+nilai);
        }

        Scanner input = new Scanner(System.in);
        for (int j = 0; j < contoh.length; j++) {
            System.out.print("Masukkan data untuk index "+ j +" : ");
            contoh[j] = input.nextInt();
            
        }
        for (int j = 0; j < contoh.length; j++) {
            System.out.println("Data index : "+j+" value : "+contoh[j]);
        }
        
        char[] charData = {'c','d','e','f'}; 
        System.out.println(contoh);
        System.out.println(charData);
        input.close();

    }
}
