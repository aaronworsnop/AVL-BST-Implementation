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

  public void remove(int data) {
    root = remove(data, root);
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

  private AvlNode remove(int data, AvlNode node) {
    if (node == null) {
      return null;
    }
    if (data < node.getData()) {
      node.setLeft(remove(data, node.getLeft()));
    } else if (data > node.getData()) {
      node.setRight(remove(data, node.getRight()));
    } else {
      if (node.getLeft() == null) {
        return node.getRight();
      } else if (node.getRight() == null) {
        return node.getLeft();
      }
        node.setData(max(node.getLeft()));
        node.setLeft(remove(node.getData(), node.getLeft()));
      }
    }
    updateHeight(node);
    return rotate(node);
  }
}
