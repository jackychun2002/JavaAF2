package demo.s3;

public class Main {
    public static void main(String [] args){
        DemoThread dt = new DemoThread();
        dt.run();
        for (int i=0;i<20;i++){
            System.out.println("Main i ="+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }
    }
}
// tạo 1 thread dem nguoc thoi gian ve 0
// gia su bat dau chay tu 10p
