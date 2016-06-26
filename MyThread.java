class MySignal{
	private int data=0;
	public void setData(int x,int y){
		while(data!=x) { 
			 try{  wait();	
			 }catch(InterruptedException e) { ; }
		}
		data=y; notifyAll();
	}
}
class T implements Runnable{
		private Thread t;
		private MySignal flagData;
		private int runFlag,nextFlag;
		private char[] outputData;
		public void start1(){
			t.start();
		}
		public T(MySignal d,char[] outPt,int x,int y){
			flagData=d;
			outputData=outPt;
			t=new Thread(this);
			runFlag=x;
			nextFlag=y;
		}
		public void run(){
			synchronized(flagData){
					try{
						Thread.sleep(100);
					}catch(InterruptedException e) {;}
				for(char i=0;i<outputData.length;i++){
					flagData.setData(runFlag, nextFlag);
					System.out.print(outputData[i]);
				}
					
					try{
						Thread.sleep(100);
					}catch(InterruptedException e) {;}
				} 
		}
}
class App1{
		public static void main(String[] args){
			MySignal data=new MySignal();
			T t1,t2,t3;
			char[] c1={'1','2','3','4','5'};
			char[] c2={'A','B','C','D','E'};
			char[] c3={'¼×','ÒÒ','±û','¶¡','Îì'};
			t1=new T(data,c1,0,1);
			t2=new T(data,c2,1,2);
			t3=new T(data,c3,2,0);
			t1.start1();
			t2.start1();
			t3.start1();
 		}
}