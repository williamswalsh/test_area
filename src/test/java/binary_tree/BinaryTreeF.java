package binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeF {

    NodeF root;

    public BinaryTreeF(NodeF root) {
        this.root = root;
    }

    List<Integer> depthFirstSearchIterative(NodeF root) {
        if (root == null) {
            return List.of();
        }
        Stack<NodeF> stack = new Stack<>();
        stack.push(root);
        List<Integer> visited = new ArrayList<>();
        NodeF current;

        while (!stack.isEmpty()) {
            current = stack.pop();
            visited.add(current.value);

            if (current.right!=null) {
                stack.push(current.right);
            }
            if (current.left!=null) {
                stack.push(current.left);
            }
        }
        return visited;
    }

    List<Integer> depthFirstSearchRecursiveFinal(NodeF root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> leftSide = depthFirstSearchRecursiveFinal(root.left);
        List<Integer> rightSide = depthFirstSearchRecursiveFinal(root.right);

        List<Integer> combined = new ArrayList<>();
        combined.add(root.value);
        combined.addAll(leftSide);
        combined.addAll(rightSide);
        return combined;
    }
}
