package D02_package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02_pattern {

    public static void main(String[] args) {
        String pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("boi@mail.com");
        if (m.matches()) {
            System.out.println("right email");
        } else {
            System.err.println("wrong email");
        }
    }
}
