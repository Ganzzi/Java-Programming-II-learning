package D4_streamFile;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class EX03_demoDataInput {

    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("data.dat"));
            int n = in.readInt();           // read Int from stream
            double db = in.readDouble();    //
            in.close();                     // close stream
            System.out.println("n = " + n + "\ndb = " + db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
