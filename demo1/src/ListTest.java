/*************************************************************************
	> File Name: ListTest.java
	> Author: 
	> Mail: 
	> Created Time: 2019年05月13日 星期一 20时51分56秒
 ************************************************************************/

import java.util.ArrayList;
import java.util.List;
public class ListTest
{
    public static void main(String[] args){
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        System.out.println("list1集合为："+list1);

        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        System.out.println("list2集合为："+list2);

        //并集
        list1.addAll(list2);
        System.out.println("求并集:");
        System.out.println(list1);

        //交集
        list1.retainAll(list2);
        System.out.println("求交集:");
        System.out.println(list1);
    
    }
}
