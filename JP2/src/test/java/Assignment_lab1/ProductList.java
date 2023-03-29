/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment_lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class ProductList {

    List<Product> ds = new ArrayList<>();

    public void addProduct() throws InvalidException {
        Product _product = new Product();
        _product.input();

        ds.add(_product);
    }

    public void displayAll() {
        ds.forEach(s -> System.out.println(s));
    }

    public List<Product> searchByName(String name) {
        return ds.stream()
                .filter(s -> s.name.contains(name))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws InvalidException {
        Scanner sc = new Scanner(System.in);
        ProductList pl = new ProductList();

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
                    pl.addProduct();
                    break;
                case 2:
                    pl.displayAll();
                    break;
                case 3:
                    System.out.println("Enter to search");
                    String nameStr = sc.nextLine();

                    List<Product> _pr = pl.searchByName(nameStr);
                    _pr.forEach(System.out::println);
                    break;
                case 4:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 4);
    }
}
