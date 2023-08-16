public class AvlTree {
  private AvlNode root;

  public AvlTree() {}

  public AvlTree(AvlNode root) {
    this.root = root;
  }

  public void add(AvlNode node) {
    if (root == null) {
      root = node;
    } else {
      root.add(node);
      balance(root);
    }
  }

  public void remove(AvlNode node) {
    if (root == null) {
      return;
    } else {
      root.remove(node);
    }
  }

  public AvlNode getRoot() {
    return root;
  }

  // Balance the tree with rotates
  public void balance(AvlNode node) {
    if (node == null) {
      return;
    }

    int balance = node.getBalance();
    if (balance > 1) {
      // rotate with null check
      if (node != null && node.getLeft().getBalance() < 0) {
        node.getLeft().rotateLeft();
      }
      node.rotateRight();
    } else if (balance < -1) {
      if (node != null && node.getRight().getBalance() > 0) {
        node.getRight().rotateRight();
      }
      node.rotateLeft();
    }
  }
}
