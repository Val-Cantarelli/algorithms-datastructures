package algs1;


public class Solution {
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean fulanoesta(TreeNode root, TreeNode target) {
        if (root == null) return true;
        if (root == target)
            return true;
        if (fulanoesta(root.left, target)) return true;
        return fulanoesta(root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // caso 1
        if (root == p && (fulanoesta(root.left, q) || fulanoesta(root.right, q)))
            return root;
        if (root == q && (fulanoesta(root.left, p)  || fulanoesta(root.right, p) ))
            return root;
        //caso 2
        if (root == p || root == q) return null;
        boolean isPleft = fulanoesta(root.left, p);
        boolean isPright = fulanoesta(root.right, p);
        boolean isQleft = fulanoesta(root.left, q);
        boolean isQright = fulanoesta(root.right, q);

        //caso 3
        if (isPright  && isQright )
            return lowestCommonAncestor(root.right, p, q);
        if (isPleft  && isQleft )
            return lowestCommonAncestor(root.left, p, q);
        if ((isQleft  && isPright) || (isPleft && isQright ))
            return root;


        return null;
    }
}

