import java.util.Arrays;
import java.util.List;

public class MyArray {

    private Integer[] array;
    private List<Integer> list;

    public boolean contains1or4(Integer[] args){
        this.array = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            this.array[i] = args[i];
        }
        this.list= Arrays.asList(this.array);
        if (this.list.contains(1)) return true;
        else if (this.list.contains(4)) return true;
        else return false;
    }

}
