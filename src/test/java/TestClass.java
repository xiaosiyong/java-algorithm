import org.junit.Assert;
import org.junit.Test;
import siyong.xiao.learning.leetcode.MaximalRectangle;

/**
 * @Description
 * @Author iss
 * @Date 2020/5/27 09:48
 * @Version 1.0
 **/
public class TestClass {
    @Test
    public void testMaximalRectangle1() {
        char[][] a = new char[][]{
                {'1', '0', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '1'},
        };
        System.out.println(MaximalRectangle.maximalRectangle1(a));
        Assert.assertEquals(1, MaximalRectangle.maximalRectangle1(a));

    }

    @Test
    public void testMaximalRectangle2() {
        char[][] a = new char[][]{
                {'1', '0', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '1'},
        };
        System.out.println(MaximalRectangle.maximalRectangle2(a));
        Assert.assertEquals(6, MaximalRectangle.maximalRectangle2(a));

    }

    @Test
    public void testMaximalRectangle3() {
        char[][] a = new char[][]{
                {'1', '0', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '1'},
        };
        System.out.println(MaximalRectangle.maximalRectangle3(a));
        Assert.assertEquals(6, MaximalRectangle.maximalRectangle3(a));

    }

}
