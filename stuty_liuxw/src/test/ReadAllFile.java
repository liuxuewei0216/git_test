package test;
import java.io.*;
// 一次性读取文件内容，并查找某字符串第一次出现的位置
public class ReadAllFile{
    public static void main(String[] args)  {
    	try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\workspace\\test_stuty\\src\\test\\test.log"));
            String str = "" ,content = "";
            
            while ((str = in.readLine()) != null) {
            	content += str;
            }
            
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