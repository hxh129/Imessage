package com.hxh.isgapp;

/**
 * Created by hxh on 2018/7/3.
 */

public class Test {
    private String name;
    private String name1;

    public String getName() {
        return name;
    }

    public String getName1() {
        return name1;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                '}';
    }

    private Test(String name, String name1){
        this.name = name;
        this.name1 = name1;
    }
    private String getString(){
        return "Test{" +
                "name='" + name + '\'' +
                ", name1='" + name1 + '\'' +
                '}';
    }
}
