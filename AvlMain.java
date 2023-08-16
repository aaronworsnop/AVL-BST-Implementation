public class AvlMain {
  public static void main(String[] args) {
    AvlNode root = new AvlNode(10);
    AvlTree tree = new AvlTree(root);

    System.out.println(tree.getRoot().getHeight());

    tree.add(15).add(5).add(17).add(16);

    System.out.println(tree.getRoot().getHeight());
    System.out.println(tree.getRoot().getData());
    System.out.println(tree.getRoot().getLeft().getData());
    System.out.println(tree.getRoot().getLeft().getLeft().getData());
    // System.out.println(tree.getRoot().getLeft().getRight().getData()); -> null
    System.out.println(tree.getRoot().getRight().getData());
    System.out.println(tree.getRoot().getRight().getLeft().getData());
    System.out.println(tree.getRoot().getRight().getRight().getData());
  }
}
