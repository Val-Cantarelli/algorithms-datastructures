package leetCode;
/*
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes
 *  along the longest path from the root node down to
 * the farthest leaf node.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // Case base
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Add 1: we're counting the nodes, not the edges
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
