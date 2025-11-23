/**209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Approach: sliding windows. set i as start point, j as end point
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int length = 0;
        int sum = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            length++;
            while(sum >= target){
                min = Math.min(length, min);
                sum -= nums[i];
                i++;
                length--;
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}