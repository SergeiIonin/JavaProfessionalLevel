import java.io.*;
import java.util.Collections;

public class PageReader {

// в пакете должно быть 3600 байт, т.к. 1 символ = 2 байта

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        int pageSize = 1800; // number of chars on the page
        int bufSize = 2*pageSize;
        int page = 3004; // enter your page here
        File file = new File("books/TikhiyDonSholokhov.txt");
        FileInputStream fis = null;
        long t2 = System.currentTimeMillis();

        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[bufSize];
            int x;
            int pageCount = 1;
            try {
                while ((x = fis.read(buf)) > 0) {
                    if (pageCount == page) {
                        System.out.println(new String(buf, 0, x, "UTF-8"));
                        break;
                    } else pageCount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Reading of the page time " + (System.currentTimeMillis() - t2));
        System.out.println("Total time elapsed " + (System.currentTimeMillis() - t1));
    }
}
