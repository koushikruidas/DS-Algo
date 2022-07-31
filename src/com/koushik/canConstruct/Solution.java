package com.koushik.canConstruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
	public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        String rev = "";
        HashMap<String, Integer> memo = new HashMap<String,Integer>();
        for(int i = len - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        int len2 = rev.length();
        return lcsMemo(s,rev,len,len,memo);
    }
    
    public static int lcsMemo(String s1, String s2, int len1, int len2, HashMap<String, Integer> memo){
        if(len1 == 0 || len2 == 0){
            memo.put(Integer.toString(len1)+" "+Integer.toString(len2), 0);
            return 0;
        }
        if(memo.containsKey(Integer.toString(len1)+" "+Integer.toString(len2)))
            return memo.get(Integer.toString(len1)+" "+Integer.toString(len2));
        if(s1.charAt(len1 - 1) == s2.charAt(len2 - 1)){
            int res = 1 + lcsMemo(s1,s2,len1 - 1, len2 - 1, memo);
            memo.put(Integer.toString(len1)+" "+Integer.toString(len2),res);
            return res;
        }
        else {
            int res = Math.max( lcsMemo(s1,s2,len1 - 1, len2, memo)
                              , lcsMemo(s1,s2,len1 , len2 - 1, memo));
            memo.put(Integer.toString(len1)+" "+Integer.toString(len2), res);
            return res;
        }
    }

	public static void main(String[] args) {
		String[] ar = {"aabbcc", "aabbcc","c","e","aabbcd"};
		System.out.println(longestPalindromeSubseq("GEEKSFORGEEKS"));
	}
}
