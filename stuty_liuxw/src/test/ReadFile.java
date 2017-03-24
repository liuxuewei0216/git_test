package test;
import java.io.*;
// 读取文件内容并打印
public class ReadFile{
    public static void main(String[] args)  {
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\workspace\\test_stuty\\src\\test\\test.log"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
        }
    }
}