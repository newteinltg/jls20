package org.newteinltg.c14_3;

/**
 *
 * java中 initializer 指的是两种不同的场景：
 * 1. 实例初始化代码块
 *    用来初始化成员变量，是在对象创建的时候执行，在构造器执行之前。
 * 2. 静态初始化代码块
 *    在类的初始化的时候执行，只运行一次。
 */
public class Block {
    Integer x;
    static String y;
    // 实例初始化代码块
    {
        x = 3;
    }

    public Block() {
        System.out.println("x value is: " + x);
    }

    // 静态初始化代码块
    static {
        y = 5 + "";
    }

    public static void main(String[] args) {
        // 演示静态初始代码块
        System.out.println("y value is: " + Block.y);
        // 演示实例初始代码块
        Block block = new Block();
    }
}
/*
 * Output:
 * y value is: 5
 * x value is: 3
 */