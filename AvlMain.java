public class AvlMain {
  public static void main(String[] args) {
    AvlNode root = new AvlNode(10);
    AvlTree tree = new AvlTree(root);

    System.out.println(tree.getRoot().getHeight());

    tree.add(15).add(5).add(17).add(16).add(13).add(18).add(24).add(26);

    System.out.println(tree.getRoot().getHeight());
    System.out.println("root: " + tree.getRoot().getData());
    System.out.println(tree.getRoot().getLeft().getData());
    System.out.println(tree.getRoot().getLeft().getLeft().getData());
    System.out.println(tree.getRoot().getLeft().getRight().getData());
    System.out.println(tree.getRoot().getRight().getData());
    System.out.println(tree.getRoot().getRight().getLeft().getData());
    System.out.println(tree.getRoot().getRight().getRight().getData());
    System.out.println(tree.getRoot().getRight().getRight().getRight().getData());
    System.out.println(tree.getRoot().getRight().getLeft().getLeft().getData());

    // 10

    // 10
    //  \
    //   15

    //   10
    //  /  \
    // 5   15

    //     10
    //    /  \
    //   5   15
    //         \
    //         17

    //     10
    //    /  \
    //   5   15
    //         \
    //         17  // Time to rotate
    //         /
    //        16

    //     15
    //    /  \
    //   10   17  // After rotation
    //  /    /
    // 5    16

    //     15
    //    /  \
    //   10   17
    //  /\    /\
    // 5 13  16 18  // Time to rotate
    //           \
    //           24
    //            \
    //            26

    //     15
    //    /  \
    //   10   18
    //  /\    /\   // After rotation
    // 5 13  17 24
    //       /   \
    //      16   26

    // Rajko's test idea
    AvlTree rajkoTree = new AvlTree();
    for (int i = 0; i < 1000000; i++) {
      rajkoTree.add(i);
    }
    for (int i = 0; i > -1000000; i--) {
      rajkoTree.add(i);
    }
    System.out.println(
        "Tree height after adding 2,000,000 elements: " + rajkoTree.getRoot().getHeight());
  }
}
