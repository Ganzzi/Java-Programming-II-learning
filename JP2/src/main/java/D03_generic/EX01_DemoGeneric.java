package D03_generic;

import java.util.ArrayList;
import java.util.List;

public class EX01_DemoGeneric {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add("2");
        list.add(3);

        for (Object object : list) {
            int n = (int) object;
            System.out.println("n = " + n);
        }

        List<Integer> list2 = new ArrayList<>(); // Practice Generic
        list2.add(1);
//        list2.add("2"); // this cause error
        list2.add(3);

        EX02_MyArray<String> arr2 = new EX02_MyArray<>(String.class);
        arr2.add("an");
        arr2.add("duy");
        System.out.println("stop");

        EX01_DemoGeneric x = new EX01_DemoGeneric();
        x.print("10");
    }

    public <T> void print(T n) {
        System.out.println("n = " + n);
    }
}
