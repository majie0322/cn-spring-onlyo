package cn.spring.onlyo.test;

public class AA {

    public Object a ;
    static {
        System.out.println(2);
    }
    {
        System.out.println("1111");
    }
    public AA(){
        System.out.println("构造器");
    }
}
