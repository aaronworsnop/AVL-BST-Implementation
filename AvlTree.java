public class AvlTree {
  private AvlNode root;

  public AvlTree() {}

  public AvlTree(AvlNode root) {
    this.root = root;
  }

  public AvlNode getRoot() {
    return root;
  }

  public AvlTree add(int data) {
    root = add(data, root);
    return this;
  }

  private AvlNode add(int data, AvlNode node) {
    if (node == null) {
      return new AvlNode(data);
    }
    if (data < node.getData()) {
      node.setLeft(add(data, node.getLeft()));
    } else if (data > node.getData()) {
      node.setRight(add(data, node.getRight()));
    } else {
      return node;
    }
    updateHeight(node);
    return rotate(node);
  }
}
