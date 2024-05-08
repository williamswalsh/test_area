package binary_tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

// Depth first Search
public class DFS {

    private List<String> depthFirstSearchWithSidePriority(Node root, boolean startOnLeft) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node current;
        List<String> visited = new ArrayList<>();
        while (!stack.isEmpty()) {
            current = stack.pop();
            visited.add(current.value);

//            Ordering of these push statements change whether its left first or right first
//            If right is added first then left is stacked on top
//            left will be traversed first then right
            if (startOnLeft) {
                if (current.right != null){
                    stack.push(current.right);
                }
                if (current.left != null){
                    stack.push(current.left);
                }
            } else {
                if (current.left != null){
                    stack.push(current.left);
                }
                if (current.right != null){
                    stack.push(current.right);
                }
            }

        }
        return visited;
    }

    List<String> depthFirstSearchIterative2(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node current;
        List<String> visited = new ArrayList<>();

        while(!stack.isEmpty()) {
            current = stack.pop();
            visited.add(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

        }
        return visited;
    }

    private List<String> depthFirstSearchIterative(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node current;
        List<String> visited = new ArrayList<>();
        while (!stack.isEmpty()) {
            current = stack.pop();
            visited.add(current.value);

//            Ordering of these push statements change whether its left first or right first
//            If right is added first then left is stacked on top
//            left will be traversed first then right
            if (current.right != null){
                stack.push(current.right);
            }
            if (current.left != null){
                stack.push(current.left);
            }
        }
        return visited;
    }

    private List<String> depthFirstSearchRecursive(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> leftValues = depthFirstSearchRecursive(root.left);    // b, d, e
        List<String> rightValues = depthFirstSearchRecursive(root.right);  // c, f

        List<String> out = new ArrayList<>();
        out.add(root.value);
        out.addAll(leftValues);
        out.addAll(rightValues);

        return out;
    }

    private List<String> depthFirstSearchRecursive2(Node root) {
        if (root == null) {
            return List.of();
        }
        List<String> leftSide = depthFirstSearchRecursive2(root.left);
        List<String> rightSide = depthFirstSearchRecursive2(root.right);

        List<String> combo = new ArrayList<>();
        combo.add(root.value);
        combo.addAll(leftSide);
        combo.addAll(rightSide);
        return combo;

    }

    @Test
    public void dfsTest() {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

//        depthFirstSearch(a).forEach(System.out::println);
//        depthFirstSearchWithSidePriority(a, false).forEach(System.out::println);
        depthFirstSearchRecursive2(a).forEach(System.out::println);
    }

    @Test
    public void dfsRootIsNullTest() {
        assertTrue(depthFirstSearchIterative(null).isEmpty());
    }
}
