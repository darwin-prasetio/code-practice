class Solution {
    int[] memo;
    int[] a;
    public int arrayNesting(int[] nums) {
        this.memo = new int[nums.length];
        this.a = nums;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(max, nest(i, new HashSet<Integer>()));
        }
        return max;
    }
    
    private int nest(int idx, Set<Integer> visited) {
        if (visited.contains(idx))
            return 0;
        
        if (memo[idx] != 0)
            return memo[idx];
        
        visited.add(idx);
        memo[idx] = 1 + nest(a[idx], visited);
        return memo[idx];
    }
}
