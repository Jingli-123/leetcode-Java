/**77. Combinations
 * 
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }
    public void backTracking(int n, int k, int startIdx){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i <= n; i++){
            path.add(i);
            backTracking(n, k, i+1);
            path.removeLast();
        }
    }
}
/**216. Combination Sum III
 * 
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }
    public void backTracking(int target, int k, int startIdx, int sum){
        if(sum > target)return;
        if(path.size() == k){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = startIdx; i <= 9 - (k - path.size()) + 1; i++){
            path.add(i);
            sum += i;
            backTracking(target, k, i+1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
/**17. Letter Combinations of a Phone Number
 * 
 */
class Solution {

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, letters, 0);
        return result;
    }

    StringBuilder temp = new StringBuilder();

    public void backTracking(String digits, String[] letters, int num){
        if(num == digits.length()){
            result.add(temp.toString());
            return;
        }
        String str = letters[digits.charAt(num) - '0'];
        for(int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            backTracking(digits, letters, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
