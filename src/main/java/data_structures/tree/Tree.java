package data_structures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree {
    private Node root;

    public Tree(int levels, int maxChildren, int maxValue) {
        Random random = new Random();
        root = generateRandomTree(levels, maxChildren, maxValue, random);
    }

    public boolean exist(int value) {
        if (root != null) {
            Node node = dfs(root, value);
            return node != null;
        }
        return false;
    }

    private Node generateRandomTree(int levels, int maxChildren, int maxValue, Random random) {
        if (levels == 0) {
            return null;
        }

        Node node = new Node(random.nextInt(maxValue + 1));
        int numChildren = random.nextInt(maxChildren + 1);
        node.children = new ArrayList<>(numChildren);
        for (int i = 0; i < numChildren; i++) {
            Node child = generateRandomTree(levels - 1, maxChildren, maxValue, random);
            if (child != null) {
                node.children.add(child);
            }
        }

        return node;
    }

    private Node dfs(Node node, int value) {
        if (node.value == value) {
            return node;
        }
        for (Node child : node.children) {
            Node result = dfs(child, value);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private Node bfs(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }

    public class Node {
        int value;
        List<Node> children;

        public Node(int value) {
            this.value = value;
        }

        public Node(){
            this.children = new ArrayList<>();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
