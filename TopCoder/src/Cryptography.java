import java.util.Arrays;


public class Cryptography {
	
//증명	
public long test(int[] numbers){
	long ans = 0;
	
	for(int i =0; i < numbers.length; i ++){
		long temp = 1;
		for(int j = 0; j < numbers.length; j++){
			if(i == j){
			temp *=(numbers[j] + 1);
			}else{
			temp *= numbers[j];	
			}
		}
		System.out.println(i+1 + " 번째 " + ans + "," + temp);
		ans = Math.max(ans,temp);
	}
	return ans;
}
	
public long encrypt(int[] numbers){
	int maximum = 1;
	
	Arrays.sort(numbers);
	numbers[0]++;
	
	for(int n : numbers){
		System.out.print(n+",");
		maximum *= n;
		System.out.println(maximum);
	}
	
	return maximum;
}

	public static void main(String[] args) {
		int[] codeSequence = {4, 3, 2, 5, 1};
		Cryptography cy = new Cryptography();
		System.out.println("최댓값" + cy.test(codeSequence));
		System.out.println("최댓값" + cy.encrypt(codeSequence));
	}

}
