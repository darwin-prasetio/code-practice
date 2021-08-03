// https://leetcode.com/problems/binary-tree-right-side-view/

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
    // use BFS so we can collect all nodes in each level and put the last element in the ans list
    // until all level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if (root == null) {
            return ans;
        }
        
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        while (!l.isEmpty()) {
            ans.add(l.get(l.size() - 1).val);
            
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode n : l) {
                if (n.left != null) {
                    temp.add(n.left);
                }
                if (n.right != null) {
                    temp.add(n.right);
                }
            }
            l = temp;
        }
        
        return ans;
    }
}
