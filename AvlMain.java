public class AvlMain {
  public static void main(String[] args) {
    AvlNode root = new AvlNode(10);
    AvlTree tree = new AvlTree(root);

    AvlNode nodeVal5 = new AvlNode(5);
    AvlNode nodeVal15 = new AvlNode(15);

    tree.add(nodeVal5);
    tree.add(nodeVal15);

    System.out.println("Height of root: " + root.getHeight());

    AvlNode nodeVal17 = new AvlNode(17);
    tree.add(nodeVal17);

    // Before rotation balancing in add method (shouldn't rotate because tree is balanced)
    //  10
    //  /\
    // 5  15
    //     \
    //     17
    System.out.println("Height of root: " + root.getHeight());
    System.out.println("Height of node 15: " + root.getRight().getHeight());

    AvlNode nodeVal16 = new AvlNode(16);
    tree.add(nodeVal16);

    System.out.println("Height of root: " + root.getHeight());
    System.out.println(tree.getRoot().getKey());
  }
}
