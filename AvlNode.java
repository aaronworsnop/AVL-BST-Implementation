public class AvlNode {
  private int key;
  private int height;
  private AvlNode left;
  public AvlNode right;
  private AvlNode parent;

  public AvlNode(int key) {
    this.key = key;
    this.height = 0;
    this.left = null;
    this.right = null;
  }

  public void add(AvlNode node) {
    if (node.key < this.key) {
      if (this.left == null) {
        this.left = node;
      } else {
        this.left.add(node);
      }
    } else {
      if (this.right == null) {
        this.right = node;
      } else {
        this.right.add(node);
      }
    }
    this.updateHeight();
    node.parent = this;
  }

  private void updateHeight() {
    this.height = Math.max(getNodeHeight(this.left), getNodeHeight(this.right)) + 1;
  }

  private int getNodeHeight(AvlNode node) {
    return node == null ? -1 : node.height;
  }

  public void remove(AvlNode node) {
    this.height--;
    if (node.key < this.key) {
      if (this.left == node) {
        this.left = null;
      } else {
        this.left.remove(node);
      }
    } else {
      if (this.right == node) {
        this.right = null;
      } else {
        this.right.remove(node);
      }
    }
  }

  // Rotate methods
  public void rotateLeft() {
    AvlNode left = this.left;

    this.left = left.right;
    left.right = this;

    this.updateHeight();
    left.updateHeight();
  }

  public void rotateRight() {
    AvlNode right = this.right;

    this.right = right.left;
    right.left = this;

    this.updateHeight();
    right.updateHeight();
  }

  public void rotateLeftToRight() {
    this.left.rotateLeft();
    this.rotateRight();
  }

  public void rotateRightToLeft() {
    this.right.rotateRight();
    this.rotateLeft();
  }

  // Public getters
  public AvlNode getLeft() {
    return this.left;
  }

  public AvlNode getRight() {
    return this.right;
  }

  public AvlNode getParent() {
    return this.parent;
  }

  public int getKey() {
    return this.key;
  }

  public int getHeight() {
    return this.height;
  }

  public int getBalance() {
    return getNodeHeight(this.right) - getNodeHeight(this.left);
  }
}
