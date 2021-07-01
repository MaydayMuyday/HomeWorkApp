package lesson5;

public class Person {
    String name;
    String post;
    String email;
    String phone;
    int salary;
    int age;


    public Person(String name, String post, String email, String phone, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.printf("%s  %s  %s  %s  %d  %d \n", name, post, email, phone, salary, age);
    }
    public int getAge(){
        return age;
    }
}
