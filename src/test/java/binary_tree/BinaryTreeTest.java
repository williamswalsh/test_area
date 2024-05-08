package binary_tree;

import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void binTree() {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node("1");
        tree.root.left = new Node("2");
        tree.root.right = new Node("3");
        tree.root.left.left = new Node("4");

        System.out.print("Pre order Traversal: ");
        tree.traversePreOrder(tree.root);
        System.out.print("\nIn order Traversal: ");
        tree.traverseInOrder(tree.root);
        System.out.print("\nPost order Traversal: ");
        tree.traversePostOrder(tree.root);
    }
}
