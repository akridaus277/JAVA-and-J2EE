package Sesi_6;

import java.util.Scanner;

public class latihan2 {
    //membuat class framework
    public static class Framework{
        //array untuk menampung array multidimensi framework
        String[][] arrayFramework ;
        //constructor dengan parameter row,column menentukan size array framework
        Framework(int size_row,int size_column){
            this.arrayFramework = new String[size_row][size_column];
        }
        //function untuk menambahkan element ke array framework
        public void inputFramework(String framework, int index_row,int index_column) {
            this.arrayFramework[index_row][index_column] = framework;
        }
        //function untuk menampilkan element array framework
        public void displayFramework() {
            //menampilkan element array framework dalam bentuk tabel
            System.out.println("============================================");
            for (int i = 0; i < arrayFramework.length; i++) {
                for (int j = 0; j < arrayFramework[i].length; j++) {
                    System.out.printf("|%-10s| %-3s", arrayFramework[i][j]," ");
                }
                System.out.println();
            }
            System.out.println("============================================");
            
        }
        

    }
    public static void main(String[] args) {
        //deklarasi ukuran row dan column untuk array framework
        int size_row = 2;
        int size_column = 3;
        //Membuat objek scanner
        Scanner in = new Scanner(System.in);
        //deklarasi objek framework untuk membuat array framework
        Framework framework = new Framework(size_row,size_column);

        //input framework ke dalam object framework
        for (int i = 0; i < size_row; i++) {
            for (int j = 0; j < size_column; j++) {
                System.out.print("siapa yang akan duduk di kelas ("+i+","+j+") : ");
                framework.inputFramework(in.nextLine(), i, j);
            }
        }
        //menampilkan object framework dalam bentuk tabel
        framework.displayFramework();

        in.close();

    }
}
