import org.junit.Assert;
import org.junit.Test;

public class Main {

    MyArray myArray0 = new MyArray(2, 3, 4, 5, 6, 7);
    MyArray myArray1 = new MyArray(2, 3, 0, 5, 6, 7);
    MyArray myArray2 = new MyArray(2, 3, 1, 5, 6, 7);
    MyArray myArray3 = new MyArray(2, 3, 4, 5, 1, 7);

    @Test
    public void testTransform0() {
        Assert.assertTrue(myArray0.contains1or4());
    }

    @Test
    public void testTransformFail() {
        Assert.assertTrue(myArray1.contains1or4());
    }

    @Test
    public void testTransform2() {
        Assert.assertTrue(myArray2.contains1or4());
    }

    @Test
    public void testTransform3() {
        Assert.assertTrue(myArray3.contains1or4());
    }

}
