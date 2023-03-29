package template01_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {

    List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
//      students.forEach(s -> System.out::println(s));
//      students.forEach(System.out::println);
    }

    public List<Student> searchStudent(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> searchStudent2(String name) {
        return students.stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }
}
