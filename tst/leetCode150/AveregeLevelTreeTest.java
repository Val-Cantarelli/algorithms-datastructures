package leetCode150;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class AveregeLevelTreeTest {

    @Test
    public void testAverageOfLevels() {
        // Monta a seguinte árvore:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        SameTree.TreeNode root = new SameTree.TreeNode(3,
                new SameTree.TreeNode(9),
                new SameTree.TreeNode(20, new SameTree.TreeNode(15), new SameTree.TreeNode(7))
        );

        AveregeLevelTree solution = new AveregeLevelTree();
        List<Double> result = solution.averageOfLevels(root);

        // Esperado:
        // Nível 0: [3] => 3.0
        // Nível 1: [9, 20] => (9 + 20) / 2 = 14.5
        // Nível 2: [15, 7] => (15 + 7) / 2 = 11.0
        List<Double> expected = List.of(3.0, 14.5, 11.0);

        assertEquals(expected.size(), result.size(), "Levels number incorrect");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i), 1e-5, "Level error " + i);
        }
    }
}
