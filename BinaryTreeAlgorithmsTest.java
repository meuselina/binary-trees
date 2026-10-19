/**
 * Automated tests for every method in BinaryTreeAlgorithms.
 * No external library needed: just compile and run.
 *
 *   javac *.java
 *   java BinaryTreeAlgorithmsTest
 */
public class BinaryTreeAlgorithmsTest {

    private static int passed = 0;
    private static int failed = 0;

    private static void check(String name, Object expected, Object actual) {
        if (expected.equals(actual)) {
            passed++;
        } else {
            failed++;
            System.out.println("FAILED " + name + ": expected <" + expected + ">, got <" + actual + ">");
        }
    }

    private static BinaryTree build(int... values) {
        BinaryTree tree = null;
        for (int value : values) {
            tree = BinaryTreeAlgorithms.insert(tree, value);
        }
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree perfect = build(50, 30, 70, 20, 40, 60, 80);

        check("preorder", " 50 30 20 40 70 60 80", BinaryTreeAlgorithms.preorder(perfect));
        check("inorder", " 20 30 40 50 60 70 80", BinaryTreeAlgorithms.inorder(perfect));
        check("postorder", " 20 40 30 60 80 70 50", BinaryTreeAlgorithms.postorder(perfect));
        check("height of perfect tree", 2, BinaryTreeAlgorithms.height(perfect));
        check("perfect tree is full", true, BinaryTreeAlgorithms.isFull(perfect));
        check("perfect tree is perfect", true, BinaryTreeAlgorithms.isPerfect(perfect));
        check("search existing value", true, BinaryTreeAlgorithms.search(perfect, 60));
        check("search missing value", false, BinaryTreeAlgorithms.search(perfect, 65));

        // Empty tree
        check("height of empty tree", -1, BinaryTreeAlgorithms.height(new BinaryTree()));
        check("height of null", -1, BinaryTreeAlgorithms.height(null));
        check("preorder of empty tree", "", BinaryTreeAlgorithms.preorder(null));
        check("search in empty tree", false, BinaryTreeAlgorithms.search(null, 1));

        // Single node
        BinaryTree single = new BinaryTree(7);
        check("height of single node", 0, BinaryTreeAlgorithms.height(single));
        check("single node is perfect", true, BinaryTreeAlgorithms.isPerfect(single));

        // Node with only one child: neither full nor perfect
        BinaryTree lopsided = build(10, 5);
        check("lopsided tree is full", false, BinaryTreeAlgorithms.isFull(lopsided));
        check("lopsided tree is perfect", false, BinaryTreeAlgorithms.isPerfect(lopsided));

        // Full but not perfect (leaves on different levels)
        BinaryTree fullNotPerfect = build(50, 30, 70, 60, 80);
        check("full but not perfect: full", true, BinaryTreeAlgorithms.isFull(fullNotPerfect));
        check("full but not perfect: perfect", false, BinaryTreeAlgorithms.isPerfect(fullNotPerfect));

        // Duplicate values are not inserted again
        BinaryTree duplicates = build(5, 3, 5, 3);
        check("no duplicates", " 3 5", BinaryTreeAlgorithms.inorder(duplicates));

        System.out.println(passed + " tests passed, " + failed + " failed.");
        if (failed > 0) {
            System.exit(1);
        }
    }
}
