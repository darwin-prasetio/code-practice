// https://leetcode.com/problems/reordered-power-of-2/

class Solution {
    public boolean reorderedPowerOf2(int N) {
      int[] digits = countDigit(N);
      for (int i = 0; i < 30; ++i) {
        if (Arrays.equals(digits, countDigit((int) Math.pow(2.0, i)))) {
          return true;
        }
      }
      return false;
    }
  
  public int[] countDigit(int N) {
    int[] a = new int[10];
    while (N > 0) {
      a[N % 10]++;
      N /= 10;
    }
    return a;
  }
}