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

  public int max() {
    return max(root);
  }

  public int min() {
    return min(root);
  }

  public boolean contains(int data) {
    return contains(data, root);
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
    updateHeight(node);
    return rotate(node);
  }

  private int max(AvlNode node) {
    if (node.getRight() == null) {
      return node.getData();
    }
    return max(node.getRight());
  }

  private int min(AvlNode node) {
    if (node.getLeft() == null) {
      return node.getData();
    }
    return min(node.getLeft());
  }

  private boolean contains(int data, AvlNode node) {
    if (node == null) {
      return false;
    }
    if (data < node.getData()) {
      return contains(data, node.getLeft());
    } else if (data > node.getData()) {
      return contains(data, node.getRight());
    } else {
      return true;
    }
  }

  private AvlNode rotate(AvlNode node) {
    if (balance(node) > 1) {
      // Left side longer
      if (balance(node.getLeft()) < 0) {
        // Left right case
        node.setLeft(rotateLeft(node.getLeft()));
      }
      return rotateRight(node);
    }
    if (balance(node) < -1) {
      // Right side longer
      if (balance(node.getRight()) > 0) {
        // Right left case
        node.setRight(rotateRight(node.getRight()));
      }
      return rotateLeft(node);
    }
    return node;
  }

  private AvlNode rotateLeft(AvlNode node) {
    AvlNode right = node.getRight();
    AvlNode middle = node.getRight().getLeft();
    right.setLeft(node);
    node.setRight(middle);
    updateHeight(node);
    updateHeight(right);
    return right;
  }

  private AvlNode rotateRight(AvlNode node) {
    AvlNode left = node.getLeft();
    AvlNode middle = node.getLeft().getRight();
    left.setRight(node);
    node.setLeft(middle);
    updateHeight(node);
    updateHeight(left);
    return left;
  }

  private int balance(AvlNode node) {
    return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
  }

  private void updateHeight(AvlNode node) {
    node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
  }

  private int height(AvlNode node) {
    return node != null ? node.getHeight() : 0;
  }
}
