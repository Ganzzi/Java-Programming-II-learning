package template02_IO;

import java.io.IOException;
import java.util.Scanner;

public class Book {

    private int id, price;
    private String name;

    public Book() {

    }

    public Book(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public void input() throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Id: ");
        id = Integer.parseInt(in.nextLine());

        System.out.println("Enter price: ");
        price = Integer.parseInt(in.nextLine());

        System.out.println("Enter name: ");
        name = in.nextLine();

//        in.close();
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", price=" + price + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
