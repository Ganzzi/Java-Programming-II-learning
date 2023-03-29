package D4_streamFile;

import java.io.File;

public class EX01_myFile {

    public static void main(String[] args) {
        File f = new File("demo.txt");
        if (f.exists()) {
            System.out.println("Exist.");
        } else {
            System.out.println("not found.");
        }

        File f2 = new File("myDir");
        if (f2.mkdir()) {
            System.out.println("Create success.");
        } else {
            System.out.println("Fail");
        }

        System.out.println(f.getPath());
    }
}
