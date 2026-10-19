/**
 * Small demo: builds a binary search tree and runs every algorithm.
 *
 * Run with:
 *   javac *.java
 *   java Main
 */
public class Main {

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        BinaryTree tree = null;
        for (int value : values) {
            tree = BinaryTreeAlgorithms.insert(tree, value);
        }

        System.out.println("Inserted: 50 30 70 20 40 60 80");
        System.out.println();
        System.out.println("        50");
        System.out.println("      /    \\");
        System.out.println("    30      70");
        System.out.println("   /  \\    /  \\");
        System.out.println("  20  40  60  80");
        System.out.println();
        System.out.println("Preorder: " + BinaryTreeAlgorithms.preorder(tree));
        System.out.println("Inorder:  " + BinaryTreeAlgorithms.inorder(tree) + "   (sorted!)");
        System.out.println("Postorder:" + BinaryTreeAlgorithms.postorder(tree));
        System.out.println();
        System.out.println("Height:         " + BinaryTreeAlgorithms.height(tree));
        System.out.println("Full:           " + BinaryTreeAlgorithms.isFull(tree));
        System.out.println("Perfect:        " + BinaryTreeAlgorithms.isPerfect(tree));
        System.out.println("Search 60:      " + BinaryTreeAlgorithms.search(tree, 60));
        System.out.println("Search 65:      " + BinaryTreeAlgorithms.search(tree, 65));

        BinaryTreeAlgorithms.insert(tree, 65);
        System.out.println();
        System.out.println("After inserting 65:");
        System.out.println("Height:         " + BinaryTreeAlgorithms.height(tree));
        System.out.println("Full:           " + BinaryTreeAlgorithms.isFull(tree));
        System.out.println("Perfect:        " + BinaryTreeAlgorithms.isPerfect(tree));
    }
}
