package com.automation.tests.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo {


    @Test
    public void test1(){
        String word1 = "java";
        String word2 = "java";
        Assert.assertEquals(word1, word2);



    }
}
