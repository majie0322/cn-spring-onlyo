package cn.spring.onlyo.reflect;

import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("cn.spring.onlyo.reflect.Studen");
        Object obj = cls.newInstance();
        Method setName = cls.getMethod("setName", String.class);
        Method getName = cls.getMethod("getName");
        setName.invoke(obj, "SMITH");
        System.out.println(getName.invoke(obj));

        /*
         * Method[] ms = cls.getMethods();
         * for (Method m : ms) {
         *//*
            * System.out.println(Modifier.toString(m.getModifiers()));
            *//*
              *//*
                  * System.out.println(m.getReturnType().getSimpleName());
                  *//*
                     * Class<?>[] c = m.getParameterTypes();
                     * for (Class<?> c1 : c) {
                     * System.out.println(c1.getSimpleName());
                     * }
                     *//*
                        * System.out.println(m.getName());
                        *//*
                           * }
                           */
        /*
         * Constructor<?> cons =
         * cls.getConstructor(String.class,Integer.class);//取得所有构造器
         * Object obj = cls.newInstance();
         * System.out.println(obj);
         */
        /*
         * for (int i=0;i<cons.length;i++){
         * System.out.println(cons[i]);
         * }
         */

    }
}
