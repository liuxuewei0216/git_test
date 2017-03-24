package test;

import java.io.*;
 
public class AddFile {
    public static void main(String[] args) throws Exception {
        BufferedWriter out1 = new BufferedWriter(new FileWriter("D:\\workspace\\test_stuty\\src\\test\\test.log"));
//        out1.write("string to be copied\n");
        out1.close();
        InputStream in = new FileInputStream(new File("D:\\workspace\\test_stuty\\src\\test\\test.log"));
        OutputStream out = new FileOutputStream
        (new File("D:\\workspace\\test_stuty\\src\\test\\test1.log"));
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        BufferedReader in1 = new BufferedReader(new FileReader("D:\\workspace\\test_stuty\\src\\test\\test1.log"));
        String str;
        while ((str = in1.readLine()) != null) {
            System.out.println(str);
        }
        in1.close();
    }
}
