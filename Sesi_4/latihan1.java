package Sesi_4;
import java.util.Scanner;

public class latihan1{
    public static void main(String[] args) {
        Double Luas,PI;
        int r =0;
        Scanner input_r = new Scanner(System.in);
        System.out.println("Menghitung luas lingkaran");
        boolean valid = false;
        do{
            System.out.print("Masukkan jari-jari lingkaran dalam cm: ");
            if(input_r.hasNextInt()){
                r = input_r.nextInt();
                if(r < 0){
                    input_r.nextLine();
                    System.out.println("Harap masukkan bilangan positif");
                }else{
                    input_r.nextLine();
                    valid = true;
                }
                
            }else {
                input_r.nextLine();
                System.out.println("Maaf input anda tidak valid");
            }
        }while(!valid);
        
        PI = 3.14;
        Luas = PI * r * r;
        System.out.println("Luas lingkaran tersebut adalah = "+Luas+" cm2");
    }
}
