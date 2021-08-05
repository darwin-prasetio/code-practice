// https://leetcode.com/problems/path-sum-ii/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // backtrack so we can visit the sibling of current root
    List<List<Integer>> res = new ArrayList<>();
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if (root != null) {
            findSum(root, new ArrayList<>(), 0);
        }
        return res;
    }
    
    private void findSum(TreeNode node, List<Integer> path, int cur) {
        if (node == null) {
            return;
        }
        
        cur += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && cur == target) {
            res.add(new ArrayList<>(path));
        } else {
            findSum(node.left, path, cur);
            findSum(node.right, path, cur);
        }
        path.remove(path.size() - 1);
    }
}
