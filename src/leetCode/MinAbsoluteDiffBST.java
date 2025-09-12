package leetCode;

public class MinAbsoluteDiffBST {

    public Integer prev = null;
    private Integer minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(SameTree.TreeNode node) {
        minimumDiff(node);
        return minDiff;

    }
    private void minimumDiff(SameTree.TreeNode node){
        if (node == null) return;
        System.out.println("Visitando " + node.val);
        minimumDiff(node.left);

        System.out.println("Visitando " + node.val);
        if (prev != null) {
            minDiff = Math.abs(Math.min(minDiff, node.val - prev));
            }

        prev = node.val;
        System.out.println("Visitando " + node.val);
        minimumDiff(node.right);
        System.out.println("Visitando " + node.val);
        }

    public static void main(String[] args) {
        SameTree.TreeNode root = new SameTree.TreeNode(4);
        root.left = new SameTree.TreeNode(2);
        root.right = new SameTree.TreeNode(6);
        root.left.left = new SameTree.TreeNode(1);
        root.left.right = new SameTree.TreeNode(3);

        MinAbsoluteDiffBST solver = new MinAbsoluteDiffBST();
        int result = solver.getMinimumDifference(root);
        System.out.println("Min value: "+result);
    }
}
