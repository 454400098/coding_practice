
import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length; i ++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }
        
        return -1;
    }
    
    
    
    //Solution 2 using ascii map
        public int firstUniqChar2(String s) {
            //use less time;
            char[] fre = new char[26];
            for(char c : s.toCharArray()){
                fre[c-'a']++;
            }
            
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(fre[arr[i]-'a'] == 1) return i;
            }
            
            return -1;
        }
   
    
    
}
