import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] str = {"Java", "Python", "C#", "C++", "JavaScript"};
        TransformToArrayList transformToArrayList = new TransformToArrayList();
        ArrayList<String> arrayListStr = transformToArrayList.toArrayList(str);
        System.out.println(arrayListStr);
    }

}

class TransformToArrayList<T> {

    public ArrayList<T> toArrayList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

}
