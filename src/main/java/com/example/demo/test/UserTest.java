package com.example.demo.test;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class UserTest {
    /**
     * userid : 1001
     * name : 陈二晓
     * age : 25
     */

    @Getter@Setter@NonNull
    private String userid;
    @Getter@Setter
    private String name;
    @Getter@Setter
    private int age;

}
