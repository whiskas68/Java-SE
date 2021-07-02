# Java 集合框架

## ArrayList和LinkedList
ArrayList是基于动态数组实现的，LinkedList是基于链表实现的，因此两者在程序上的区别就在与对数据的增删和改查的效率上。

## ArrayList
ArrayList由数组组成的最基本的结构，数据是连续的，随机访问速度快，适用于频繁查询和获取数据

## LinkedList
LinkedList底层为双向链表实现，优点在于对数据的插入和删除开销很小，其原理就是，把前一个节点指向下一个节点的属性

### 数据的更新和查找
LinkedList 底层的数据是随机存储，更新数据需要移动指针，而ArrayList只需要根据下标就可以更新数据，因此ArrayList在更新效率上要优于LinkedList

### 数据的增加和删除
在增加数据元素方面，ArrayList是通过移动该元素之后的元素位置，其后元素位置全部位置+1,而LinkedList只需要将前一个元素的指针指向新增元素，并且，新增元素的后续指针指向下一个元素。删除的操作原理也是如此。所以LinkedList的效率更佳。

### 代码验证
```Java
import java.util.*;

public class IteratorDemo {

    public static final int N = 50000;

    static void getTime(List list){

        Add(list);
        get(list);
        set(list);
        delete(list);
    }

    private static String getListName(List list){
        if(list instanceof LinkedList){
            return "LinkedList";
        }else if(list instanceof ArrayList){
            return "ArrayList";
        }else{
            return "error";
        }
    }

    private static void get(List list){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<N;i++)
            list.get(i);
        Long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list)+"查询"+N +"条数据耗时"+ interval+ " ms");

    }

    private static void Add(List list){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<N;i++)
            list.add(0,i);
        Long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list)+"插入"+N +"条数据耗时"+ interval+ " ms");
    }

    private static void set(List list){
        long startTime = System.currentTimeMillis();
        int j = (int)(1+Math.random()*(N-1+1));
        for(int i=0;i<N;i++)
            list.set(j,"list");
        Long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list)+"随机修改"+N +"条数据耗时"+ interval+ " ms");
    }

    private static void delete(List list){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<N;i++)
            list.remove(0);
        Long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list)+"删除"+N +"条数据耗时"+ interval+ " ms");
    }

    public static void main(String[] args){
        getTime(new ArrayList());
        getTime(new LinkedList());
    }
}

```
#### 输出结果
```shell
ArrayList插入50000条数据耗时218 ms
ArrayList查询50000条数据耗时4 ms
ArrayList随机修改50000条数据耗时5 ms
ArrayList删除50000条数据耗时226 ms
LinkedList插入50000条数据耗时10 ms
LinkedList查询50000条数据耗时1557 ms
LinkedList随机修改50000条数据耗时702 ms
LinkedList删除50000条数据耗时5 ms
```
