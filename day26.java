/**509.Fibonacci Number
 * 
 */

class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int[] dp = new int[n+1];
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int a = 0, b = 1, c = 0;
        for(int i = 1; i < n; i++){
            c = a + b;
            a = b;
            b = c; 
        }
        return c;
    }
}

/**509.Fibonacci Number
 * 这题不应该考虑0的情况
 */
class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int a = 1, b = 2, c = 0;
        for(int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

/**746.Min Cost Climbing Stairs
 * cost = [1,100,1,1,1,100,1,1,100,1]
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len <= 2)return Math.min(cost[0], cost[1]);
        int[] dp = new int[len+2];
        dp[0]=dp[1]=0;
        for(int i =2; i< len+1; i++){
            dp[i]=Math.min(cost[i-1]+dp[i-1], cost[i-2]+dp[i-2]);
            System.out.print(dp[i]);
        }
        return dp[len];
    }
}

