/*
 * Author: 樊莉虹
 * Date: 2020.8.12
 * */

import Jama.Matrix;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// 测试矩阵转置
public class TestJunit2 {
    MessageUtil messageUtil;
    double[][] m1 = {
            {1, 1, 1},
            {2, 2, 2},
            {3, 3, 3},
    };
    Matrix M1 = new Matrix(m1);

    @Test
    public void testTMatrix() {
        double[][] test = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        };
        Matrix testMatrix = new Matrix(test);
        this.messageUtil = new MessageUtil(this.M1);
        Matrix resultMatrix = this.messageUtil.tMatrix();
        // 注意这里一定要强制转换，不然的话没办法进行比较 (另外，就算用循环输出的也只是一个结果)
        for(int i=0; i<testMatrix.getRowDimension();i++){
            for (int j=0; j<testMatrix.getColumnDimension();j++){
                assertEquals((Double)testMatrix.get(i,j), (Double) resultMatrix.get(i,j));
            }
        }
    }
}