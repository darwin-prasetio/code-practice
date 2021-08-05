// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

class Solution {
    // sort array first
    // if we can do 0 moves, the diff is max(nums) - min(nums)
    // 1 move, diff is min(secondMax(nums) - min(nums), max(nums) - secondMin(nums))
    // conclusion: kill x elements in front and y elements in back, with x + y = allowed moves
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 4] - nums[0], b = nums[n - 3] - nums[1], c = nums[n - 2] - nums[2], d = nums[n - 1] - nums[3];
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}
