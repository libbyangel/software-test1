/*
 * Author: 樊莉虹
 * Date: 2020.8.12
 * */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) throws Throwable {
        Result result = JUnitCore.runClasses(TestJunit.class);
        for (Failure failure : result.getFailures()) {
            throw failure.getException();
//            System.out.println(failure.toString());         //会返回所有 test 运行之后的一个与运算，只要有一个不对就是 false
        }

        assert (result.wasSuccessful());

        System.out.println("RunCount: " + result.getRunCount() + ", RunTime: " + result.getRunTime());
//        System.out.println(result.wasSuccessful());
    }
}