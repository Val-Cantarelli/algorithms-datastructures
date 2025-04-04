package leetCode150;


public class SymmetricTree {
    public static void main(String[] args) {
        SameTree.TreeNode root = new SameTree.TreeNode(1,
                new SameTree.TreeNode(2, new SameTree.TreeNode(3), new SameTree.TreeNode(4)),
                new SameTree.TreeNode(2, new SameTree.TreeNode(4), new SameTree.TreeNode(3))
        );

        SymmetricTree sym = new SymmetricTree();
        boolean result = sym.isSymmetric(root);
        System.out.println(result);
    }

    public boolean isSymmetric(SameTree.TreeNode p, SameTree.TreeNode q ){
        if(p == null || q == null) return p== q;
        if(p.val != q.val) return false;
        return  isSymmetric(p.left, q.right) &&
                isSymmetric(p.right, q.left);
    }

    public boolean isSymmetric(SameTree.TreeNode root) {
        // Uma árvore
        if(root == null) return true;
        // Duas arvores
        return isSymmetric(root.left,root.right);
    }
}
