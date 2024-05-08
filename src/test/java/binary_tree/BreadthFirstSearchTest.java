package binary_tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchTest {

    List<String> search(Node root) {
        if (root == null) {
            return List.of();
        }

        List<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        List<String> visited = new ArrayList<>();
        while (!queue.isEmpty()) {
            current = queue.remove(0);
            visited.add(current.value);

            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
        return visited;
    }

    @Test
    public void bfsTest() {
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
        search(a).forEach(System.out::println);
    }
}
