package template02_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookList {

    List<Book> books;
    String fname;

    public BookList() {
        books = new ArrayList<>();
        fname = "book2.ser";
        loadFile();
    }

    public void addBook() {
        Book e = new Book();
        {
            try {
                e.input();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        books.add(e);
        printBook();
    }

    public void printBook() {
//        books.forEach(System.out::println);
        books.forEach(s -> System.out.println(s));
    }

    public List<Book> findByName(String name) {
        return books.stream().filter(b -> b.getName().contains(name)).collect(Collectors.toList());
    }

    public void savaFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fname);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(books);
            out.close();
            fileOut.close();
        } catch (Exception e) {
        }
    }

    public void loadFile() {
        try {
            File file = new File(fname);
            if (file.exists()) {
                FileInputStream x = new FileInputStream(fname);
                ObjectInputStream in = new ObjectInputStream(x);
                books = (List<Book>) in.readObject();
                in.close();
                x.close();
            }

//            books.clear();
//            List<Book> rs = (List<Book>) in.readObject();
//            books.addAll(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookList b = new BookList();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("1. Create new ");
            System.out.println("2. Display List");
            System.out.println("3. Search By name");
            System.out.println("4. Write File.");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    b.addBook();
                    break;
                case 2:
                    b.printBook();
                    break;
                case 3:
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    b.findByName(name);
                    break;
                case 4:
                    b.savaFile();
                    break;
                case 5:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 5);
    }
}
