package algorithms.trees;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*Given a tupla of pair "parent:child", answer if it is a binary tree */
public class TreeChecker {

    /*
    20-29:
    o 20 vai ser criado e adicionado o 29 como filho(L or R)

     For each pair:
     -node.parent exists?
     NO: create a node
     node.val = 5;
     * se ambos os filhos nao forem null e ainda != de val; return false
     node. left = 29;
     node.right = null;
     root = node.val;

     YES:
     -  o 29 já existe!
     O root de 29 é o mesmo que o parent.root? NAo. Entao: parent.root. find até root ser ele mesmo e atualiza(recursion)
     */

    // TReeNode definition and methods
    public static class TreeNode{
        private TreeNode root;
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        //Construct
        public TreeNode(int val) {
            this.val = val;
        }

        // Receives a node and recursively search for the real node - updating the inf
        public TreeNode findRoot() {
            if (this.parent == null || this.parent == this) {
                // Se não há pai, ou o pai é o próprio nó, este nó é a raiz
                return this;
            } else {
                // Caso contrário, pergunta ao pai quem é o root
                TreeNode parentRoot = this.parent.findRoot();
                // Ajusta o root para o root do pai
                this.root = parentRoot;
                return parentRoot;
            }
        }

        public boolean add(TreeNode childNode){
            // nao tem ciclo:
            //0: parent nao pode ser descente do child
            //6: o child nao pode já ter um parent
            //um pai pode ter só 2 filhos

            return false;
        }
   }


    private static TreeNode recover(Map<Integer, TreeNode> nodeMap, int i) {
        TreeNode result = nodeMap.get(i);
        if (result == null){
            result = new TreeNode(i);
            nodeMap.put(i, result);
        }
        return result;
    }

    // vai receber uma tupla, criar arvores e por fim repassar cada nó para saber se compartilham a mesma root
    private static boolean isConnected(int[][] tupleArray) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        for (int i = 0; i < tupleArray.length; i++) {
            // get nos valores
            TreeNode parentNode = recover(nodeMap, tupleArray[i][0]);
            TreeNode childNode = recover(nodeMap, tupleArray[i][1]);

            if(!parentNode.add(childNode)){
                return false;
            }
        }

        // Terminado de add nodes, confere se todos nodes compartilham mesma root
        Optional<TreeNode> first = nodeMap.values().stream().findFirst();
        if(first.isEmpty()) return true;
        TreeNode rootCandidate = first.get().findRoot();

        for (TreeNode node: nodeMap.values()){
            if(node.findRoot() != rootCandidate) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] tupleArray = new int[][]{
                {5,8},
                {9,20},
                {29,32},
                {20,29},
                {20,15},
                {9,30},
                {32,100},
        };

        boolean answer = TreeChecker.isConnected(tupleArray);
        System.out.println(answer);
    }
}

