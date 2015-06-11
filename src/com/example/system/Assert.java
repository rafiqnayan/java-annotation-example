package com.example.system;

/**
 * Created by Nayan on 11 June, 2015
 */
public class Assert {

    public static void assertEquals(boolean valueOne, boolean valueTwo) throws AssertionFailedException {
        if(valueOne != valueTwo){
            throw new AssertionFailedException();
        }
    }

    public static void assertEquals(String valueOne, String valueTwo) throws AssertionFailedException {
        if(!valueOne.equals(valueTwo)){
            throw new AssertionFailedException();
        }
    }

}
