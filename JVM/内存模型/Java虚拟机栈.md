# Java虚拟机栈

概念：每个线程在创建时会创建一个虚拟机栈，其内部保持一个个栈帧，对应着一次次的方法调用（不包括本地方法），生命周期和线程一致



作用：保存方法的局部变量、部分结果，并参与方法的调用和返回。

特点：

* 是一种快速有效的分配存储方式，访问速度仅次于程序计数器

* 操作简单，JVM直接对Java栈的操作只有两个：

  1. 每个方法执行，伴随着进栈（入栈、压栈）
  2. 执行结束后的出栈工作

* 对于栈来说不存在垃圾回收问题

  



![image-20201122131300063](C:\Users\oper\Documents\面试准备\String字符串\虚拟机栈区域)



常用问题：

```java
public class StackOverFlowError {
    /**
     * 递归问题导致栈溢出问题
     * 默认情况，count=11407
     * 设置-Xss=256k，count=2457
     * */
    public static int count =0;

    public static void main(String[] args) {

        count+=1;
        System.out.println(count);
        main(args);
    }
}
    
```

栈帧的内部结构

* 局部变量表

  存放编译期可知的8种基本数据类型(int,double,float,long,short,byte,char,boolean)。

* 操作数栈

* 动态链接

* 方法返回地址

* 附加信息

![栈的内部结构](C:\Users\oper\Documents\面试准备\内存模型\栈的内部结构.png)



【引用】: p44 - p48



