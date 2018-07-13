package com.example.demo.test

import org.junit.After
import org.junit.Assert
import org.junit.Test

import org.junit.Before

class KotlinTestTest {

    @Test
    fun getStr() {
        Assert.assertEquals("Hello Kotlin!", "")
    }

    @Before
    fun setUp() {
        System.out.println("Before!")
    }

    @After
    fun tearDown() {
        System.out.println("After!")
    }

}