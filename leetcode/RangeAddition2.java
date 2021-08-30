class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for (int[] o : ops) {
            row = Math.min(row, o[0]);
            col = Math.min(col, o[1]);
        }
        return row * col;
    }
}
