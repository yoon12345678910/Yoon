package TopCoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test3_5 {
	
	void countString(String[] s){
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0; i < s.length; i++){
			if(!hm.containsKey(s[i]))hm.put(s[i], 0);
			hm.put(s[i], hm.get(s[i]) + 1);
		}
		for(String key : hm.keySet()){
			System.out.println(key + " " + hm.get(key));
		}
	}

	public static void main(String[] args) {
		test3_5 t = new test3_5();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력>");
		String[] st = sc.nextLine().split(" ");
		t.countString(st);
	}
}
