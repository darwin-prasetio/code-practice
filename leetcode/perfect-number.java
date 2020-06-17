// https://leetcode.com/problems/perfect-number/

class Solution {
    public boolean checkPerfectNumber(int num) {
      if (num <= 1) {
        return false;
      }
      int sum = 1;
      Set<Integer> set = new HashSet<>();
      for (int i = num % 2 == 0 ? 2 : 3; i <= num / 2; i += 2) {
        if (num % i == 0 && set.add(i)) {
          int x = num/i;
          sum += i + x;
          set.add(x);
        }
      }
      return sum == num;
    }
}