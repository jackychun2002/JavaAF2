package demo.s3;

public class DemoThread extends Thread {
    //    public void run(){
//        for (int i=0; i<20;i++){
//            System.out.println("Demo Thread i ="+i);
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){}
//        }
//    }
    public void run() {
        int min = 10;
        int sec = 10;
        while (min >= 0) {
            while (sec >= 0) {
                System.out.println(min + ":" + sec);
                sec--;
                if (sec < 0) {
                    sec = 59;
                    min--;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}