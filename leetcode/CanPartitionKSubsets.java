class Solution {
    int[] nums;
    boolean[] visited;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        
        this.nums = nums;
        this.visited = new boolean[nums.length];
        return canPartition(0, 0, 0, k, sum/k);
    }
    
    private boolean canPartition(int start, int curSum, int curNum, int part, int target) {
        if (part == 1) {
            return true;
        }
        
        if (curSum == target && curNum > 0) {
            return canPartition(0, 0, 0, part - 1, target);
        }
        
        for (int i = start; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(i + 1, curSum + nums[i], ++curNum, part, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
