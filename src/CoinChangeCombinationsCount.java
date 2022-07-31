import java.util.ArrayList;
import java.util.HashMap;

public class CoinChangeCombinationsCount {
	
	public static int count(int[] coins, int target) {
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
		return countCombinations(coins,target,memo);
	}
	
	public static int countCombinations(int[] coins, int target, HashMap<Integer,Integer> memo) {
		if (target == 0) return 1;
		if (target < 0) return 0;
		if (memo.containsKey(target)) return memo.get(target);
		int totalCount = 0;
		for(int i = 0; i < coins.length; i++) {
			int remaining = target - coins[i];
			int combi = countCombinations(coins,remaining, memo );
			if(combi > 0)
				totalCount += combi;
		}
		memo.put(target, totalCount);
		return totalCount;
	}
	
	public static void main(String[] args) {
		int[] ar = {1,2,3};
		int target = 4;
		System.out.println(count(ar, target));
	}

}
