package Sesi_3;
import java.util.Scanner;

public class sesi_3_1 {
    public static void main(String[] args) {
        String x = new String("Test");
        String y = new String("Test");

        System.out.println("x == y : "+(x == y));

        String lampu;
        Scanner scan = new Scanner(System.in);

        System.out.print("Inputkan nama warna : ");
        lampu = scan.nextLine();
        scan.close();

        switch (lampu.toLowerCase()) {
            case "merah":
                System.out.println("Lampu merah, berhenti!");
                break;
            case "kuning":
                System.out.println("Lampu kuning, harap hati-hati!");
                break;
            case "hijau":
                System.out.println("Lampu hijau, silakan jalan!");
                break;
            default:
            System.out.println("Warna lampu salah!");
                break;
        }

        for (int j = 0; j < 4; j++) {
            switch (j) {
                case 0:
                    System.out.println("j is zero");
                    // break;
                case 1:
                    System.out.println("j is one");
                    // break;
                case 2:
                    System.out.println("j is two");
                    // break;
                default:
                    System.out.println("j is greater than two");
                    // break;
            }
        }
    }
}
