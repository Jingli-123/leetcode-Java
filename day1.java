/**leetcode704.
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1. You must write an algorithm with O(log n) runtime complexity.
 * https://leetcode.com/problems/binary-search/description/
 * Note: in while loop, if you choose right = nums.length -1, then while(left <= right)
*/

//method 1
class Solution {
public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
};

//method 2
class Solution {
public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
};

/** leetcode 27
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
*https://leetcode.com/problems/remove-element/
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

/**leetcode 977 https://leetcode.com/problems/squares-of-a-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * 
 */

//method 1
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

//method 2
class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int [] result = new int[length];
        int left = 0;
        int right = length - 1;
        for(int i = length - 1; i >= 0; i--){
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if(l <= r){
                result[i] = r;
                right--;
            }else{
                result[i] = l;
                left++;
            }
        }
        return result;
    }
}