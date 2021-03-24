package sample;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class TimerController{
    public Text txtMin;
    public Text txtSec;

    public Integer min=0;
    public Integer sec=30;

    public void startTimer(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (min>=0){
                    while (sec>=0){
                        try {
                            txtMin.setText(min.toString());
                            txtSec.setText(sec.toString());
                            sec--;
                            if (sec<0){
                                sec = 59;
                                min--;
                            }
                            System.out.println(min);
                            System.out.println(sec);
                            Thread.sleep(1000);
                        }catch (Exception e){}
                    }
                }
                try {
                    Thread.sleep(3000);
                    Platform.exit();
                }catch (Exception e){}
            }
        }).start();
    }
}
