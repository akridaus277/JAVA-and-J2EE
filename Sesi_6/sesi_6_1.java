package Sesi_6;

import java.util.Scanner;

class Tree{
    static Scanner in = new Scanner(System.in);
    public void insert(Node a, int b){
        if (b < a.value) {
            if (a.left != null) {
                insert(a.left,b);
            }else{
                a.left = new Node();
                a.left.input(b);
                System.out.println(b + " di kiri "+a.value);
            }
        }else if (b > a.value) {
            if (a.right != null) {
                insert(a.right,b);
            }else{
                a.right = new Node();
                a.right.input(b);
                System.out.println(b + " di kanan "+a.value);
            }
        }
    }
    public void preOrder(Node a){
        if (a!=null) {
            System.out.print(a.value+" ");
            preOrder(a.left);
            preOrder(a.right);
        }
    }
    public void inOrder(Node a){
        if (a!=null) {
            inOrder(a.left);
            System.out.print(a.value+" ");
            inOrder(a.right);
        }
    }
    public void postOrder(Node a){
        if (a!=null) {
            postOrder(a.left);
            postOrder(a.right);
            System.out.print(a.value+" ");
        }
    }
    public void view(Node a){
        System.out.println("Pre Order : ");
        preOrder(a);
        System.out.println(" ");

        System.out.println("In Order : ");
        inOrder(a);
        System.out.println(" ");

        System.out.println("Post Order : ");
        postOrder(a);
        System.out.println(" ");
    }
}
class Node{
    Node left, right;
    int value;
    public void input (int a){
        value = a;
    }
}
public class sesi_6_1 {
        public static void main(String[] args) {
            Tree tr = new Tree();
            Node root = new Node();

            int menu = 1;
            int r = 1;
            int a;

            while(menu != 3){
                System.out.println("1. Input");
                System.out.println("2. View");
                System.out.println("3. Exit");
                menu = Tree.in.nextInt();

                if (menu == 1) {
                    System.out.print("Masukkan angka : ");
                    a = Tree.in.nextInt();
                    if (r==1) {
                        root.input(a);
                        r--;
                    }else{
                        tr.insert(root, a);
                    }
                }else if(menu==2){
                    tr.view(root);
                }else if(menu==3){
                    System.out.println("Keluar");
                }else{
                    System.out.println("Input tidak valid");
                }
                System.out.println("");
            }
        }
        
    

    
    
}
