/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package D4_streamFile;

import java.io.*;

public class EX04_printlnWriter {

    public static void main(String[] args) {
        String s = "Nguyễn Trinh Duy An";
        try {
            var out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data.dat")));
            out.println(s);
            out.close();
            System.out.println("Done.");

            var in = new BufferedReader(new InputStreamReader(new FileInputStream("data.dat")));
            String str = in.readLine();
            in.close();
            System.out.println("str = " + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
