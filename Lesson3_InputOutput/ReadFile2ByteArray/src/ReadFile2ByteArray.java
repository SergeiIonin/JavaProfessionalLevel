import java.io.*;
import java.util.Scanner;

public class ReadFile2ByteArray {

    public static void main(String[] args) {

        Scanner scn = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayInputStream bais;

        try {
            scn = new Scanner(new FileInputStream("myFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scn.hasNextByte()){
            baos.write(scn.nextByte());
        }

        byte[] arr = baos.toByteArray();
        bais = new ByteArrayInputStream(arr);

        int each;
        while((each = bais.read())!=-1){
            System.out.print(each + " ");
        }

    }

}
