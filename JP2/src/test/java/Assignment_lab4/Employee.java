package Assignment_lab4;

import java.util.Scanner;

public class Employee {

    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(int joinedYear) {
        this.joinedYear = joinedYear;
    }
    private int salary;
    private int joinedYear;

    public Employee() {
    }

    public Employee(String id, String name, String address, int salary, int joinedYear) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.joinedYear = joinedYear;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Address: " + address
                + ", Salary: " + salary + ", Joined Year: " + joinedYear;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        boolean validId = false;
        while (!validId) {
            System.out.print("Enter employee ID (format EMxxxx, x is a digit): ");
            id = scanner.nextLine();
            if (id.matches("^EM\\d{4}$")) {
                validId = true;
            } else {
                System.out.println("Invalid ID format. Please enter again.");
            }
        }

        boolean validName = false;
        while (!validName) {
            System.out.print("Enter employee name: ");
            name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                validName = true;
            } else {
                System.out.println("Name cannot be empty. Please enter again.");
            }
        }

        boolean validAddress = false;
        while (!validAddress) {
            System.out.print("Enter employee address: ");
            address = scanner.nextLine();
            if (!address.trim().isEmpty()) {
                validAddress = true;
            } else {
                System.out.println("Address cannot be empty. Please enter again.");
            }
        }

        boolean validSalary = false;
        while (!validSalary) {
            System.out.print("Enter employee salary (between 100 and 10000): ");
            salary = scanner.nextInt();
            if (salary >= 100 && salary <= 10000) {
                validSalary = true;
            } else {
                System.out.println("Invalid salary. Please enter again.");
            }
        }

        boolean validJoinedYear = false;
        while (!validJoinedYear) {
            System.out.print("Enter employee joined year (between 1980 and 2016): ");
            joinedYear = scanner.nextInt();
            if (joinedYear >= 1980 && joinedYear <= 2016) {
                validJoinedYear = true;
            } else {
                System.out.println("Invalid joined year. Please enter again.");
            }
        }
    }

}
