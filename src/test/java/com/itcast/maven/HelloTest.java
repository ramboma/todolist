package com.itcast.maven;
import org.junit.*;
public class HelloTest
{
    @Test
    public void testHello()
    {
        Hello hello=new Hello();
        hello.sayHello();
        hello.sayTime();
    }
}
