class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int topBoundary = 0, bottomBoundary = matrix.length - 1, leftBoundary = 0, rightBoundary = matrix[0].length - 1;
        while (topBoundary <= bottomBoundary &&
               leftBoundary <= rightBoundary) {
            for (int j = leftBoundary; j <= rightBoundary; ++j) {
                res.add(matrix[topBoundary][j]);
            }
            ++topBoundary;
            if (topBoundary > bottomBoundary) break;
            
            for (int i = topBoundary; i <= bottomBoundary; ++i) {
                res.add(matrix[i][rightBoundary]);
            }
            --rightBoundary;
            if (rightBoundary < leftBoundary) break;
            
            for (int j = rightBoundary; j >= leftBoundary; --j) {
                res.add(matrix[bottomBoundary][j]);
            }
            --bottomBoundary;
            if (bottomBoundary < topBoundary) break;
            
            for (int i = bottomBoundary; i >= topBoundary; --i) {
                res.add(matrix[i][leftBoundary]);
            }
            ++leftBoundary;
        }
        return res;
    }
}
