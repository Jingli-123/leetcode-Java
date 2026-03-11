/**134. Gas Station
 *
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int start =0;
      int total = 0;
      int tank = 0;
      for(int i = 0; i < gas.length; i++){
        int diff = gas[i] - cost[i];
        total += diff;
        tank += diff;
        if(tank<0){
            start= i+ 1;
            tank = 0;
        }
      }
      if(total < 0) return -1;
      return start;
    }
}

/**860. Lemonade Change
 *
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill == 5)five++;
            if(bill == 10){
                if(five==0)return false;
                if(five>0){
                    five--;
                    ten++;
                } 
            }
            if(bill == 20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five = five -3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

/**135. Candy
*There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
*/

class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int res = 0;
        candy[0]=1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i-1]< ratings[i]){
                candy[i] = ratings[i-1]+1;
            }else{
                candy[i] = 1;
            }
        }
        for(int i = ratings.length - 2; i >=0; i--){
            if(ratings[i]> ratings[i+1]){
                candy[i]=Math.max(candy[i+1], candy[i]+1);
            }
        }
        for(int c : candy){
            res+=c;
        }
        return res;
    }
}