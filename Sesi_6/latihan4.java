package Sesi_6;
import java.util.Scanner;
public class latihan4 {
    //membuat class Kabisat
    static class Kabisat{
        //deklarasi variabel tahun
        private int tahun;

        //constructor default akan mengisi tahun dengan 0
        Kabisat(){
            this.tahun = 0;
        }
        //function setter untuk menampung inputan tahun user
        public void setTahun(int tahun) {
            this.tahun = tahun;
        }

        //function getter untk mengembalikan nilai tahun
        public int getTahun() {
            return tahun;
        }
        //function getter untuk validasi apakah tahun adalah kabisat
        public boolean isKabisat() {
            //Jika tahun adalah kelipatan dari 400 maka tahun kabisat
            if (tahun % 400 == 0){
                return true;
            }
            //Jika tahun adalah kelipatan dari 100 maka bukan tahun kabisat
            if (tahun % 100 == 0){
                return false;
            }
            //Jika tahun adalah kelipatan dari 4 maka tahun kabisat
            if (tahun % 4 == 0){
                return true;
            }
            //jika di luar dari ketiga kondisi di atas maka bukan tahun kabisat
            return false;
        }




    }
    public static void main(String[] args) {
        //Membuat objek scanner
        Scanner in = new Scanner(System.in);
        //meminta user untuk input tahun untuk dicek
        System.out.println("program untuk menentukan TAHUN KABISAT");
        //deklarasi variabel valid untuk cek inputan valid atau tidak
        boolean valid;
        //membuat objek Kabisat
        Kabisat kabisat = new Kabisat();
        //cek inputan hanya menerima inputan integer
        //selama inputan tidak valid maka terus meminta user untuk input tahun
        do{
            valid = false;
            System.out.print("Silahkan masukkan tahun : ");
            if (in.hasNextInt()) {
                //jika input valid
                //memasukkan inputan tahun user ke dalam objek kabisat
                kabisat.setTahun(in.nextInt());
                in.nextLine();
                valid = true;
            }else{
                //jika input tidak valid
                in.nextLine();
                System.out.println("Maaf input anda tidak valid");
            }
        }while(!valid);

        //cek apakah tahun yang diinput user kabisat atau bukan
        if (kabisat.isKabisat()) {
            //jika tahun kabisat
            System.out.println(kabisat.tahun+ " merupakan tahun kabisat");
        }else{
            //jika bukan tahun kabisat
            System.out.println(kabisat.tahun+ " bukan tahun kabisat");
        }

        in.close();
        
    }
}
