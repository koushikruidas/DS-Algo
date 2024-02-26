package com.koushik.canConstruct;

import java.util.HashMap;

public class CountConstruct {

	public static int countConstruct(String target
			, String[] wordBank
			, HashMap<String, Integer> memo
			) {
		int totalCount = 0;

		if(memo.containsKey(target)) return memo.get(target);
		if(target  =="") return 1;
		
		for(int i = 0; i < wordBank.length; i++) {
			if(target.indexOf(wordBank[i]) == 0) {
				String suffix = target.substring(wordBank[i].length()); 
				int res = countConstruct(suffix, wordBank, memo);
				totalCount += res;
			}
		}
		memo.put(target, totalCount);
		return totalCount;
	}
	
	public static void main(String[] args) {
		String[] wordBank = //{"ab","abc","cd","def","abcd"}; "abcdef" true
				//{"bo","rd","at","t","ska","sk","boar"}; "skateboard" false
				{ "a","p","ent","enter","ot","o","t"}; // "enterapotentpot"
//			{"purp","p","ur","le","purpl"}; // "purple" 2
//				{	"e",
//					"e",
//					"ee",
//					"eee",
//					"eeee",
//					"eeeeee",
//					"eeeeeeee",
//					"eeeeeeeee"
//				}; // false
		HashMap<String, Integer> memo = new HashMap<>();
		System.out.println(countConstruct("enterapotentpot", wordBank, memo));
	}
}
