package Sesi_6;

import java.util.Scanner;

public class latihan2 {
    public static class Framework{
        String[][] arrayFramework ;
        Framework(int size_row,int size_column){
            this.arrayFramework = new String[size_row][size_column];
        }
        public void inputFramework(String framework, int index_row,int index_column) {
            this.arrayFramework[index_row][index_column] = framework;
        }
        public void displayFramework() {
            
            for (int i = 0; i < arrayFramework.length; i++) {
                for (int j = 0; j < arrayFramework[i].length; j++) {
                    System.out.println("siapa yang akan duduk di kelas ("+i+","+j+")"+" : "+arrayFramework[i][j]);
                }
            }
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
        
        int size_row = 2;
        int size_column = 3;
        Scanner in = new Scanner(System.in);
        Framework framework = new Framework(size_row,size_column);

        for (int i = 0; i < size_row; i++) {
            for (int j = 0; j < size_column; j++) {
                System.out.print("siapa yang akan duduk di kelas ("+i+","+j+") : ");
                framework.inputFramework(in.nextLine(), i, j);
            }
        }
        framework.displayFramework();

        

    }
}
