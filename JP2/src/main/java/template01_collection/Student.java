package template01_collection;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String id, name, email;
    Scanner sc = new Scanner(System.in);

    public Student() {

    }

    public void input() {
        String buf = "", sIdPattern = "Stu[\\d]{4}";
        Pattern idPt = Pattern.compile(sIdPattern);

        while (true) {
            System.out.print("Input ID: ");
            buf = sc.nextLine();
            Matcher mat = idPt.matcher(buf);
            if (mat.matches()) {
                setId(buf);
                break;
            } else {
                System.err.println("Wrong id format, it has form: Stuxxxx");
            }
        }

        System.out.print("Input Name: ");
        buf = sc.nextLine();
        setName(buf);
        System.out.print("Input Email: ");
        buf = sc.nextLine();
        setEmail(buf);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
