package Arboles;

public class TreeNode<T> {

    private int info;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.info = value;
        this.left = null;
        this.right = null;
    }

    public void setInfo(int value) {
        this.info = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getInfo() {
        return info;
    }


}
