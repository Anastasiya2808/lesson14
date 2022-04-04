import org.w3c.dom.Node;

import java.util.*;

public class CollectionsLesson {
    public static void main(String[] args) {
        // 1. многопоточная или однопоточная среда
        // 2. возможность хранить дублирующиеся элементы
        // 3. возможность хранить элементы в порядке добавления
        // 4. возможность хранения элементов в отсортированном виде и тд

        System.out.println("ArrayList");
        //  реализован на основе массива
        // можно хранить null
        //  можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления


        Student student1 = new Student(1,"Maxim", 17 );
        Student student2 = new Student(2,"Anna", 21 );
        Student student3 = new Student(3,"Paul", 23 );
        Student student4 = new Student(4,"Helen", 19 );


        ArrayList<Student> studentArrayList = new ArrayList<>(); // по умолчанию массив 10
        // можно указать первоначальную емкость
        studentArrayList = new ArrayList<>(30);
        // количество элементов коллекции
        System.out.println(studentArrayList.size());// 0
        studentArrayList.add(student1); // 0 - добавляется ссылка на объект
        studentArrayList.add(student2); // 1
        // IndexOutOfBoundsException - обращение к несуществующему индексу (ошибка, выходит за пределы)
        // studentArrayList.add(10,student1);
        studentArrayList.add(1, student3); // не замена
        System.out.println(studentArrayList.size());
        studentArrayList.add(null);
        studentArrayList.trimToSize(); // урезаем массив

        // получение по индексу
        System.out.println(studentArrayList.get(1)); // вернет ссылку на элемент колекции

        // удаление
        // возвращает ссылку на удаленный элемент
        studentArrayList.remove(3);
        // возвращает true - false, для удаления использует метод equals
        studentArrayList.add(student1);
        studentArrayList.add(student1);
        studentArrayList.remove(student1);
        System.out.println(studentArrayList);

        Student[] students = {student1, student2};
        List <Student> studentList = Arrays.asList(students);
        studentArrayList.removeAll(Arrays.asList(students));


        studentArrayList.clear(); // удаляет все элементы из коллекции
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        for (Student student : studentArrayList) {
            // к имени каждого студента добавить строку "Student: "
            student.setName("Student: " + student.getName());

            // удаление элемента вцикле приведет
            // к ConcurrentModificationException
        }

        // удалить всех страше 30 лет
        Iterator<Student> iterator = studentArrayList.listIterator(); // по перебору помогает удалять из коллекции
        while (iterator.hasNext()){ // проверяет пока есть следующий
            if (iterator.next().getAge() > 20){
                iterator.remove();
            }
        }

        // LinkedList
        LinkedList<Student> studentLinkedList = new LinkedList<>(studentArrayList);
        studentLinkedList.add(student1);
        studentLinkedList.add(student2);
        studentLinkedList.add(student3);
        // Node(student1) <-> Node(student2) <-> Node(student3) -> null // узлы
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления


        System.out.println("Set");
        // используется для хранения уникальных элементов
        // обязательно должен быть переопределен метод equals

        // HashSet - самый быстрый из всех множеств (удаление, добавление)
        // позволяет хранить null (всегда будет на 1 месте)
        // порядок хранения может отличаться от порядка добавления
        // основан на hash таблице

        Student student11 = new Student(1,"Maxim", 17 );
        Student student12 = new Student(2,"Anna", 21 );
        Student student13 = new Student(3,"Paul", 23 );
        Student student14 = new Student(4,"Helen", 23 );

        HashSet <Student> studentHashSet = new HashSet<>();
        List<Student> list = Arrays.asList(student11, student12, student13, student14);
        studentHashSet = new HashSet<>(list);
        studentHashSet.add(student1);
        studentHashSet.remove(student13);

        // считаем средний возраст студентов
        double avAge = 0;
        for (Student student : studentHashSet) {
            avAge += student.getAge();
        }
        System.out.println(avAge/studentHashSet.size());

        // LinkedHashSet
        // порядок хранения не отличается от порядка добавления
        // медленее, чем HashSet

        // TreeSet
        // 1. хранит элементы в отсортированном виде
        // 2. нельзя добавить null
        // 3. основан на алгоритме красно-черного дерева

        // Для добавления элементов в TreeSet необходимо:
        // 1. чтобы класс, элементы которого будут храниться в TreeSet
        // реализовать интерфейс Comparable и его метод compareTo
        TreeSet <Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student4);
        treeSet1.add(student11);

        // Student student13 = new Student(3,"Paul", 23 );
        // Student student14 = new Student(4,"Paul", 23 );
        // 2. создать экземпляры класса Comparator
        Comparator<Student> studentComparator =
                new NameComparator().thenComparing(new AgeComparator());
        TreeSet <Student> treeSet2 = new TreeSet<>(studentComparator);
        treeSet2.add(student13);
        treeSet2.add(student14);
    }
}

