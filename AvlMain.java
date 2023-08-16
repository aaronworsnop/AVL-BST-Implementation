public class AvlMain {
  public static void main(String[] args) {
    AvlNode root = new AvlNode(10);
    AvlTree tree = new AvlTree(root);

    AvlNode nodeVal5 = new AvlNode(5);
    AvlNode nodeVal15 = new AvlNode(15);

    tree.add(nodeVal5);
    tree.add(nodeVal15);

    System.out.println("Height of root (should be 1): " + root.getHeight());

    AvlNode nodeVal17 = new AvlNode(17);
    tree.add(nodeVal17);
    TreePrinter.printTree(tree.getRoot());

    // Before rotation balancing in add method (shouldn't rotate because tree is balanced)
    //  10
    //  /\
    // 5  15
    //     \
    //     17
    System.out.println("Height of root (should be 2): " + root.getHeight());
    System.out.println("Height of node 15 (should be 1): " + root.getRight().getHeight());

    AvlNode nodeVal16 = new AvlNode(16);
    tree.add(nodeVal16);

    // Before rotation balancing in add method
    //  10
    //  /\
    // 5  15
    //     \
    //      17
    //       \
    //       16

    // After rotation balancing in add method
    //   15
    //   /\
    //  10 17
    //  /  /
    // 5  16

    System.out.println("Height of root (should be 2): " + root.getHeight());
    TreePrinter.printTree(tree.getRoot());
  }
}
