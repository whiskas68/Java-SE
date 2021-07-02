package ConcurrentDemo;

public class AcquireAboutIfDemo {
    private boolean tag1 = false;
    private boolean tag2 = false;

    public boolean isTag1() {
        System.out.println("执行方法1");
        return tag1;
    }

    public boolean isTag2() {
        System.out.println("执行方法2");
        return tag2;
    }

    public static void main(String[] args) {

        AcquireAboutIfDemo acquireAboutIfDemo = new AcquireAboutIfDemo();

        /*
        * tag1=true,tag2=false，执行方法1,执行方法2
        * tag1=true,tag2=true，执行方法1,执行方法2，并输出1，1
        * tag1=false,tag2=true，执行方法1
        * tag1=false,tag2=false，执行方法1
        * */
        if(acquireAboutIfDemo.isTag1() &&
                acquireAboutIfDemo.isTag2())
            System.out.println("1,1");


    }
}
