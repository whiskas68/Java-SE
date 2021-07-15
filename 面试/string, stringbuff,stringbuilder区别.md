# string, stringBuff,stringBuilder区别

1. 可变和不可变

   string,为不可变对象，无法修改。若修改，会重新生成一个新的字符串对象

   stringBuffer，为可变对象，每次操作都是对自身的修改。

2. 线程是否安全

   string，stringBuffer(方法被sychronized修饰)是线程安全

   stringBuilder，不是线程安全。

3. 