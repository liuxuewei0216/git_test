package test;
import java.io.*;
// 读取文件并查找文件中的内容
public class WriteFile{
    public static void main(String[] args)  {
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("D:\\workspace\\test_stuty\\src\\test\\test.log"));
            out1.write("string to be copied\n");
            out1.close();
            BufferedReader in = new BufferedReader(new FileReader("D:\\workspace\\test_stuty\\src\\test\\test.log"));
            String str;
            long startTime = System.currentTimeMillis();

            while ((str= in.readLine()) != null) {
                System.out.println(str);
                long endTime = System.currentTimeMillis();
                System.out.println("耗时" 
                        +(endTime - startTime)+ " ms");       
                
                int intIndex = str.indexOf("copied");
                if(intIndex == - 1){
                   System.out.println("没有找到字符串 copied");
                }else{
                   System.out.println("copied 字符串位置 " + intIndex);
                }
            }

        } catch (IOException e) {
        }
    }
}