package TopCoder;

public class KiwiJuiceEasy {
	
	static int[] capacities = {10, 20, 30};
	static int[] bottles = {5, 10, 20};
	static int[] fromId = {0, 1, 2};
	static int[] toId = {1, 2, 0};
	
	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId,
			int[] toId) {

		for (int i = 0; i < fromId.length; i++) {
			
			//  3번
			
			int sum = bottles[fromId[i]] + bottles[toId[i]];
			bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
			
			/* 2 번
			int f = fromId[i];
			int t = toId[i];
			
			int vol = Math.min(bottles[f], capacities[t] - bottles[t] );
			bottles[t] += vol;
			bottles[f] -= vol;
			*/
			
			/*			1번
			int space = capacities[t] - bottles[t];

			if (space >= bottles[f]) {
				int vol = bottles[f];
				bottles[t] += vol;
				bottles[f] = 0;
			} else {
				int vol = space;
				bottles[t] += vol;
				bottles[f] -= vol;
			}*/
			
		}
		return bottles;
	}
	
	public static void main(String[] args) {
		KiwiJuiceEasy k = new KiwiJuiceEasy();
	
		k.thePouring(capacities, bottles, fromId, toId);
		
		for(int bottle : bottles){
			System.out.println(bottle);
		}
	}
}
