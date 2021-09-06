class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = keysPressed.length(), t = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        
        for (int i = 1; i < n; ++i) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];
            if (cur > t) {
                t = cur;
                ans = keysPressed.charAt(i);
            } else if (cur == t) {
                ans = ans > keysPressed.charAt(i) ? ans : keysPressed.charAt(i);
            }
        } 
        return ans;
    }
}
