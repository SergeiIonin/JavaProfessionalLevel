import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class JoinFiles {

    public static void main(String[] args) {

        ArrayList<InputStream> files = new ArrayList<>();
        SequenceInputStream sis;
        File resFile = new File(("txtFiles/resFile.txt"));
        try {
            resFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos = null;
        try {
            files.add(new FileInputStream("txtFiles/One.txt"));
            files.add(new FileInputStream("txtFiles/Two.txt"));
            files.add(new FileInputStream("txtFiles/Three.txt"));
            files.add(new FileInputStream("txtFiles/Four.txt"));
            files.add(new FileInputStream("txtFiles/Five.txt"));
            fos = new FileOutputStream(resFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sis = new SequenceInputStream(Collections.enumeration(files));

        int x;
        try {
            while ((x = sis.read()) != -1) {
                fos.write(x);
            }
            sis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream("txtFiles/resFile.txt"))) {
                int c;
                while ((c = isr.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
