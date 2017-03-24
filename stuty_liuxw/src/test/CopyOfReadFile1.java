package test;
import java.io.*;
// 读取文件并查找文件中的内容
public class CopyOfReadFile1{
    public static void main(String[] args)  {

    	try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\workspace\\test_stuty\\src\\test\\test.log"));
            String str = "" ,content = "";
            long startTime = System.currentTimeMillis();

            while ((str = in.readLine()) != null) {
            	content += str;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("耗时" 
                    +(endTime - startTime)+ " ms");
            System.out.println(content);
            int intIndex = content.indexOf("love");
            if(intIndex == - 1){
               System.out.println("没有找到字符串 love");
            }else{
               System.out.println("love 字符串位置 " + intIndex);
            }
        } catch (IOException e) {
        }
    }
}