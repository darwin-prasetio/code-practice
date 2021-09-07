class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lp = new int[n], rp = new int[n];
        lp[0] = nums[0];
        rp[n - 1] = nums[n - 1];
        
        for (int i = 1; i < n; ++i) {
            lp[i] = lp[i - 1] * nums[i];
            rp[n - 1 - i] = rp[n - i] * nums[n - 1 - i];
        }
        
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int leftProduct = i - 1 >= 0 ? lp[i - 1] : 1;
            int rightProduct = i + 1 < n ? rp[i + 1] : 1;
            ans[i] = leftProduct * rightProduct;
        }
        return ans;
    }
}
