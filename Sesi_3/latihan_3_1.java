package Sesi_3;

import java.util.function.ToIntFunction;
import java.util.Scanner;

public class latihan_3_1 {
    public static boolean luhn(String ccNumber) {
        //banyaknya digit cc
        int nDigits = ccNumber.length();
        //sum digit kedua dari akhir
        int sum1 = 0;
        //sum digit yang bukan kedua dari akhir
        int sum2 = 0;
        // sum dari sum1 dan sum2
        int sum = 0;
        //check genap atau ganjil banyak digit cc nya
        int parity = (nDigits-2)%2;
        for (int i = nDigits-1; i >=0 ; i--) {
            //digit convert char ke int
            int digit = Character.getNumericValue(ccNumber.charAt(i));
            //check digit kedua bukan
            if(i%2==parity){
                //digit kalikan dua
                digit = digit*2;
                //ambil digit puluhan dari digit yang telah dikalikan dua
                int digit1 = digit/10;
                //ambil digit satuan dari digit yang telah dikalikan dua
                int digit2 = digit%10;
                //jumlahkan digit satuan dan digit puluhan
                sum1 = sum1 + digit1+digit2;
            }
            else{
                //jumlahkan semua digit yang bukan kedua dari akhir
                sum2 = sum2 + digit;
            }
            //jumlahkan sum1 dan sum2
            sum = sum1+sum2;
        }
        //return true jika valid
        return (sum%10) == 0;
        
    }
    public static void main(String[] args) {
        String yourCC;

        Scanner keyboard = new Scanner(System.in);
        //input credit card number
        System.out.print("Masukkan nomor credit card : ");
        yourCC  = keyboard.nextLine();
        //call luhn function to check cc number
        System.out.print("Is your credit card valid ? : "+luhn(yourCC));
    }
}
