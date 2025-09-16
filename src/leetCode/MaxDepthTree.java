package leetCode;

public class MaxDepthTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepthTree(TreeNode root) {

        if (root == null) return 0;

        int leftDepth = maxDepthTree(root.left);
        int rightDepth = maxDepthTree(root.right);

        return 1 + Math.max(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = null;
        node2.right = null;

        node3.left = node4;
        node3.right = node5;

        node4.left = null;
        node4.right = null;

        node5.right = null;
        node5.left = null;

        int maxDepthTree = maxDepthTree(node1);

        System.out.println(maxDepthTree);




    }

}
