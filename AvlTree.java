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
    }
  }

  public void remove(AvlNode node) {
    if (root == null) {
      return;
    } else {
      root.remove(node);
    }
  }
}
