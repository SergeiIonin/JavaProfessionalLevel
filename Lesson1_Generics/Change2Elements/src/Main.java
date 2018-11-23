import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Integer[] myIntArray = {3, 54, 635, 4454, 4, 66454, 43};
        Float[] myFloatArray = {3.43f, 54.354f, 6.32f, 44.54f, 4f, 664.54f, 43.35467f};
        String[] myStringArray = {"Java", "Python", "C#", "C++", "JavaScript"};

        AnyArray anyArray = new AnyArray();
        System.out.println("Arrays before: ");
        System.out.println("Integer: " + Arrays.asList(myIntArray));
        System.out.println("Float: " + Arrays.asList(myFloatArray));
        System.out.println("String: " + Arrays.asList(myStringArray));

        System.out.println("\n"+"Arrays after: ");

        for (int i = 0; i < 3; i++) {
            try {
                if (i == 0)
                    System.out.println("Integer: " + anyArray.change2Elements(myIntArray, 2, 4));
                else if (i == 1)
                    System.out.println("Float: " + anyArray.change2Elements(myFloatArray, 2, 4));
                else if (i == 2)
                    System.out.println("String: " + anyArray.change2Elements(myStringArray, 2, 4));
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}

    class AnyArray<T> {

    public List<T> change2Elements(T[] array, int firstElement, int secElement) throws IndexOutOfBoundsException{

        T temp = array[firstElement];
        array[firstElement] = array[secElement];
        array[secElement] = temp;
        return Arrays.asList(array);
    }

}