/**454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                int sum = i + j;
                map.put(sum,map.getOrDefault(sum, 0) + 1);
            }
        }
         for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
/**383. Ransom Note
 * https://leetcode.com/problems/ransom-note/description/
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        for(int i = 0; i < m.length; i++){
            map.put(m[i], map.getOrDefault(m[i], 0) + 1);
        }
        for(int i = 0; i < r.length; i++){
            if(map.containsKey(r[i])&&(map.getOrDefault(r[i], 0)>0)){
               map.put(r[i], map.getOrDefault(r[i], 0)-1); 
            }else if(!map.containsKey(r[i])){
                return false;
            }else if(map.containsKey(r[i])&&(map.getOrDefault(r[i], 0)==0)){
                return false;
            }   
        }
        return true;
    }
}