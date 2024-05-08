package binary_tree;

import org.junit.Test;

public class BinaryTreeFTest {

    @Test
    public void dfsTest() {
        NodeF a = new NodeF(1);
        NodeF b = new NodeF(2);
        NodeF c = new NodeF(3);
        NodeF d = new NodeF(4);
        NodeF e = new NodeF(5);
        NodeF f = new NodeF(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4  5    6


//        depthFirstSearch(a).forEach(System.out::println);
//        depthFirstSearchWithSidePriority(a, false).forEach(System.out::println);
        BinaryTreeF binaryTree = new BinaryTreeF(a);
//        binaryTree.depthFirstSearchIterative(a).forEach(System.out::println);
        binaryTree.depthFirstSearchRecursiveFinal(a).forEach(System.out::println);
    }
}
