package leetCode;

import java.util.HashMap;
import java.util.Map;

public class BTfromPreorderInorder {

    private SameTree.TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inorderIndexMap
    ){
        // Caso base: não há mais elementos para processar
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // A raiz é o primeiro elemento do preorder atual
        int rootVal = preorder[preStart];
        SameTree.TreeNode root = new SameTree.TreeNode(rootVal);
        // Encontra a posição da raiz no inorder
        int inRootIndex = inorderIndexMap.get(rootVal);
        // Número de elementos na subárvore esquerda
        int leftTreeSize = inRootIndex - inStart;
        // Recursivamente constrói a subárvore esquerda
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize,
                inorder, inStart, inRootIndex - 1,
                inorderIndexMap);

        // Recursivamente constrói a subárvore direita
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd,
                inorderIndexMap);
        return root;

    }



    public SameTree.TreeNode buildTree(int[] preorder, int[] inorder) {
        //Criar map com inOrder
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }

        return build(preorder,0, preorder.length-1, inorder,0, inorder.length -1,inorderIndexMap);
    }
}
