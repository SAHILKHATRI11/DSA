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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public void dfs(TreeNode root){
        if(root == null)return;
        if(root.left != null){
            root.left.val = 2*root.val + 1;
            set.add(root.left.val);
            dfs(root.left);
        }
        if(root.right!=null){
            root.right.val = 2*root.val + 2;
            set.add(root.right.val);
            dfs(root.right);
        }
    }
    public FindElements(TreeNode root) {
        root.val = 0;
        dfs(root);
        set.add(0);
    }
    
    public boolean find(int target) {
        if(set.contains(target))return true;
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */