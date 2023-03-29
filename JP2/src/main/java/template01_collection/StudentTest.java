package template01_collection;

import java.util.List;
import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        int choice = 0;

        do {
            System.out.println("1. Create new Student");
            System.out.println("2. Display Student List");
            System.out.println("3. Search Student By NAME");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Student std = new Student();
                    std.input();
                    list.addStudent(std);
                    break;
                case 2:
                    list.displayStudent();
                    break;
                case 3:
                    System.out.println("Enter to search");
                    String nameStr = sc.nextLine();

                    List<Student> rs = list.searchStudent(nameStr);
                    rs.forEach(System.out::println);
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 4);

    }
}
