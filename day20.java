/**39. Combination Sum
 * 
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum = 0;
        backTracking(candidates, target, 0);
        return result;
    }
    public void backTracking(int[] candidates, int target, int startIdx){
        if(sum > target)return;
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i < candidates.length; i++){
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, i);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
/**40. Combination Sum II
 * 
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sum = 0;
        backTracking(candidates, target, 0);
        return result;
    }
    public void backTracking(int[] candidates, int target, int startIdx){
        Arrays.sort(candidates);
        if(sum > target)return;
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i < candidates.length; i++){
            if(i > startIdx && candidates[i] == candidates[i-1])continue;
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, i+1);
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
/**
 * 
 */