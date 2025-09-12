package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AveregeLevelTree {

    public List<Double> averageOfLevels(SameTree.TreeNode node) {
        List<Double> result = new ArrayList<>();

        Queue<SameTree.TreeNode> fila = new LinkedList<>();
        fila.add(node);

        int count = 0;
        int current_level = 1;
        int prox_level = 0;
        double sum = 0;


        while(!fila.isEmpty()){
            SameTree.TreeNode currentNode = fila.poll();
            sum += currentNode.val;
            count++;

            if (currentNode.left != null) {
                fila.add(currentNode.left);
                prox_level++;
            }
            if (currentNode.right != null){
                fila.add(currentNode.right);
                prox_level++;
            }

            if(count == current_level){
                result.add(Double.valueOf(sum/current_level));
                count = 0;
                current_level = prox_level;
                prox_level = 0;
                sum = 0;
            }
        }
        return result;
    }
}
