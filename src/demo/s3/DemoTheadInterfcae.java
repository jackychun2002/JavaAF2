package demo.s3;

public class DemoTheadInterfcae {
    public static void main(String []args){
        DemoThead2 dt2 = new DemoThead2();
        Thread t =new Thread(dt2);
        t.start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    System.out.println("run="+i);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){}
                }
            }
        };
        Thread t2 = new Thread(r);
        t2.start();
    }
}
