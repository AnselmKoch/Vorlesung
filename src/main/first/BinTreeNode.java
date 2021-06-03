package src.main.first;

public class BinTreeNode implements Cloneable{
    private String name;
    private BinTreeNode leftChild;
    private BinTreeNode rightChild;

    public BinTreeNode(String name) {
                this.name = name;
    }

    public BinTreeNode(String name, BinTreeNode left, BinTreeNode right) {
        this.name = name;
        this.leftChild = left;
        this.rightChild = right;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ("(" + (leftChild != null? leftChild : "") +
                " " + name + " " +
                (rightChild != null ? rightChild : "") + ")");
    }

    public Object clone() {
        BinTreeNode newNode = new BinTreeNode(name);
        if(leftChild != null) {
            newNode.leftChild = (BinTreeNode) leftChild.clone();
        }
        if(rightChild != null) {
            newNode.rightChild = (BinTreeNode) rightChild.clone();
        }
        return newNode;
    }
}
