package D01_exception;

import java.util.Scanner;

public class EX01_exceptionOnNumber {

    Scanner sc = new Scanner(System.in);

    void doSimple() {
        try {
            System.out.println("Enter a 1st numebr:");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println("Enter a 2st numebr:");
            int n2 = Integer.parseInt(sc.nextLine());

            System.out.printf("%d / %d = %d\n", n, n2, n / n2);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic " + e);
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format exception " + e);
        }
    }

    void doPipe() {
        try {
            System.out.println("Enter a 1st numebr:");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println("Enter a 2st numebr:");
            int n2 = Integer.parseInt(sc.nextLine());

            System.out.printf("%d / %d = %d\n", n, n2, n / n2);
        } catch (ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a position number: ");
        num = Integer.parseInt(sc.nextLine().trim());

        assert num >= 0 : num + " is not a position number";

        System.out.println(num + " is a position number"); // -ea
    }
}
