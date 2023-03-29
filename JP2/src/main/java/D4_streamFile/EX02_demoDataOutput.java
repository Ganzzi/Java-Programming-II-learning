package D4_streamFile;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class EX02_demoDataOutput {

    public static void main(String[] args) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat"));
            out.writeInt(4);          // write stream
            out.writeDouble(4.5);     // 
            out.close();                // close stream
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
