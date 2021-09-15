class Solution {
    int n;
    List<Integer> res;
    
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        this.n = n;
        for (int i = 1; i < 10; ++i) {
            dfs(i);
        }
        return res;
    }
    
    private void dfs(int cur) {
        if (cur > n) {
            return;
        }
        
        res.add(cur);
        for (int i = 0; i < 10; ++i) {
            if (cur * 10 + i > n) {
                return;
            }
            dfs(cur * 10 + i);
        }
    }
}
