package Assignment_lab6;

import java.util.Scanner;

public class Project {

    int id, value;
    String projectName, startDate;
    boolean completed;

    Scanner sc = new Scanner(System.in);

    public Project() {

    }

    public void input() {
//        System.out.println("Enter id: ");
//        id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter value: ");
        value = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name: ");
        projectName = (sc.nextLine());
        System.out.println("Enter startDate: ");
        startDate = (sc.nextLine());
        System.out.println("Enter completed [true/false]: ");
        completed = Boolean.parseBoolean(sc.nextLine());

    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", value=" + value + ", projectName=" + projectName + ", startDate=" + startDate + ", completed=" + completed + '}';
    }

    public Project(int id, int value, String projectName, String startDate, boolean completed) {
        this.id = id;
        this.value = value;
        this.projectName = projectName;
        this.startDate = startDate;
        this.completed = completed;
    }

}
