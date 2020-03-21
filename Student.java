package reflect;

/**
 * @author Fred Zhang
 * @create 2020-03-21 11:32 AM
 */
public class Student {
   private String name = "Big Guy";
    private int age;
    private String job;

    public Student() {

    }

    public Student(String name,int age,String job){
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void  fun(String name,int age){

        System.out.println("My name is "+name+" my age is "+age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
