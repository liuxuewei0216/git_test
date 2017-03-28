package junit;

public class IfElseDemo {
    public static String main(int testscore) {
    	String grade;
        if (testscore >= 90) { grade = "a"; }
         else if (testscore >= 80) { grade ="b"; } 
		  else if (testscore >= 70) { grade = "c"; } 
	     else if (testscore >= 60) { grade ="d"; } 
		  else { grade ="f"; }
return grade;
    }

}
