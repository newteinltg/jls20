# 14.3 Local Class and Interface Declarations

局部类是一个嵌套类,它的生命直接包含在一个代码块中。
局部接口是一个嵌套接口，它的生命直接包含在一个代码块中。

*为了方便起见，将类的定义列举在这：*

```text
   ClassDeclaration:
        NormalClassDeclaration
        EnumDeclaration
        RecordDeclaration
   
   NormalClassDeclaration:
        {ClassModifier} class TypeIdentifier [TypeParameters]
        [ClassExtends] [ClassImplements] [ClassPermits] ClassBody
   
   EnumDeclaration:
        {ClassModifier} enum TypeIdentifier [ClassImplements] EnumBody
   
   NormalInterfaceDeclaration:
        {InterfaceModifier} interface TypeIdentifier [TypeParameters]
        [InterfaceExtends] [InterfacePermits] InterfaceBody

```

在一个代码块中，局部类和接口声明可以与语句自由混合(包括局部变量声明语句)。
如果局部类或接口声明中有访问修饰符public、protected或private(§6.6)则会导致编译时错误。
如果局部类或接口声明中有修饰符 static(§8.1.1.4)、sealed或non-sealed
(§8.1.1.2,§9.1.1.4)，则会导致编译时错误。
如果是局部变量的直接超类或直接超接口的修饰符是sealed，则会导致编译时错误。
如果本地接口的直接超接口的修饰符是sealed，则会导致编译时错误。
局部类可以是普通类(§8.1)、枚举类(§8.9)或记录类
(§8.10)。每个局部常规类都是一个内部类(§8.1.3)。每个局部枚举类
并且局部记录类隐式地是静态的(§8.1.1.4)，因此不是一个内部记录
类。

本地接口可以是普通接口(§9.1)，但不是注解接口
(§9.6)。每个本地接口都隐式地是静态的(§9.1.1.3)。
和匿名类一样(§15.9.5)，局部类或接口不是
任何包、类或接口(§7.1、§8.5)的成员。与匿名类不同的是，局部类
类或接口有一个简单的名称(§6.2、§6.7)。
局部类或接口声明的作用域和遮蔽在§6.3和§6.4中指定。  

*例14.3 - 1。局部类声明*
下面是一个例子，说明了上述规则的几个方面:

```java
class Global {
    class Cyclic {
    }

    void foo() {
        new Cyclic(); // create a Global.Cyclic
        class Cyclic extends Cyclic {
        } // circular definition
        {
            class Local {
            }
            {
                class Local {
                } // compile-time error
            }
            class Local {
            } // compile-time error
            class AnotherLocal {
                void bar() {
                    class Local {
                    } // ok
                }
            }
        }
        class Local {
        } // ok, not in scope of prior Local
    }
}
```
foo方法的第一个语句创建成员类Global.Cyclic的一个实例。 
而不是局部类Cyclic的实例，因为语句出现在局部类声明的作用域前面。
局部类声明的作用域包含整个声明(不只是声明体），这意味着局部类Cyclic的定义确实是Cyclic，因为它是循环的
扩展自身，而不是Global.Cyclic。因此，局部类的声明Cyclic在编译时会报错。
因为局部类名不能在同一个方法(构造函数或初始化代码块)重复，Local的第二和第三个声明会导致编译时错误。然而，Local可以在另一个上下文中更深入的嵌套中重新声明
，类如AnotherLocal。 最后面的Local声明是合法的，因为它发生在任何先前声明的范围之外。
