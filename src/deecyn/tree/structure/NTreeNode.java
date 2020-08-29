package deecyn.tree.structure;

import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
