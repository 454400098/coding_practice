import java.util.*;
public class Solution {
	public static boolean isallin(String s1, String s2) {
		//hashmap
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		//traverse s1 to word count all word in s1
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		System.out.println(map.toString());
		for(char c: s2.toCharArray()) {
			if(map.containsKey(c)) {
				int tmp = map.get(c);
				if(tmp - 1 == 0) {
					map.remove(c);
				}else {
					map.put(c, tmp-1);
				}
			}else {
				return false;
			}
		}
		System.out.println(map.toString());
		if(map.size() == 0 ) return true;
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		String s1 = "aaaabc";
		String s2 = "ae";
		System.out.println(isallin(s1,s2));
	}
}