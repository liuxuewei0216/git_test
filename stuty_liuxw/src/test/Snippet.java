package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Snippet {
    public static void main(String[] args)  {
    	readToString("E:\\trunk\\logs\\dmb_links.log");
    }
	public static String readToString(String fileName) {  
	        String encoding = "ISO-8859-1";  
	        File file = new File(fileName);  
	        Long filelength = file.length();  
	        byte[] filecontent = new byte[filelength.intValue()];  
	        try {  
	            FileInputStream in = new FileInputStream(file);  
	            in.read(filecontent);  
	            in.close();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        try {  
	            return new String(filecontent, encoding);  
	        } catch (UnsupportedEncodingException e) {  
	            System.err.println("The OS does not support " + encoding);  
	            e.printStackTrace();  
	            return null;  
	        }  
	    } 
}

