package Assignment_lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeList {

    private final HashSet<Employee> empList;

    public EmployeeList() {
        empList = new HashSet<>();
    }

    public void addEmp() {
        Employee employee = new Employee();
        employee.input();

        boolean exists = false;
        for (Employee emp : empList) {
            if (emp.getId().equals(employee.getId())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Employee with the same ID already exists.");
        } else {
            empList.add(employee);
            System.out.println("Employee added to the list.");
        }
    }

    public boolean searchByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine().trim();

        boolean found = false;
        for (Employee emp : empList) {
            if (emp.getName().contains(name)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }

        return found;
    }

    public void display() {
        if (empList.isEmpty()) {
            System.out.println("Employee list is empty.");
        } else {
            System.out.println("Employee list:");
            for (Employee emp : empList) {
                System.out.println(emp);
            }
        }
    }

    public void display(int years) {
        if (empList.isEmpty()) {
            System.out.println("Employee list is empty.");
        } else {
            System.out.println("Employee list with " + years + " years of experience:");
            for (Employee emp : empList) {
                int experience = 2023 - emp.getJoinedYear();
                if (experience >= years) {
                    System.out.println(emp);
                }
            }
        }
    }

    public void writeFileText() {
        try {
            File file = new File("NV.txt");
            try (FileWriter writer = new FileWriter(file)) {
                for (Employee emp : empList) {
                    writer.write(emp.getId() + ";" + emp.getName() + ";"
                            + emp.getAddress() + ";" + emp.getSalary() + ";"
                            + emp.getJoinedYear() + "\n");
                }
            }
            System.out.println("Employee list has been written to NV.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeList e = new EmployeeList();

        int choice = 0;

        do {
            System.out.println("1. Create new employee");
            System.out.println("2. Display employee List");
            System.out.println("3. Search employee By name");
            System.out.println("4. Display employee List by experience year.");
            System.out.println("5. Write File.");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    e.addEmp();
                    break;
                case 2:
                    e.display();
                    break;
                case 3:
                    e.searchByName();
                    break;
                case 4:
                    System.out.println("Enter experience year: ");
                    int _year = Integer.parseInt(sc.nextLine());
                    e.display(_year);
                    break;
                case 5:
                    e.writeFileText();
                    break;
                case 6:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 6);
    }
}
