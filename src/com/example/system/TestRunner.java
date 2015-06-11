package com.example.system;

import com.example.test.UserInfoTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nayan on 11 June, 2015
 */
public class TestRunner {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            InvocationTargetException {

        Class<UserInfoTest> userInfoTestClass = UserInfoTest.class;

        if (userInfoTestClass.isAnnotationPresent(UnitTest.class)) {
            Annotation annotation = userInfoTestClass.getAnnotation(UnitTest.class);
            UnitTest unitTestInfo = (UnitTest) annotation;
            System.out.println("============== Unit Test Info ============");
            System.out.println("Name: " + unitTestInfo.author());
            System.out.println("Date: " + unitTestInfo.created());

            runTests(userInfoTestClass);
        }
    }

    private static void runTests(Class<UserInfoTest> userInfoTestClass) throws InvocationTargetException,
            IllegalAccessException, InstantiationException {

        UserInfoTest userInfoTest = userInfoTestClass.newInstance();
        System.out.println("============== Tests ============");

        int passedTestCount = 0, failedTestCount = 0;

        List<Method> testMethods = new ArrayList<Method>();
        Method beforeMethod = null;

        // scan the methods
        for (Method method : userInfoTestClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if(method.isAnnotationPresent(BeforeMethod.class)){
                beforeMethod = method;
            }
        }

        // run the tests
        for(Method method: testMethods){

            beforeMethod.invoke(userInfoTest);

            try {
                method.invoke(userInfoTest);
                System.out.printf("%s : passed\n", method.getName());
                passedTestCount++;
            } catch (Throwable e){
                System.err.printf("%s : failed\n", method.getName());
                failedTestCount++;
            }
        }

        System.out.printf("Total tests: %d, Failed: %d, Passed: %d\n", testMethods.size(),
                failedTestCount, passedTestCount);
    }
}
