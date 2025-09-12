package leetCode;


public class SymmetricTree {

    public boolean isSymmetric(SameTree.TreeNode p, SameTree.TreeNode q ){
        if(p == null || q == null) return p== q;
        if(p.val != q.val) return false;
        return  isSymmetric(p.left, q.right) &&
                isSymmetric(p.right, q.left);
    }

    public boolean isSymmetric(SameTree.TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
}
