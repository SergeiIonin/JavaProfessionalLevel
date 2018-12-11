import org.junit.Assert;
import org.junit.Test;
public class Main {

    ArrayTransformer arrayTransformer0 = new ArrayTransformer(1, 2, 4, 4, 2, 3, 4, 1, 7 );
    ArrayTransformer arrayTransformer1 = new ArrayTransformer(1, 2, 6, 8, 2, 3, 7, 1, 7);
    Integer[] res0 = {1,7};

    @Test
    public void testTransformRight() {
        Assert.assertArrayEquals(res0,arrayTransformer0.transform());
    }

    @Test
    public void testTransformFail() {
        Assert.assertArrayEquals(res0,arrayTransformer1.transform());
    }

    @Test (expected = RuntimeException.class)
    public void testTransformRTExc() {
        Assert.assertArrayEquals(res0,arrayTransformer1.transform());
    }

}
