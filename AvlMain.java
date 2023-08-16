public class AvlMain {
  public static void main(String[] args) {
    AvlNode root = new AvlNode(10);
    AvlTree tree = new AvlTree(root);

    AvlNode nodeVal5 = new AvlNode(5);
    AvlNode nodeVal15 = new AvlNode(15);

    tree.add(nodeVal5);
    tree.add(nodeVal15);

    System.out.println(root.getHeight());

    AvlNode nodeVal17 = new AvlNode(17);
    tree.add(nodeVal17);

    //  10
    //  /\
    // 5  15
    //     \
    //     17

    System.out.println(root.getHeight());
  }
}
