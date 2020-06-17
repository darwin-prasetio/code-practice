// https://leetcode.com/problems/self-dividing-numbers/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
      List<Integer> answer = new ArrayList<>();
      // Set<Integer> set = new HashSet<>();
      for (int i = left; i <= right; ++i) {
        String n = String.valueOf(i);
        if (n.contains("0")) {
          continue;
        } else {
          int j = 0;
          boolean divided = true;
          while (j < n.length() && divided) {
            char c = n.charAt(j);
            if (i % Integer.parseInt(String.valueOf(c)) != 0) {
              divided = false;
            }
            ++j;
          }
          if (divided) {
            answer.add(i);
          }
        }
      }
      return answer;
    }
}