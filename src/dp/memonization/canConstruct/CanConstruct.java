package com.koushik.canConstruct;

import java.util.HashMap;

public class CanConstruct {

	public static boolean canConstruct(String target
			, String[] wordBank
			, HashMap<String, Boolean> memo
			) {
		if(target == "") return true;
		if(memo.containsKey(target))
			return memo.get(target);
		for(int i = 0; i < wordBank.length; i++) {
			if(target.indexOf(wordBank[i]) == 0) {
				String suffix = target.substring(wordBank[i].length());
				boolean res = canConstruct(suffix, wordBank, memo);
				memo.put(suffix, res);
				if(res)
					return res;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String[] wordBank = //{"ab","abc","cd","def","abcd"}; "abcdef" true
							//{"bo","rd","at","t","ska","sk","boar"}; "skateboard" false
							{ "a","p","ent","enter","ot","o","t"};
//							{	"ef",
//								"ee",
//								"eee",
//								"eeee",
//								"eeeeee",
//								"eeeeeeee",
//								"eeeeeeeee"
//							}; // false
		HashMap<String, Boolean> memo = new HashMap<>();
		System.out.println(canConstruct("enterapotentpot",wordBank,memo));
	}
}
