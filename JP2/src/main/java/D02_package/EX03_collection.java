package D02_package;

import java.util.ArrayList;
import java.util.List;

public class EX03_collection {

    public static void main(String[] args) {
//        create quickly a list/array
        List<Integer> list = List.of(1, 2, 3);
        for (Integer n : list) {
            System.out.println("n = " + n);
        }

        List<String> arr = new ArrayList<>();
        arr.add("An");
        arr.add("Duy");
        arr.add("Nguyen");
        arr.add("Trinh");
        arr.add(2, "--"); // insert -- into index 2

//      convert collection to an array with type string
        String[] name = arr.toArray(new String[0]);

        for (String string : name) {
            System.out.print(string + " ");
        }

        List ds = new ArrayList();
        ds.add(5); // auto-boxing: ds.add(new Integer(5));
        Object[] ds2 = ds.toArray();
        System.out.println(ds2[0]);

    }
}
