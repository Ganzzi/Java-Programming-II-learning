package Assignment_lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {

    String id, name, mfg;
    int unitPrice, qoh;
    Scanner sc = new Scanner(System.in);

    public Product() {

    }

    public Product(String id, String name, String mfg, int unitPrice, int qoh) {
        this.id = id;
        this.name = name;
        this.mfg = mfg;
        this.unitPrice = unitPrice;
        this.qoh = qoh;
    }

    public void input() throws InvalidException {
        Pattern p1 = Pattern.compile("[FBfb]{1}\\d{4}");
        Matcher m1 = null;
        while (true) {
            System.out.println("Enter id: ");
            String s = sc.nextLine();
            m1 = p1.matcher(s);
            try {
                if (m1.matches()) {
                    id = s;
                    break;
                } else {
                    throw new InvalidException("Wrong id");
                }
            } catch (InvalidException e) {
                e.printStackTrace();
            }

        }

        Pattern p2 = Pattern.compile(".{2,}");
        Matcher m2 = null;
        while (true) {
            System.out.println("Enter name: ");
            String s = sc.nextLine();
            m2 = p2.matcher(s);
            if (m2.matches()) {
                name = s;
                break;
            } else {
                throw new InvalidException("Wrong name");
            }
        }

        while (true) {
            System.out.println("Enter unit price: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n > 0) {
                unitPrice = n;
                break;
            } else {
                throw new InvalidException("Wrong price");
            }
        }

        while (true) {
            System.out.println("Enter qoh: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n > 0) {
                qoh = n;
                break;
            } else {
                throw new InvalidException("Wrong qoh");
            }
        }

        Pattern p3 = Pattern.compile("^(US|VN|TL)$");
        Matcher m3 = null;
        while (true) {
            System.out.println("Enter mfg: ");
            String s = sc.nextLine();
            m3 = p3.matcher(s);
            if (m3.matches()) {
                mfg = s;
                break;
            } else {
                throw new InvalidException("Wrong mfg");
            }
        }
    }

    public String standardlizeMFG() {
        if (mfg.contains("US")) {
            return "United States";
        } else if (mfg.contains("VN")) {
            return "Vietnam";
        } else if (mfg.contains("TL")) {
            return "Thailand";
        } else {
            return mfg;
        }
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", mfg=" + standardlizeMFG() + ", unitPrice=" + unitPrice + ", qoh=" + qoh + '}';
    }

}
