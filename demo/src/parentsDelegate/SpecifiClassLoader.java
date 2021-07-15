package parentsDelegate;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * desc:自定义的类加载器，用于实现类的动态加载
 */
public class SpecifiClassLoader extends ClassLoader {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 如果父的类加载器中都找不到name指定的类，
     * 就会调用这个方法去从磁盘上加载一个类
     * @param name 类的全限定包名 不带后缀  例如com.test.Notice  而不要写成com.test.Notice.java
     * @return
     * @throws java.io.IOException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = null;
        Class<?> clazz = null;
        File classF = new File(fileName);
        try {
            //加载类的字节码
            clazz = instantClass(name,new FileInputStream(classF),classF.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }



    /**
     * 指定的类的class是否存在
     * @param name
     * @return
     * @throws IOException
     */
    private Class instantClass(String name, InputStream fin, long len) throws IOException {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        return defineClass(name,raw,0,raw.length);
    }



    public static void main (String[] args) throws InterruptedException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        for(;;){
            SpecifiClassLoader spcLoader = new SpecifiClassLoader();
            spcLoader.setFileName("C:\\Users\\whiskas68\\Documents\\Java-SE\\JVM\\demo\\whiskas68.RuleLists");
            Object obj = null;
            obj = spcLoader.loadClass("parentsDelegate.RuleLists").newInstance();
            Method m = obj.getClass().getMethod("Output",new Class[]{});
            m.invoke(obj, new Object(){});
            Thread.sleep(2000);
        }

    }



}