&emsp;&emsp; Java编程语言是一种通用的、并发的、基于类的、面向对象的语言。
它被设计得足够简单，许多程序员都可以熟练的使用这门语言。
Java编程语言与C和C++有一定的联系，但组织方式不同，它省略了C和C++的许多方面，
同时包含了其他语言的一些思想。它旨在成为一种生产语言，而不是研究语言。
因此，正如C. A . R. Hoare在他关于语言设计的经典论文中建议的那样，
Java的设计避免包含新的和未经测试的功能。Java编程语言是强静态类型的。
这个规范清楚地区分了编译时错误和运行时错误，编译时错误可以且必须在编译时检测到。
编译时间通常包括将程序转换为与机器无关的字节码表示。运行时活动包括执行程序所需的类的
加载和链接，可选的机器代码生成和程序的动态优化，以及实际的程序执行。
Java编程语言是一种相对高级的语言，因为通过该语言无法获得机器表示的细节。
它包括自动存储管理，通常使用垃圾收集器，以避免显式释放(如C的free或c++的delete)
的安全问题。高性能的垃圾收集实现可以有有限的暂停，以支持系统编程和实时应用。
该语言不包含任何不安全的结构，例如不进行索引检查的数组访问，因为这种不安全的结构会
导致程序以未指定的方式运行。Java编程语言通常编译为Java虚拟机规范
(Java SE 20 Edition)中定义的字节码指令集和二进制格式。
## 1.1. 技术规范的章节构成
第二章描述了语法以及用于表示该语言的词汇和句法规则的符号。

第三章描述了基于C和C++的Java编程语言的词法结构。这种语言是用Unicode字符集编写的。它支持在只支持ASCII的系统上编写Unicode字符。

第四章介绍了类型、值和变量。类型又分为基本类型和引用类型。

基本类型在所有机器上和所有实现中的定义是相同的,包括各种大小的补码整数、IEEE 754浮点数、布尔类型和Unicode字符类型。基本类型的值不共享状态。
引用类型包括类类型、接口类型和数组类型。引用类型是通过动态创建的对象实现的,这些对象要么是类的实例,要么是数组的实例。每个对象可以存在多个引用。所有对象(包括数组)都支持类对象的方法,类对象是类层次结构的(单一)根。预定义的String类支持Unicode字符串。类的存在是为了将基本类型的值包装在对象中。在很多情况下,包装和拆包都是由编译器自动执行的(在这种情况下,包装称为装箱,拆包称为拆箱)。类和接口可以是泛型的,也就是说,它们可以使用引用类型进行参数化。类和接口的参数化类型可以使用特定的类型参数来调用。
变量是类型化的存储位置。基本类型的变量保存的值正是基本类型。类类型的变量可以保存null引用,也可以保存指向指定类或该类任何子类的实例对象的引用。接口类型的变量可以保存null引用,
也可以保存对实现指定接口的任何类实例的引用。数组类型的变量可以保存null引用或指向数组的引用。Object类类型的变量可以保存null引用,也可以保存对任何对象(无论是类实例还是数组)的引用。

第五章介绍了转换和数值提升。转换会改变编译时类型,有时还会改变表达式的值。这些转换包括基本类型和引用类型之间的装箱转换和拆箱转换。数值提升用于将数值运算符的操作数转换为可执行操作的通用类型。语言上没有漏洞;
在运行时检查引用类型的强制转换以确保类型安全。

第六章介绍了声明和名称,以及如何确定名称的含义(即名称表示哪个声明)
。Java编程语言不要求在使用类和接口及其成员之前声明它们。声明顺序只对局部变量、局部类、局部接口以及类或接口中字段初始化方法的顺序有影响。推荐的命名约定使程序更具可读性,将在次规范中描述。

