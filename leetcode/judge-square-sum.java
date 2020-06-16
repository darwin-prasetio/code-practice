// problem is at https://leetcode.com/problems/sum-of-square-numbers/

class Solution {
    public boolean judgeSquareSum(int c) {
      Set<Integer> set = new HashSet<>();
      for (int a = 0; a <= Math.sqrt(c); ++a) {
        int square = a * a;
        set.add(square);
        if (set.contains(c-square)) {
          return true;
        }
      }
      return false;
    }
}
