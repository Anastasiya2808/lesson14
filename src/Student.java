import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Student  implements Comparable <Student>{
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    // геттеры для всех
    // сеттеры для name
    // equals b hashcode только для id
    // toString

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo (Student o){
        //  0 объекты равны, те this равен объекту о
        // -1 - this меньше объекта о
        //  1 - this больше объекта о
        // return (х < y) ? -1: ((х == y) ? 0 : 1); - тернарный оператор
        return Integer.compare(getAge(), o.getAge());
    }
}

class AgeComparator implements Comparator<Student>{
    @Override
    public int compare (Student o1, Student o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}