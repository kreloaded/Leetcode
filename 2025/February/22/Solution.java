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
class Solution {
    int n = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int[] index = { 0 }; // array to use as pass by reference
        return solve(traversal.toCharArray(), index, 0);
    }

    private TreeNode solve(char[] t, int[] index, int depth) {
        if (index[0] >= n) {
            return null;
        }

        int j = index[0];
        while (j < n && t[j] == '-') {
            j++;
        }

        int dashCount = j - index[0];
        if (dashCount != depth) {
            return null;
        }

        index[0] += dashCount;

        int num = 0;
        while (index[0] < n && Character.isDigit(t[index[0]])) {
            num = (num * 10) + (t[index[0]] - '0');
            index[0]++;
        }

        TreeNode root = new TreeNode(num);
        root.left = solve(t, index, depth + 1);
        root.right = solve(t, index, depth + 1);

        return root;
    }
}

// TC: O(n) - n length of the traversal string
// SC: O(n) - internal stack space