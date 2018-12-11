import java.util.Arrays;
import java.util.List;

public class ArrayTransformer {

    Integer[] array;
    List<Integer> list;
    Integer[] transArray;

    public ArrayTransformer(Integer... args) {
        this.array = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            this.array[i] = args[i];
        }
        this.list= Arrays.asList(this.array);
    }

    public Integer[] transform() {
        boolean contains = this.list.contains(4);
        if (contains){
            int index = this.list.lastIndexOf(4);
            this.transArray = new Integer[this.array.length-index-1];
            for (int i = (index+1); i < this.array.length; i++) {
                transArray[i-index-1] = array[i];
            }
        }
        else throw new RuntimeException();
        return transArray;
    }

}
