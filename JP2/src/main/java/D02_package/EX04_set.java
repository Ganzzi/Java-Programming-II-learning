package D02_package;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EX04_set {

    public static void main(String[] args) {
        Set mySet = new HashSet();
        mySet.add(1);
        mySet.add(2);
        System.out.println("item 0: " + mySet.toArray()[0]);

        Iterator it = mySet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (Object object : mySet) {
            System.out.println("n = " + object);
        }

        Map<Integer, String> demo = new HashMap<>();
        demo.put(1, "An");
        demo.put(2, "Mai");
        demo.put(3, "Thuy");

        String name = demo.get(3);

        System.out.println(name);
    }
}
