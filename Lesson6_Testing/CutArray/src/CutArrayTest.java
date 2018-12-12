import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CutArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Integer[] {1,7}, new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new Integer[] {1,7}, new Integer[]{1, 2, 6, 8, 2, 3, 7, 1, 7}},
        });
    }

    Integer[] res;
    Integer[] input;
    ArrayTransformer arrayTransformer;

public CutArrayTest(Integer[] res, Integer[] input) {
    this.input = input;
    this.res = res;
}

    @Before
    public void init(){
    arrayTransformer = new ArrayTransformer();
    }

    @Test
    public void testTransform() {
        Assert.assertArrayEquals(res,arrayTransformer.transform(input));
    }

    @Test (expected = RuntimeException.class)
    public void testTransformRTExc() {
        Assert.assertArrayEquals(res,arrayTransformer.transform(input));
    }

}
