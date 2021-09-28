class Solution {
    List<List<Integer>> ans;
    int[] A;
    int target;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.A = candidates;
        this.target = target;
        
        Arrays.sort(A);
        combine(0, 0, new ArrayList<>());
        return ans;
    }
    
    private void combine(int idx, int sum, List<Integer> temp) {
        if (sum > target)
            return;
        
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = idx; i < A.length; ++i) {
            if (A[i] > target)
                continue;
            
            if (i > idx && A[i] == A[i - 1])
                continue;
            
            temp.add(A[i]);
            combine(i + 1, sum + A[i], temp);
            temp.remove(temp.size() - 1);
        }
    }
}
