class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < arr.length && start >= 0 && arr[start] >= 0) {
            arr[start] = -arr[start];
            return arr[start] == 0 || canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
