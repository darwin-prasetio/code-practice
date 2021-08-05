// https://leetcode.com/problems/remove-k-digits/submissions/

class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        
        if (k >= n) return "0";
        
        Stack<Character> s = new Stack<>();
        for (Character c : num.toCharArray()) {
            while (k > 0 && !s.isEmpty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        
        while (k > 0) {
            s.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
