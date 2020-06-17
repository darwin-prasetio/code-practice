// https://leetcode.com/problems/rectangle-area/

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
      int rect1 = computeRect(A, B, C, D);
      int rect2 = computeRect(E, F, G, H);
      
      if ((B >= H) || (C <= E) || (A >= G) || (F >= D)) {
        return rect1 + rect2;
      } else {
        return rect1 + rect2 - Math.abs(Math.min(C, G) - Math.max(A, E)) * Math.abs(Math.min(D, H) - Math.max(B, F));
      }
    }
  
  public int computeRect(int A, int B, int C, int D) {
    return Math.abs(C-A) * Math.abs(D-B);
  }
}