package TopCoder;

public class Cryptography {
	public long encrypt(int[] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			
			int temp = 1;
			for (int j = 0; i < numbers.length; i++) {
			temp *=	numbers[i]; 
			}
			System.out.println(temp);
		}
	
		return 0;
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 2, 3 };
		Cryptography c = new Cryptography();
		c.encrypt(numbers);
	}
}
