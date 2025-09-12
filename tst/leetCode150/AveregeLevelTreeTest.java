package leetCode150;

import leetCode.AveregeLevelTree;
import leetCode.SameTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class AveregeLevelTreeTest {

    @Test
    public void testAverageOfLevels() {

        SameTree.TreeNode root = new SameTree.TreeNode(3,
                new SameTree.TreeNode(9),
                new SameTree.TreeNode(20, new SameTree.TreeNode(15), new SameTree.TreeNode(7))
        );

        AveregeLevelTree solution = new AveregeLevelTree();
        List<Double> result = solution.averageOfLevels(root);

        List<Double> expected = List.of(3.0, 14.5, 11.0);

        assertEquals(expected.size(), result.size(), "Levels number incorrect");

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i), 1e-5, "Level error " + i);
        }
    }
}
