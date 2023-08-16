public class AvlNode {
  private int data;
  private int height;
  private AvlNode left, right;

  AvlNode(int data) {
    this.data = data;
    this.height = 0;
  }

  public int getData() {
    return data;
  }

  public int getHeight() {
    return height;
  }

  public AvlNode getLeft() {
    return left;
  }

  public AvlNode getRight() {
    return right;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setLeft(AvlNode left) {
    this.left = left;
  }

  public void setRight(AvlNode right) {
    this.right = right;
  }
}
