package demo.s3.s4;

import java.util.Scanner;

public class demoWait {
    public static void main(String[] args) {
        Account a = new Account();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap so tien moi lan gui dc");
        int x = sc.nextInt();
        System.out.println("nhap so tien can rut ra");
        int y = sc.nextInt();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.rutTien(y);
            }
        });
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    a.napTien(x);
                }
            }
        };
        t1.start();
        for (int i=0;i<y/x;i++){
            new Thread(r).start();
        }
    }
}
