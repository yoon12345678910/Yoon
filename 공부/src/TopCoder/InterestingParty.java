package TopCoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InterestingParty {
	public int bestInvitation(String[] first, String[] second) {

		/*
		 * 해결1
		 * 
		 * for(int i =0; i < first.length; i++){
		 * 
		 * int f = 0; int s = 0;
		 * 
		 * for(int j =0; j < first.length; j++){
		 * if(first[i].equals(first[j]))f++; if(first[i].equals(second[j]))f++;
		 * if(second[i].equals(first[j]))s++;
		 * if(second[i].equals(second[j]))s++; } subject = Math.max(f, subject);
		 * subject = Math.max(s, subject); }
		 */

		// 해결2
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		for (int i = 0; i < first.length; i++) {
			dic.put(first[i], 0);
			dic.put(second[i], 0);
		}

		for (int i = 0; i < first.length; i++) {
			dic.put(first[i], dic.get(first[i]) + 1);
			dic.put(second[i], dic.get(second[i]) + 1);
		}

		int subject = 0;

		for (String key : dic.keySet()) {
			subject = Math.max(subject, dic.get(key));
			System.out.println(key + " : " + dic.get(key));
		}

		return subject;

	}

	public static void main(String[] args) {
		InterestingParty party = new InterestingParty();

		String[] first = { "game", "music", "tour", "talking", "exercise" };
		String[] second = { "music", "talking", "movie", "food visit", "music" };
		System.out.println(party.bestInvitation(first, second));
	}

}
