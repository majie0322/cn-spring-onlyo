package cn.spring.onlyo.entity;

/**
 * onlyo
 *
 */
public class Student {

    public void show() {
        System.out.println(id);
    }

    private Integer id;

    private String name;

    private Integer score;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer id, String name, Integer score, Integer age) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", score=" + score + ", age=" + age + '}';
    }
}
