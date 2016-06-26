class PrimeNumber{
	   private static void isPrime(int n){
		int j=0;
		label1:
		for(int i=2;i<n;i++)
		{
			for(int m=2;m<=(int)(Math.sqrt(i));m++)
			{
			if(i%m==0)
				{
				continue label1;
				}
			}
		System.out.print(i+"\t"); 
		j++;
		if(j%5==0)
		System.out.println(); 
		
		}
	
	}
	public static void main(String[] args)
	{
		System.out.println("100以内的素数有：");
		isPrime(100);
	
	}
}