public class BinaryTreeAlgorithms {

    // Preorder traversal of a binary tree.
    // Returns a string of the node values in preorder
    // (root, left, right).
    public static String preorder(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            return "";
        }
        String output = " " + tree.getItem();
        if (tree.hasLeft()) {
            output = output + preorder(tree.getLeft());
        }
        if (tree.hasRight()) {
            output = output + preorder(tree.getRight());
        }
        return output;
    }

    // Postorder traversal of a binary tree.
    // Returns a string of the node values in postorder
    // (left, right, root).
    public static String postorder(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            return "";
        }
        String output = "";
        if (tree.hasLeft()) {
            output = output + postorder(tree.getLeft());
        }
        if (tree.hasRight()) {
            output = output + postorder(tree.getRight());
        }
        output = output + " " + tree.getItem();
        return output;
    }

    // Inorder traversal of a binary tree.
    // Returns a string of the node values in inorder
    // (left, root, right).
    public static String inorder(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            return "";
        }
        String output = "";
        if (tree.hasLeft()) {
            output = output + inorder(tree.getLeft());
        }
        output = output + " " + tree.getItem();
        if (tree.hasRight()) {
            output = output + inorder(tree.getRight());
        }
        return output;
    }

    // A full binary tree is a binary tree in which every node
    // has either 0 or 2 children.
    public static boolean isFull(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            return true;
        }
        if (tree.hasLeft() && tree.hasRight()) {
            return isFull(tree.getLeft()) && isFull(tree.getRight());
        }
        if (!tree.hasLeft() && !tree.hasRight()) {
            return true;
        }
        return false;
    }

    // A perfect binary tree is a full binary tree in which
    // all leaves are also at the same depth.
    public static boolean isPerfect(BinaryTree tree) {
        return isPerfect(tree, height(tree), 0);
    }

    private static boolean isPerfect(BinaryTree tree, int totalHeight, int depth) {
        if (tree == null || !tree.hasItem()) {
            return true;
        }
        boolean hasLeft = tree.hasLeft();
        boolean hasRight = tree.hasRight();
        // Leaf: must be on the lowest level
        if (!hasLeft && !hasRight) {
            return depth == totalHeight;
        }
        // Inner node: must have exactly two children
        if (hasLeft && hasRight) {
            return isPerfect(tree.getLeft(), totalHeight, depth + 1)
                && isPerfect(tree.getRight(), totalHeight, depth + 1);
        }
        return false;
    }

    // Height of the tree: number of edges on the longest path from the
    // root to a leaf. Empty tree: -1, single node: 0.
    public static int height(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            return -1;
        }
        int left = tree.hasLeft() ? height(tree.getLeft()) : -1;
        int right = tree.hasRight() ? height(tree.getRight()) : -1;
        return 1 + Math.max(left, right);
    }

    // Searches for a value in a binary search tree. Returns true if the
    // value was found, otherwise false.
    public static boolean search(BinaryTree tree, int target) {
        if (tree == null || !tree.hasItem()) {
            return false;
        }
        if (tree.getItem() == target) {
            return true;
        }
        if (target < tree.getItem()) {
            return tree.hasLeft() && search(tree.getLeft(), target);
        } else {
            return tree.hasRight() && search(tree.getRight(), target);
        }
    }

    // Inserts a value into a binary search tree and returns the root.
    // Values that are already in the tree are not inserted again.
    public static BinaryTree insert(BinaryTree tree, int value) {
        if (tree == null || !tree.hasItem()) {
            return new BinaryTree(value);
        }
        if (value < tree.getItem()) {
            if (tree.hasLeft()) {
                insert(tree.getLeft(), value);
            } else {
                tree.setLeft(new BinaryTree(value));
            }
        } else if (value > tree.getItem()) {
            if (tree.hasRight()) {
                insert(tree.getRight(), value);
            } else {
                tree.setRight(new BinaryTree(value));
            }
        }
        return tree;
    }

    // Deletes a value from a binary search tree and returns the new root.
    // Three cases: a leaf is simply removed, a node with one child is
    // replaced by that child, and a node with two children takes the
    // smallest value of its right subtree (its inorder successor), which is
    // then deleted from there. If the value is not in the tree, nothing
    // changes. Deleting the last value returns null (empty tree).
    public static BinaryTree delete(BinaryTree tree, int value) {
        if (tree == null || !tree.hasItem()) {
            return tree;
        }
        if (value < tree.getItem()) {
            if (tree.hasLeft()) {
                tree.setLeft(delete(tree.getLeft(), value));
            }
            return tree;
        }
        if (value > tree.getItem()) {
            if (tree.hasRight()) {
                tree.setRight(delete(tree.getRight(), value));
            }
            return tree;
        }
        // Found the node to delete
        if (!tree.hasLeft()) {
            return tree.hasRight() ? tree.getRight() : null;
        }
        if (!tree.hasRight()) {
            return tree.getLeft();
        }
        int successor = min(tree.getRight());
        tree.setItem(successor);
        tree.setRight(delete(tree.getRight(), successor));
        return tree;
    }

    // Smallest value in a binary search tree: the leftmost node.
    public static int min(BinaryTree tree) {
        if (tree == null || !tree.hasItem()) {
            throw new IllegalArgumentException("The tree is empty.");
        }
        while (tree.hasLeft()) {
            tree = tree.getLeft();
        }
        return tree.getItem();
    }
}
