package demo.s3.s4;

public class Main {
    public static void main(String[] args){
        Prime p = new Prime();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (p) {
                    for (int i = 0; i < 20; i++) {
                        p.tangXY();
                        p.inKetQua();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (p) {
                    for (int i = 0; i < 30; i++) {
                        p.tangXY();
                        p.inKetQua();
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
        t1.start();
        try {
            t1.join();
        }catch (Exception e){}
        t2.start();
    }
}
