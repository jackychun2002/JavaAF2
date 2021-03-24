package demo.s3.s5;

import java.io.*;

public class Main {
    public static void main(String[] args){
        try {
            //wire file
            FileOutputStream fos = new FileOutputStream("datat.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("xin chao T2008M");
            dos.writeBytes("Tuan sau se thi het mon");
            // read file
            FileInputStream fis = new FileInputStream("data.txt");
            DataInputStream dis = new DataInputStream(fis);
            String txt = dis.readLine();
            for(;txt !=null;){
                System.out.println(txt);
                txt= dis.readLine();
            }
        }catch (FileNotFoundException f){
            System.out.println("File not Found");
        }catch (IOException io){
            System.out.println("File Error");
        }
    }
}
