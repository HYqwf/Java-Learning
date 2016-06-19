class Text6 extends Thread{
	private int d;
	public Text6(String s ,int n){
		super(s);
		d=n;
	}
	public void run(){
	try{	
		for(int i=d;i<50;i=i+2)
		{
			System.out.print(" "+i);
		}
	}catch(Exception e){;
	}
		System.out.print(getName()+" \tfinished");
	}
	
		public static void main(String[] args)
		{
			Text6 t1,t2;
			System.out.print("MainStart");
			t1 =new Text6("p1 ",1);
	    	t2 =new Text6("p2 ",2);
			t1.start();
		    t2.start();
		    System.out.print("MainEnd");
		}
	
}
