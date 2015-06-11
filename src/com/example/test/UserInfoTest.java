package com.example.test;

import com.example.app.UserInfo;
import com.example.system.Assert;
import com.example.system.BeforeMethod;
import com.example.system.Test;
import com.example.system.TesterInfo;

/**
 * Created by Nayan on 11 June, 2015
 */
@TesterInfo(
        name="Rafiqunnabi Nayan",
        date="2015-06-11"
)
public class UserInfoTest {

    private UserInfo userInfo;

    @BeforeMethod
    public void beforeMethod(){
        userInfo = new UserInfo();
    }

    @Test
    public void testGetNameInUpperCase(){
       userInfo.setName("nayan");
       Assert.assertEquals(userInfo.getNameInUpperCase(), "NAYAN");
    }

    @Test
    public void testGetNameInLowerCase(){
        userInfo.setName("NaYaN");
        Assert.assertEquals(userInfo.getNameInLowerCase(), "nayan");
    }

    @Test
    public void testIsOlderThan(){
        userInfo.setAge(27);
        Assert.assertEquals(userInfo.isOlderThan(25), true);
    }

    private void doNothingMethod(){
        System.out.println("This should not Run!");
    }

}
