import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void demo1(){
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("php");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println(list);
    }

    public static void demo2(){
        List<String> list = Arrays.asList("java","c++","php");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args){
        //demo1();
        demo2();
    }
}
