/**
 * A simple binary tree holding integer values.
 *
 * Each node stores a value (item) and has at most
 * one left and one right subtree.
 */
public class BinaryTree {

    private Integer item;
    private BinaryTree left;
    private BinaryTree right;

    /** Empty tree without a value. */
    public BinaryTree() {
        this.item = null;
    }

    /** Tree with exactly one node. */
    public BinaryTree(int item) {
        this.item = item;
    }

    /** Tree with a value and two subtrees (both may be null). */
    public BinaryTree(int item, BinaryTree left, BinaryTree right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public boolean hasItem() {
        return item != null;
    }

    public int getItem() {
        if (item == null) {
            throw new IllegalStateException("The tree is empty.");
        }
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public boolean hasLeft() {
        return left != null && left.hasItem();
    }

    public boolean hasRight() {
        return right != null && right.hasItem();
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
