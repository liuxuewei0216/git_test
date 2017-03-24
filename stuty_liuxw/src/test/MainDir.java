package test;

import java.io.File;
 
public class MainDir {
    public static void main(String[] argv) throws Exception {
//        File dir = new File("../test_caverage");
        File dir = new File("src/test");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }
}