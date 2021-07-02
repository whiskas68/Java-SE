import java.util.*;

public class ListDemo {

    public static final int N = 1000000;

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
            list.add(i);
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
