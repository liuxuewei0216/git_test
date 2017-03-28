package junit;

public class Test_loop {
	public static void main(String[] args)
	{
	  Loop:	for(int i=2; i<10;i++)

	{
	 for(int j=2;j<i;j++)

	if( i%j == 0)continue Loop ; 

	System.out.print(i+" ");} 
	 }
}
