package leetCode;

// 222. Count Complete Tree Nodes - EASY
public class NodeCounterTree {
    public int countNodes(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null) return 1;


        int leftHeight = 0;
        int rightHeight =0;

        TreeNode node = root.left;
        while (node != null){
            leftHeight++;
            node = node.left;
        }

        TreeNode nodeR = root.right;
        if (nodeR != null) {
            while (nodeR != null) {
                rightHeight++;
                nodeR = nodeR.left;
            }
        }
        if(leftHeight == rightHeight){
             return (int)Math.pow(2,leftHeight) + countNodes(root.right);
        }
        else{
           return  (int)Math.pow(2,rightHeight) + countNodes(root.left);
        }
    }
}
