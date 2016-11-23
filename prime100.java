class PrimeNumber{
public static void main(String[] args) {
		boolean isPrime; 
		for (int i = 2; i <= 100; i++) {
			isPrime = true;
			int k = (int) Math.sqrt(i);
			for (int j = 2; j <= k; j++) {
				if (i % j == 0) {
					isPrime = false; // 如果能够有数整除i,那么就不是素数.
					break;
				}
			}
			if (isPrime) {
				System.out.print(i +"\t");
			}
		}
	}
}