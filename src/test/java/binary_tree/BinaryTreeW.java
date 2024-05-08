package binary_tree;

public class BinaryTreeW {

    NodeW root;

    public BinaryTreeW() {
        root = null;
    }

    public BinaryTreeW(int value) {
        root = new NodeW(value);
    }

    public void traverseInOrder(NodeW node) {

//        If not root
        if (node != null) {
//            Recursive call on left node
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }
}
