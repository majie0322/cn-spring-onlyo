package cn.spring.onlyo.reflect;

public class Studen {

    private String name;

    private Integer age;

    private Double socre;

    public Studen() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void fun() {

    }

    public Studen(String name, Integer age) {
        this.age = age;
        this.name = name;
        System.out.println("student构造方法");
    }

    @Override
    public String toString() {
        return "Studen{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
