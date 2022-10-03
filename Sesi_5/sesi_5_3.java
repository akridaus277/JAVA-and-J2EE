package Sesi_5;

public class sesi_5_3 {
    public static void main(String[] args) {
        char[] data01 = {'a','b','c','d','e'};
        System.out.println(data01);
        // char[] data02 = new char[4];
        char[] data02 = {'i','j','k','l'};
        System.out.println(data02);
        System.arraycopy(data01, 1, data02, 0, 3);
        System.out.println(data02);
    }
}
