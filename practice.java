class YangHuiSanJiao{
	static void YangHui(int d){
		 int a[][]=new int [d][];
		for(int i=0;i<d;i++){
			a[i] =new int [i+1];
			for(int j=0;j<a[i].length;j++){
				if(i==0||j==0||i==j) a[i][j]=1;
				else{
					a[i][j]=a[i-1][j]+a[i-1][j-1];
				}
				System.out.print(" "+a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		YangHui(6);
	}

}