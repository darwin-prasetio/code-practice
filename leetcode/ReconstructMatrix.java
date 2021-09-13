class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[][] res = new int[2][n];
        for (int i = 0; i < n; ++i) {
            res[0][i] += colsum[i] == 2 || (colsum[i] == 1 && upper > lower) ? 1 : 0;
            res[1][i] += colsum[i] == 2 || (colsum[i] == 1 && res[0][i] != 1) ? 1 : 0;
            upper -= res[0][i];
            lower -= res[1][i];
        }
        return upper == 0 && lower == 0 ? convertToList(res) : new ArrayList<>();
    }
    
    private List<List<Integer>> convertToList(int[][] a) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] b : a) {
            List<Integer> temp = new ArrayList<>();
            for (int c : b) {
                temp.add(c);
            }
            res.add(temp);
        }
        return res;
    }
}
