package drill;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BinarySearchTreeTest {
    @Test
    public void testBinarySearchTree(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(33);
        binarySearchTree.add(13);
        binarySearchTree.add(50);
        binarySearchTree.add(17);
        binarySearchTree.add(3);
        binarySearchTree.add(34);
        binarySearchTree.add(36);
        binarySearchTree.add(2);
        binarySearchTree.add(78);
        binarySearchTree.add(37);
        BinarySearchTree binarySearchTree2 = new BinarySearchTree();
        binarySearchTree2.add(33);
        binarySearchTree2.add(13);
        binarySearchTree2.add(50);
        binarySearchTree2.add(17);
        binarySearchTree2.add(3);
        binarySearchTree2.add(34);
        binarySearchTree2.add(36);
        binarySearchTree2.add(2);
        binarySearchTree2.add(78);
        binarySearchTree2.add(37);


        Iterator iter1 = binarySearchTree.iteratorLeaf();
        Iterator iter2 = binarySearchTree2.iteratorLeaf();
        boolean areLeafSeq = true;

        while (iter1.hasNext() && iter2.hasNext()){
            if(!iter1.next().equals(iter2.next())){
                areLeafSeq =  false;
                break;
            }
        }

        if (iter1.hasNext() || iter2.hasNext()) {
            areLeafSeq = false;
        }

        assertTrue(areLeafSeq, "As folhas das duas árvores não são iguais.");


        /*System.out.println("Elementos na árvore em ordem:");
        binarySearchTree.printInOrder();
        assertEquals(2, binarySearchTree.findFirstLeaf(),
                "FirstLeaf: "+binarySearchTree.findFirstLeaf());

        assertEquals(78, binarySearchTree.findLastLeaf(),
                "LastLeaf: "+binarySearchTree.findLastLeaf());
*/

    }

}