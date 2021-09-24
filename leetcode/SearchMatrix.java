class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ++i) {
            if (target <= matrix[i][matrix[i].length - 1]) {
                return Arrays.binarySearch(matrix[i], target) >= 0;
            }
        }
        return false;
    }
}