第七章描述了程序的结构,程序以包的形式组织。包的成员包括类、接口和子包。包及其成员在层次名称空间中有名称;互联网域名系统通常可以用来形成唯一的包名。编译单元包含作为给定包成员的类和接口的声明,并且可以从其他包中导入类和接口,为它们提供简短的名称。
包可以分组成模块,在构建非常大的程序时充当构建块。模块的声明指定了编译和运行自身包中的代码需要哪些其他模块(以及包、类和接口)。
Java编程语言支持对外部访问包、类和接口成员的限制。包的成员可以仅由同一包中的其他成员访问,或由同一模块中的其他包中的成员访问,或由不同模块中的包的成员访问。类似的约束也适用于类和接口的成员。

第八章介绍类。类的成员是类、接口、字段(变量)和方法。类变量在每个类中存在一次。类方法不引用特定的对象。实例变量是在作为类实例的对象中动态创建的。实例方法在类的实例上调用;这样的实例在执行过程中成为当前对象this,支持面向对象编程风格。
类支持单继承,即每个类都有一个超类。每个类都继承超类的成员,并最终继承类对象的成员。类类型的变量可以引用指定类的实例或该类的任何子类,从而允许新类和现有方法多态地一起使用。
类通过同步方法支持并发编程。方法声明在执行过程中可能出现的已检异常,从而允许编译时检查以确保异常条件得到处理。对象可以声明一个finalize方法,该方法将在对象被垃圾收集器丢弃之前调用,从而允许对象清理它们的状态。
为简单起见,该语言既没有独立于类实现的声明“头”,也没有独立的类型和类层次结构。
枚举类是一种受限制的类,支持定义小的值集合,并以类型安全的方式操作它们。与其他语言中的枚举不同,枚举常量是对象,可以有自己的方法。
另一种受限制的类是记录类,它支持简单对象的紧凑表达式,这些对象充当值的聚合。

第九章介绍接口。接口的成员包括类、接口、常量字段和方法。其他不相关的类可以实现同一个接口。接口类型的变量可以包含实现该接口的任何对象的引用。
类和接口支持接口的多重继承。实现一个或多个接口的类可以同时从超类和超接口继承实例方法。
注释是一种元数据,可以应用于程序中的声明,也可以应用于声明和表达式中类型的使用。注释的形式由注释接口(一种特殊的接口)定义。注解不允许以任何方式影响Java编程语言中程序的语义。然而,它们为各种工具提供了有用的输入。

第十章介绍数组。数组访问包括边界检查。数组是动态创建的对象,可以赋值给Object类型的变量。该语言支持数组的数组,而不是多维数组。

第十一章描述了异常,它是不可恢复的,并与语言语义和并发机制完全集成。有三种类型的异常:已检异常、运行时异常和错误。编译器要求只有方法或构造函数声明了已检异常时,方法或构造函数才能导致已检异常,
从而确保已检异常得到正确处理。这提供了编译时检查异常处理程序是否存在,并在很大程度上帮助编程。大多数用户定义的异常都应该是已检查异常。Java虚拟机检测到的程序中的无效操作会导致运行时异常,
如NullPointerException。错误是由Java虚拟机检测到的错误导致的,例如OutOfMemoryError。大多数简单的程序都不会尝试处理错误。

第十二章描述了程序执行过程中发生的活动。程序通常以二进制文件的形式存储,表示已编译的类和接口。这些二进制文件可以加载到Java虚拟机中,链接到其他类和接口,并进行初始化。
初始化之后,可以使用类方法和类变量。有些类可以实例化以创建类类型的新对象。作为类实例的对象还包含这个类的每个超类的一个实例,而创建对象时需要递归创建这些超类的实例。
当一个对象不再被引用时,它可能会被垃圾收集器回收。如果对象声明了终结方法,那么终结方法会在对象被回收之前执行,给对象最后的机会来清理原本不会释放的资源。当不再需要某个类时,可以卸载它。

