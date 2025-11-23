/**209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        for(int j = 1; j < nums.length; j++){
            if(nums[i] == target){
                return 1;
            }
            sum += nums[j];
            if(sum > target){
                i++;
            }else if(sum == target && min > (j - i)){
                min = j - i;
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}