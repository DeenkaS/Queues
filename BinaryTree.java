import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }

    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Stack<Node> stack;

        public TreeIterator() {
            stack = new Stack<Node>();
            next = root;
            while (next.left != null) {
                stack.push(next);
                next = next.left;

            }
        }

        @Override
        public boolean hasNext() {
            if (stack.empty()) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            Integer returnvalue = next.value; // save current node vlue

            // are we done yet?

            if (next.right != null) { // do we have something to the right?
                stack.push(next.right); // save the thing to the right
                next = next.right; // step right

                if (next.left != null) { // do we have something to the left?
                    stack.push(next); // push left to stack
                    while (next.left != null) {
                        stack.push(next);
                        next = next.left;
                    }
                }

            }

            if (!hasNext()) {
                throw new EmptyStackException();
            }

            next = stack.pop();
            return returnvalue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    void add(Integer key, Integer value) {
        Node next = this.root;

        if (this.root == null) {
            this.root = new Node(key, value);
            return;
        } else {
            while (true) {
                if (next.key > key) {
                    if (next.left == null) {
                        next.left = new Node(key, value);
                        return;
                    }
                    next = next.left;
                }
                if (next.key < key) {
                    if (next.right == null) {
                        next.right = new Node(key, value);
                        return;
                    }
                    next = next.right;
                }
                if (next.key == key) {
                    next.value = value;
                    return;
                }
            }
        }
    }

    Integer lookup(Integer key) {
        Node next = this.root;

        if (this.root == null) {
            return null;
        } else {
            while (true) {
                if (next.key > key) {
                    if (next.left == null) {
                        return null;
                    }
                    next = next.left;
                }
                if (next.key < key) {
                    if (next.right == null) {
                        return null;
                    }
                    next = next.right;
                }
                if (next.key == key) {
                    return next.value;
                }
            }
        }
    }

}