第十三章描述了二进制兼容性,说明了类和接口的改动对其他使用改动后的类和接口但没有重新编译的类和接口的影响。开发人员对这些考虑很感兴趣,因为类和接口要以连续的一系列版本广泛分布,
通常通过Internet。好的程序开发环境会在类或接口更改时自动重新编译相关代码,因此大多数程序员不需要关心这些细节。

第十四章介绍了基于C和C++的块和语句。该语言没有goto语句,但包含标记为break和continue的语句。与C不同的是,Java编程语言在控制流语句中需要布尔(或布尔)表达式,而且不需要
并且不会隐式地将类型转换为布尔类型(除了通过拆箱),希望在编译时捕获更多错误。synchronized语句提供了基本的对象级监视器锁。try语句可以包含catch和finally子句,以防止非本地控制转移。第十四章还介绍了模式,
用于在语句(和表达式)中有条件地声明和初始化局部变量。

第十五章介绍表达式。为了增加确定性和可移植性,本文档完全指定了表达式求值的(明显的)顺序。重载的方法和构造函数会在编译时从适用的方法或构造函数中选择最具体的方法或构造函数。

第十六章描述了语言在使用局部变量之前必须明确的初始化。虽然所有其他变量都会自动初始化为默认值,但Java编程语言不会自动初始化局部变量,以避免掩盖编程错误。

第十七章描述了线程和锁的语义,它们基于Mesa编程语言最初引入的基于监视的并发。Java编程语言为支持高性能实现的共享内存多处理器指定了一种内存模型。

第十八章介绍了各种类型推断算法,用于测试泛型方法的适用性,以及推断泛型方法调用中的类型。

第十九章介绍了这门语言的语法。
## 1.2. 程序示例
文中给出的大多数示例程序都可以执行，其形式类似于:
```java
class Test {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++)
            System.out.print(i == 0 ? args[i] : " " + args[i]);
        System.out.println();
    }
}
```
在安装了Oracle JDK的机器上，该类存储在Test.java文件中，可以通过以下命令编译和执行:
```text
javac Test.java
java Test Hello, world.
```
程序输出：
```text
Hello, world.
```
## 1.3. 符号
在本规范中,我们引用了从Java SE平台API描述的类和接口。每当我们使用单个标识符N引用类或接口时,预期的引用是指向包java.lang中名为N的类或接口。对于来自java.lang以外的包的类或接口,我们使用规范名称(§6.7节)。
本规范中的交叉引用如(第x.y节)所示。偶尔,我们通过形式(JVMS §x.y节)的交叉引用引用Java虚拟机规范,它是Java SE 20版中的概念。
非规范性文本,旨在澄清本规范的规范性文本,以较小的缩进文本给出。  
_这是不规范的文本。它提供了直觉、理由、建议、例子等。_
为了缩短某些规则的描述,特别是那些系统地分析Java编程语言结构的规则,习惯上使用缩写"iff"表示“当且仅当”。
Java编程语言的类型系统有时依赖于替换的概念。符号[F1:=T1,...,Fn:=Tn]表示当1≤i≤n时,用Ti代替Fi。
## 1.4. 与预定义类和接口的关系
如上所述，该规范经常引用Java SE Platform API的类和接口。特别是，一些类和接口与Java编程语言有特殊的关系。例如Object、Class、ClassLoader、String和Thread等类，以及包java.lang.reflect中的类和接口等等。该规范约束了类和接口的行为，但没有为它们提供完整的规范。读者参考Java SE Platform API文档。

因此，本规范没有详细描述反射。许多语言结构都涉及核心反射API (java.lang.reflect)和语言模型API (javax.lang.model)，但这里通常不讨论这些。例如，当我们列出可以创建对象的方法时，我们通常不包括核心反射API可以完成此操作的方法。读者应该意识到这些额外的机制，即使他们没有在文本中提到。
## 1.5. 功能预览
## 1.6. 反馈
_未提供翻译_
## 1.7. 引用
_未提供翻译_
