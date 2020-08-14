/*
 * Author: 樊莉虹
 * Date: 2020.8.12
 * */
import Jama.*;

public class MessageUtil {
    Matrix M1;
    Matrix M2;
    Matrix M;

    public MessageUtil(Matrix M1, Matrix M2){
        this.M1 = M1;
        this.M2 = M2;
    }
    public MessageUtil(Matrix M1){
        this.M1 = M1;
    }

    // 矩阵转置运算
    public Matrix tMatrix(){
        return this.M1.transpose();
    }

    // 矩阵加法运算
    public Matrix addMatrix(){
        this.M = this.M1.plus(this.M2);
        return this.M;
    }
    //自定义加法运算，利用插桩，判断是否执行了该方法
    public boolean myAddMock(Matrix m1, Matrix m2){
        //不关心具体实现
        return true;
    }

    // 矩阵减法运算
    public Matrix minusMatrix(){
        this.M = this.M2.minus(this.M1);
        return this.M;
    }

    //自定义减法运算，利用插桩，判断是否执行了该方法
    public boolean myMinusMock(Matrix m1, Matrix m2){
        //不关心具体实现
        return true;
    }
}  