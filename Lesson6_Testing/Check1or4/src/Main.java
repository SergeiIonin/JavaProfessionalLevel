import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Check1or4Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{2, 3, 4, 5, 6, 7}},
                {new Integer[]{2, 3, 0, 5, 6, 7}},
                {new Integer[]{2, 3, 1, 5, 6, 7}},
                {new Integer[]{2, 3, 4, 5, 1, 7}},
        });
    }

    private Integer[] input;
    MyArray myArray;

    public Check1or4Test(Integer[] input) {
        this.input = input;
    }

    @Before
    public void init() {
        myArray = new MyArray();
    }

    @Test
    public void testTransform0() {
        Assert.assertTrue(myArray.contains1or4(input));
    }

}
