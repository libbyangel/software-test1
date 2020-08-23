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
        }
        assert (result.wasSuccessful());
        System.out.println("RunCount: " + result.getRunCount() + ", RunTime: " + result.getRunTime());
    }
}