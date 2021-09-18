class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] idxFreq = countIdxFreq(requests, nums.length);
        return sumRange(idxFreq, nums);
    }
    
    private int[] countIdxFreq(int[][] requests, int n) {
        int[] count = new int[n];
        for (int[] req : requests) {
            ++count[req[0]];
            if (req[1] + 1 < n) {
                --count[req[1] + 1];
            }
        }
        for (int i = 1; i < n; ++i) {
            count[i] += count[i - 1];
        }
        return count;
    }
    
    private int sumRange(int[] idxFreq, int[] nums) {
        long mod = (long) 1e9 + 7, sum = 0;
        Arrays.sort(nums);
        Arrays.sort(idxFreq);
        for (int i = 0; i < nums.length; ++i) {
            sum += (long)nums[i] * idxFreq[i];
        }
        return (int) (sum % mod);
    }
}
