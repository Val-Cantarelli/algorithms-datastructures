package leetCode150;

public class InvertBinaryTree {


    public static SameTree.TreeNode invertTree(SameTree.TreeNode root) {

        //Case base: se for null, tem que fazer o swap mesmo assim
        //
        if(root == null) return null;
        //if(root.left == null && root.right == null) return root;

        // SWAP:
        SameTree.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursion
        invertTree(root.left);
        invertTree(root.right);

        System.out.println("Root: " + root.val);
        System.out.println("Left: " + (root.left != null ? root.left.val : "null"));
        System.out.println("Right: " + (root.right != null ? root.right.val : "null"));

        return root;
    }
}
