package src.main.first;

public interface SimpleTreeNode {
    public void addChild(SimpleTreeNode child);
    public int getChildAmount();
    public SimpleTreeNode getChild(int pos);
    public SimpleTreeNode clone();
}
