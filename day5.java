/**242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        for(int i = 0; i < t.length(); i++){
            if (!map.containsKey(t.charAt(i))) return false;
            map.computeIfPresent(t.charAt(i), (key, value)->{
                int newValue = value - 1;
                return newValue == 0 ? null : newValue;
            });
        }
        if(map.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * 
 */