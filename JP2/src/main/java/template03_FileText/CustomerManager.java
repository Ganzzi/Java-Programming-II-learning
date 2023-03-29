package template03_FileText;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class CustomerManager {

    List<Customer> customers;
    String fileName;
    Scanner sc = new Scanner(System.in);

    public CustomerManager() {
        customers = new ArrayList<>();
        fileName = "customer.txt";
    }

    public void readFile() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            customers.clear();

            String buf;
            while ((buf = in.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(buf, "-"); // = split("-")
                Customer cs = new Customer();
                int n = Integer.parseInt((String) tok.nextElement());
                cs.setId(n);
                cs.setName((String) tok.nextElement());
                cs.setEmail((String) tok.nextElement());

                customers.add(cs);
            }

//            System.out.println("Read success");
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void WriteFile() {
        try {
//          PrintWriter: ghi file text
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

//          customers.forEach(out::println);
            customers.forEach(c -> out.println(c));

            out.close();
        } catch (Exception e) {
        }
    }

    public void add() {
        Customer cust = new Customer();

        while (true) {
            try {
                System.out.println("Enter id");
                int n = Integer.parseInt(sc.nextLine());
                cust.setId(n);
                break;
            } catch (Exception e) {
                System.out.println("id is an integer");
                e.printStackTrace();
            }
        }

        var pName = Pattern.compile("^[\\w]{2,10}");
        while (true) {
            try {
                System.out.println("Enter name");
                String name = sc.nextLine();
                Matcher mat = pName.matcher(name);
                if (mat.matches()) {
                    cust.setName(name);
                    break;
                }

            } catch (Exception e) {
                System.out.println("2-10 character");
                e.printStackTrace();
            }
        }

        var pEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        while (true) {
            try {
                System.out.println("Enter email");
                String email = sc.nextLine();
                Matcher mat = pEmail.matcher(email);
                if (mat.matches()) {
                    cust.setEmail(email);
                    break;
                }

            } catch (Exception e) {
                System.out.println("wrong email");
                e.printStackTrace();
            }
        }

        customers.add(cust);

    }

    public void display() {
        customers.forEach(s -> System.out.println(s));
    }

    public List<Customer> findById(int id) {
        return customers.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CustomerManager cm = new CustomerManager();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("1. Create new ");
            System.out.println("2. Display List");
            System.out.println("3. Search By id");
            System.out.println("4. Write File.");
            System.out.println("5. Read File.");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    cm.add();
                    break;
                case 2:
                    cm.display();
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int _id = Integer.parseInt(sc.nextLine());
                    cm.findById(_id).forEach(s -> System.out.println(s));
                    break;
                case 4:
                    cm.WriteFile();
                    break;
                case 5:
                    cm.readFile();
                    break;
                case 6:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 6);

        File f = new File(cm.fileName);
        if (f.exists()) {
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec("Notepad customer.txt");
//                rt.exec("notepad " + cm.fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
