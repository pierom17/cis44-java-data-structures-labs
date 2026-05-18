import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }
        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);

        int middleKey = node.keys.get(2);

        List<Integer> leftKeys = new ArrayList<>();
        leftKeys.add(node.keys.get(0));
        leftKeys.add(node.keys.get(1));

        List<Integer> rightKeys = new ArrayList<>();
        rightKeys.add(node.keys.get(3));
        TwoFourNode rightNode = new TwoFourNode();
        rightNode.keys = rightKeys;

        List<TwoFourNode> oldChildren = new ArrayList<>(node.children);

        node.keys = leftKeys;
        node.children = new ArrayList<>();
        if (!oldChildren.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                node.children.add(oldChildren.get(i));
                oldChildren.get(i).parent = node;
            }

            for (int i = 3; i < oldChildren.size(); i++) {
                rightNode.children.add(oldChildren.get(i));
                oldChildren.get(i).parent = rightNode;
            }
        }

        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(middleKey);
            newRoot.children.add(node);
            newRoot.children.add(rightNode);

            node.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        } else {
            TwoFourNode parent = node.parent;
            int index = parent.children.indexOf(node);

            parent.keys.add(index, middleKey);
            parent.children.add(index + 1, rightNode);

            rightNode.parent = parent;
        }
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null)
            return;
        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}