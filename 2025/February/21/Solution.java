import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FindElements {

    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();

        dfs(root, 0);
    }

    private void dfs(TreeNode root, int setValue) {
        if (root == null)
            return;

        root.val = setValue;
        set.add(setValue);

        dfs(root.left, setValue * 2 + 1);
        dfs(root.right, setValue * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */