/**62. Unique Paths
 * 动态规划
机器人从(0 , 0) 位置出发，到(m - 1, n - 1)终点。

按照动规五部曲来分析：

确定dp数组（dp table）以及下标的含义
dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。

确定递推公式
想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。

此时在回顾一下 dp[i - 1][j] 表示啥，是从(0, 0)的位置到(i - 1, j)有几条路径，dp[i][j - 1]同理。

那么很自然，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来。

dp数组的初始化
如何初始化呢，首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理。

所以初始化代码为：

for (int i = 0; i < m; i++) dp[i][0] = 1;
for (int j = 0; j < n; j++) dp[0][j] = 1;
确定遍历顺序
这里要看一下递推公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，dp[i][j]都是从其上方和左方推导而来，那么从左到右一层一层遍历就可以了。

这样就可以保证推导dp[i][j]的时候，dp[i - 1][j] 和 dp[i][j - 1]一定是有数值的。

举例推导dp数组

 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0]= 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j]= 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j]=dp[i-1][j] + dp[i][j-1];
                System.out.print(dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
/**63
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0]!= 1){
                dp[0][j]=1;
            }
        }
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j]!= 1){
                dp[0][j]=1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j]!= 1){
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                    System.out.print(dp[i][j]);
                }
            }
        }
        return dp[i-1][j-1];

    }
}

/**背包问题
 * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，但是他的行李箱空间有限。
 * 这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的空间，并且具有不同的价值。 
 *小明的行李空间为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
 第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。

第二行包含 M 个正整数，代表每种研究材料的所占空间。 

第三行包含 M 个正整数，代表每种研究材料的价值。
输出一个整数，代表小明能够携带的研究材料的最大价值。
输入示例
6 1
2 2 3 1 5 2
2 3 1 5 4 3
输出示例
5
提示信息
小明能够携带 6 种研究材料，但是行李空间只有 1，而占用空间为 1 的研究材料价值为 5，所以最终答案输出 5。 

数据范围：
1 <= N <= 5000
1 <= M <= 5000

 */
class Solution {
    public int bagProblem(int m, int n, int[] items, int[] itmesValue) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0]=itemsValue[0];
        }
        for(int j = 0; j < n; j++){
            dp[0][j]=0;
        }
        

    }
}