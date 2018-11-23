import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        String[] strArray1 = {"erge","regerg","gsdrge"};

        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(strArray1));

        String[] strArray2 = {"qwwe","rtrewerg","gsde"};
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(strArray2));

        for (int i = 0; i < arrayList2.size(); i++) {
            arrayList1.add(arrayList2.get(i));
        }

        System.out.println(arrayList1);

    }
}
