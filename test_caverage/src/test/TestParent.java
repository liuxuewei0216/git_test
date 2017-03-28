package test;


public class TestParent{
	private static TestParent intance = null;
	
	public static TestParent getInstance(){
		if(intance == null){
			intance = new TestParent();
			init();
		}
		return intance;
	}
	
	public static void init(){
		System.out.println("---------************************-********-----");

	}
}