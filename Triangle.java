class Triangle{
	private double a,b,c,p;
	private double a1,b1;
	Triangle(){
		
	}
	Triangle(double x,double y,double z){
		a=x;
		b=y;
		c=z;
		judgeE();
		p=(a+b+c)/2.0;
	}
	Triangle(double m,double n){
		a=m;
		a1=n;
		judgeH();
	}
	
	public void judgeE(){
		if(!(a*b*c>0&&a+b>c && a-c<b||a-b<c)) System.out.print("The date is error!");
	}
	public void judgeH(){
		if(!(a*a1>0 ))  System.out.print("The date is error!");
	}

	/*
	 *�D	�������߾���ȷ��δ��д��ֵΪ0��
�D	�Է�0������ֵ���õ�*�߼��������������ú��׹�ʽ��������������ͬ��
     (3)���ּ�������ķ�����
     (4) �����ĳ�Ա��Ϣ��

	 */
	
	 double Area1(){
	 	return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	 }
	 double Area2(){
	 		return a*a1/2;
	 }
//	 void disp(){
//	 	System.out.println("���Ϊ��"+Area());
//	 }
	 public static void main(String[] args)
	 {
	 	Triangle t=new Triangle(3,4,5);
	 	Triangle t2=new Triangle(3,5);
	 	System.out.println("���Ϊ��"+t.Area1());
	 	System.out.println("���Ϊ��"+t2.Area2());
	 //	t.disp();
	 }
	
}
