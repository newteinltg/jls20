package org.newteinltg.c14_3;

public class Global {
    class Cyclic {}

    void foo() { // 方法中变量或者类的作用域是在方法内部
        new Cyclic(); // 创建的是member class 的实例，而不是 local class的实例.
        // class Cyclic extends Cyclic {} // 循环定义

        {
            new Cyclic();
            new Global.Cyclic();
            class Local {}
            {
                // class Local {} // 编译时错误
            }
            // class Local {} // 编译时错误，在前面 Local 类的作用域内
            class AnotherLocal {
                void bar() {
                    class Local {} // OK
                }
            }
        }
    }
}
class Local {} // OK,不在前面Local类的作用域中