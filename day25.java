/**56. Merge Intervals
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < len; i++){
            if(intervals[i][0]>right){
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else{
               right = Math.max(right, intervals[i][1]);
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}

/**738. Monotone Increasing Digits
 * 
 */

class Solution {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] ch = str.toCharArray();
        int start = ch.length;
        for(int i = ch.length - 2; i >= 0; i--){
            if(ch[i]>ch[i+1]){
                ch[i]--;
                start= i+1;
            }
        }
        for(int i = start; i < ch.length; i++){
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}