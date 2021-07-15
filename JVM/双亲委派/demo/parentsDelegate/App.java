package parentsDelegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main (String[] args) throws InterruptedException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        for(;;){
            SpecifiClassLoader spcLoader = new SpecifiClassLoader();
            spcLoader.setFileName("C:/Users/whiskas68/Documents/Java-SE/JVM/out/production/JVM/parentsDelegate/RuleLists.class");
            Object obj = null;
            obj = spcLoader.findClass("parentsDelegate.RuleLists").newInstance();
            Method m = obj.getClass().getDeclaredMethod("Output");
            m.invoke(obj);
            Thread.sleep(2000);
        }

    }
}
