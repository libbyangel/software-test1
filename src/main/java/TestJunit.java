/*
 * Author: 樊莉虹
 * Date: 2020.8.12
 * */

import Jama.Matrix;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

//测试矩阵加法和矩阵减法
public class TestJunit {
    MessageUtil messageUtil;
    double[][] m1 = {
            {1, 1, 1},
            {2, 2, 2},
            {3, 3, 3},
    };
    double[][] m2 = {
            {4, 4, 4},
            {5, 5, 5},
            {6, 6, 6},
    };
    Matrix M1 = new Matrix(m1);
    Matrix M2 = new Matrix(m2);

    // 单元测试和 mockito 的使用
    @Test
    public void testMockMinusMatrix(){
        // 实例化两个 mock 对象，但我们不知道 Matrix 里面的方法 minus 是怎么实现的
        // 所以插桩，不管它内部实现是什么，只要运行了这个函数，我们就返回一个预设的矩阵
        Matrix A = mock(Matrix.class);
        Matrix B = mock(Matrix.class);

        Matrix result = new Matrix(m1);
        when (A.minus(B)).thenReturn(result);       // minus 输入矩阵，输出矩阵

        for (int i=0; i<result.getRowDimension();i++){
            for (int j=0; j<result.getColumnDimension();j++){
                System.out.print((A.minus(B)).get(i,j) + "   ");
            }
            System.out.println();
        }
    }
    @Test
    public void testMockMyMinus(){
        //这个方法用来测试一个自己写的类 MessageUtil 和方法 myMinusMock
        this.messageUtil = mock(MessageUtil.class);   //输入为矩阵，输出 boolean
        when (this.messageUtil.myMinusMock(this.M1,this.M2)).thenReturn(true);

        System.out.println(this.messageUtil.myMinusMock(this.M1,this.M2));
    }

    // 简单单元测试
    @Test
    public void testAddMatrix() {
        double[][] test = {
                {5, 5, 5},
                {7, 7, 6},
                {9, 9, 9},
        };
        Matrix testMatrix = new Matrix(test);
        this.messageUtil = new MessageUtil(this.M1, this.M2);
        Matrix resultMatrix = this.messageUtil.addMatrix();
        // 注意这里一定要强制转换，不然的话没办法进行比较 (另外，就算用循环输出的也只是一个结果)
        for(int i=0; i<testMatrix.getRowDimension();i++){
            for (int j=0; j<testMatrix.getColumnDimension();j++){
                assertEquals((Double)testMatrix.get(i,j), (Double) resultMatrix.get(i,j));
            }
        }
    }

    @Test
    public void testMinusMatrix() {
        double[][] test = {
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3},
        };
        Matrix testMatrix = new Matrix(test);
        this.messageUtil = new MessageUtil(this.M1, this.M2);
        Matrix resultMatrix = this.messageUtil.minusMatrix();
        assertEquals((Double)testMatrix.get(0,0), (Double) resultMatrix.get(0,0));
    }
}