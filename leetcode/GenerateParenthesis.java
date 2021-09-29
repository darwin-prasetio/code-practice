class Solution {
    List<String> res;
    int max;
    
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.max = n;
        backtrack("", 0, 0);
        return res;
    }
    
    private void backtrack(String s, int open, int close) {
        if (s.length() == max * 2) {
            res.add(s);
            return;
        }
        
        if (open < max) {
            backtrack(s + "(", open + 1, close);
        }
        if (close < open) {
            backtrack(s + ")", open, close + 1);
        }
    }
}
