class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        
        while (l < r) {
            int mid = (l + r) / 2, cur = 0, daysNeeded = 1;
            for (int w : weights) {
                if (cur + w > mid) {
                    daysNeeded++;
                    cur = 0;
                }
                cur += w;
            }
            if (daysNeeded > days) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}
