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

/**349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> list = new LinkedHashSet<>();
        if(l1>l2){
            for(int i = 0; i < l2; i++){
                map.merge(nums2[i], 1, Integer::sum);
            }
            for(int i = 0; i < l1; i++){
                if(map.containsKey(nums1[i])){
                    list.add(nums1[i]);
                }
            }
        }else{
            for(int i = 0; i < l1; i++){
                map.merge(nums1[i], 1, Integer::sum);
            }
            for(int i = 0; i < l2; i++){
                if(map.containsKey(nums2[i])){
                    list.add(nums2[i]);
                }
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index] = num;
            index++;
        }
        return result;
    }
}

/**202. Happy Number
 * https://leetcode.com/problems/happy-number/description/
 * Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while(n != 1 && !record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    public int getNextNumber(int n){
        int res = 0;
        while(n > 0){
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}