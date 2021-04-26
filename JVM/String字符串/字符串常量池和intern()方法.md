# 字符串常量池和intern()方法

```java
String s1 = "a";                       //在常量池中创建一个对象"a"(假如池中没有对象"a")

String s2 = new String("a");          // 在堆中创建一个String对象，并且在常量池中创建一个对象"a"(假                                                       // 如池中没有对象"a"),然后把"a"传递给String对象，最后把                                                            // String对象的赋值给给栈中的变量s2
```



## intern方法

如果字符串常量池中包含了(equals方法判断)String对象的值，则返回池中的string对象，否则在池中新建对象，然后返回这个对象的引用。

```
String s1 = "abc";
String s2 = new String("abc");
String s3 = new String("abc").intern(); //将字符串常量池中的对象("abc")返回   
String s4 = new StringBuilder("abc").toString.intern();
System.out.println(System.identityHashCode(s1)+"\n"+System.identityHashCode(s2)+"\n"+System.identityHashCode(s3));
输出:
1555009629
41359092
1555009629
1555009629
```



使用场景：

```java
String s3 = new String("ab") + new String("c"); //toString()方法的调用，在字符串常量池中不存在"abc"
s3.intern(); // 在字符串常量池中生成"abc"。jdk6(false),在永久代中新建一个对象abc;jdk7/8(true)，在常量池中保留了在堆中对              // 象"abc"的 地址。
String s4 = "abc"; // s4使用的是上一行代码执行后，从常量池中返回"abc"的地址-该地址为堆对象中"abc"(s3)的地址
System.out.println(s3==s4); // jdk6：false，jdk7/8：true
```

```
String s3 = new String("ab") + new String("c");
String s4 = "abc";  // 在常量池中创建String对象（值为"abc"）
s3.intern();        // 常量池中已存在"abc",返回常量池中的引用
System.out.println(s3==s4); // false,因为s3.intern()方法并没有赋值给任何变量，s3仍然保留第一行new出来的对象，所以和s4不                             // 相等
```

```java
String s5 = new String("1") + new String("1");  //在堆中新建String对象'11',常量池中不存在'11'
String s6 = s5.intern();  // intern方法在常量池中新建'11'，并且返回'11'在第一行新建对象在堆中的引用地址返回给s6         
System.out.println(s5=="11"); // true,此时'11'的地址为第一行中新建对象s5('11')在堆中的地址
System.out.println(s6=="11"); // true
```

```java
String s4 = new String("ab");
String s5 = new String("a") + new String("b");
String s6 = s5.intern();

System.out.println(s4=="ab");  // false
System.out.println(s4==s5);    // false
System.out.println(s5==s6);    //false,此时常量池中"ab"的引用地址为s4在字符串常量池中创建的"ab"
                               //true,把第一行s4注释掉，那么常量池中"ab"的引用地址为s5在堆中创建的"ab"
```

```java
String s4 = new String("ab");
s4.intern();
String s6 = "ab";
System.out.println(s4==s6);  // false
```







![jdk6 intern方法实现](C:\Users\oper\Documents\面试准备\String字符串\jdk6 intern方法实现.png)

![jdk7_8 intern方法实现](C:\Users\oper\Documents\面试准备\String字符串\jdk7_8 intern方法实现.png)



总结：

**intern()的使用：jdk6 vs jdk7/8**

jdk6中

* 如果在常量池中存在，则返回对象的地址

* 不存在，则复制一个对象，放入常量池中，并返回常量池中对象的地址



jdk7/8

* 如果常量池有，则直接返回对象中的地址
* 没有，则会把对象的引用地址复制一份，放入常量池中，并返回常量池的引用地址





【引用】

尚硅谷2020最新版宋红康JVM教程更新至中篇(java虚拟机详解，jvm从入门到精通) -- p125 - p128





































