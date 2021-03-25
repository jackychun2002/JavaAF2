package asm.s3.addSV;

import asm.s3.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.*;
public class Controller {
    public TextField txtName;
    public TextField txtAge;
    public TextField txtMark;
    public TextField txtValidate;

    public void input(){
        try {
            // lấy sinh viên từ sudent
            FileInputStream fis = new FileInputStream("student.bin");
            DataInputStream dis = new DataInputStream(fis);
            String  txt = dis.readLine();
            ArrayList<String> arr= new ArrayList<>();
            while (txt!=null){
                arr.add(txt);
                txt = dis.readLine();
            }


            FileOutputStream sos = new FileOutputStream("student.bin");
            DataOutputStream dos = new DataOutputStream(sos);
            if(!txtName.getText().isEmpty()){
                dos.writeBytes(txtName.getText()+"\n");
                dos.writeBytes(txtAge.getText()+"\n");
                dos.writeBytes(txtMark.getText()+"\n");
                txtValidate.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtMark.setText("");
            }else {
                txtValidate.setText("Vui lòng nhập tên, tuổi và điểm thi");
                txtValidate.setDisable(false);
            }
            for (String s:arr){
                dos.writeBytes(s+"\n");
            }
        }catch (FileNotFoundException f){
            System.out.println("File not found");
        }catch (IOException io){
            System.out.println("File orror");
        }
    }

    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../home/home.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
    public void studentList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../student_list/dssv.fxml"));
        Main.mainStage.setScene(new Scene(root, 600, 400));
        Main.mainStage.show();
    }
}
