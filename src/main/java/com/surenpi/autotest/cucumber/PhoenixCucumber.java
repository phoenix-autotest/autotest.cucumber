package com.surenpi.autotest.cucumber;

import cucumber.api.cli.Main;
import cucumber.api.java.ObjectFactory;

public class PhoenixCucumber
{
    public static void main(String[] args) throws Throwable
    {
        String[] def = new String[]{"-g", "com.surenpi.autotest.cucumber", "target/test-classes/"};
        System.setProperty(ObjectFactory.class.getName(),
                PhoenixObjectFactory.class.getName());

        Main.main((args == null || args.length == 0)? def : args);
    }
}