class PrimeNumber{
public static void main(String[] args) {
		boolean isPrime; 
		for (int i = 2; i <= 100; i++) {
			isPrime = true;
			int k = (int) Math.sqrt(i);
			for (int j = 2; j <= k; j++) {
				if (i % j == 0) {
					isPrime = false; // ����ܹ���������i,��ô�Ͳ�������.
					break;
				}
			}
			if (isPrime) {
				System.out.print(i +"\t");
			}
		}
	}
}