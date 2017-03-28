package junit;

public class Test_loop2 {
	public static void main(String[] args)
	{
	  Loop:	for(int i=2; i<10;i++)

	{


	if( i%2 == 0)continue Loop ; 

	System.out.print(i+" ");} 
	 }
}
