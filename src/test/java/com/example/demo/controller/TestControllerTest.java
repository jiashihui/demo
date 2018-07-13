package com.example.demo.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TestController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 13, 2018</pre>
 */
public class TestControllerTest {

    TestController testController;

    @Before
    public void before() throws Exception {
        System.out.println("Before!");
    }

    @After
    public void after() throws Exception {
        System.out.println("After!");
    }

    /**
     * Method: getValue()
     */
    @Test
    public void testGetValue() throws Exception {
        testController = new TestController();
        Assert.assertEquals("Hello Kotlin!",testController.getValue());
    }


} 
