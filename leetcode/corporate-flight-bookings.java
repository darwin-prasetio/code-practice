// https://leetcode.com/problems/corporate-flight-bookings/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
      int[] answer = new int[n];
      for (int[] booking : bookings) {
        int i = booking[0];
        int j = booking[1];
        int k = booking[2];
        
        answer[i - 1] += k;
        if (j < n) {
          answer[j] -= k;
        }
      }
      
      for (int i = 1; i < n; ++i) {
        answer[i] = answer[i] + answer[i-1];
      }
      
      return answer;
    }
}