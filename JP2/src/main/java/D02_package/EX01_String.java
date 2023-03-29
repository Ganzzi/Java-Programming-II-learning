package D02_package;

import java.util.StringTokenizer;

public class EX01_String {

    final int a = 10;

    int n = 9;

    public static void main(String[] args) {
        // immutable object
        String s1 = "hello";
        String s2 = " world";
        String s12 = s1 + s2;
        System.out.println(s12);

        StringBuilder str = new StringBuilder();
        str.append("duy");
        str.append(" an");
        System.out.println(str.toString());

        // str.split();
        StringTokenizer tok = new StringTokenizer(s12);
        while (tok.hasMoreElements()) {
            System.out.println(tok.nextElement());

        }

    }
}
