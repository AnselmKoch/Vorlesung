package src.main.first;

public class DefaultTreeNode implements SimpleTreeNode, Cloneable{

    private int size;
    private String name;
    private SimpleTreeNode[] children;
    private int childAmount;

    public DefaultTreeNode (String name){
        size = 1;
        this.name = name;
        children = new SimpleTreeNode[size];
        childAmount = 0;
    }

    public void addChild(SimpleTreeNode child) {
        if (childAmount >= size) {
            size *= 2;
            SimpleTreeNode[] newchilds = new SimpleTreeNode[size];
            for (int i = 0; i < childAmount; i++) newchilds[i] = children[i];
            children = newchilds;
        }
        children[childAmount++] = child;
    }

    public int getChildAmount() {
        return childAmount;
    }

    public SimpleTreeNode getChild(int pos) {
        return children[pos];
    }

    public SimpleTreeNode clone(){
        DefaultTreeNode newNode = new DefaultTreeNode(name);
        newNode.children = children.clone();
        for (int i = 0; i < childAmount; i++){
            newNode.addChild((SimpleTreeNode)children[i].clone());
        }
        return newNode;
    }
}
