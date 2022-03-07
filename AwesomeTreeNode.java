import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class AwesomeTreeNode {

    // This variable is checked before printing debug statements.
    //
    //   TRUE => Print debug statements
    //   FALSE => Do not print debug statements
    private static Boolean debug = false;

    // The height level of the current node in the tree.
    int height;

    // String representation of the node to insert into the tree. This string is given at insertion and is
    // assumed to be unique from other nodes' names.
    String name;

    // This node's root, at level 0, for all nodes in the tree.
    AwesomeTreeNode root;

    // This node's immediate parent.
    AwesomeTreeNode parent;

    // This node's list of children.
    LinkedList<AwesomeTreeNode> children = new LinkedList<>();

    /**
     * Constructor with neither root nor parent.
     *
     * @param n The name of this node.
     */
    AwesomeTreeNode(String n) {
        height = 0;
        name = n;
        root = this;
        parent = null;
    }

    /**
     * Constructor taking as input the name of the current node, the root node of the entire tree, and this
     * node's parent node.
     *
     * @param r The root node of the entire tree.
     * @param p This node's parent.
     * @param n The name of this node.
     */
    AwesomeTreeNode(AwesomeTreeNode r, AwesomeTreeNode p, String n) {
        height = p.height + 1;
        name = n;
        root = r;
        parent = p;
    }

    /**
     * Constructor taking as input the name of the current node, and this node's parent node.
     *
     * @param p This node's parent.
     * @param n The name of this node.
     */
    AwesomeTreeNode(AwesomeTreeNode p, String n) {
        height = p.height + 1;
        name = n;
        root = p.root; // A tree's root is its root, regardless of who 'this' is, even if root.
        parent = p;
    }

    /**
     * Constructor taking as input two nodes, a parent node and that of its child.
     *
     * ASSUMPTIONS: Both nodes 'p' and 'c' have already been allocated and assigned valid values.
     *
     * @param p This node's parent.
     * @param c This parent's node.
     */
    AwesomeTreeNode(AwesomeTreeNode p, AwesomeTreeNode c) {
        height = p.height + 1;
        name = c.name;
        root = p.root;
        parent = p;
    }

    /**
     * This function turns debug statements ON.
     **/
    public static void setDebug() {
        debug = true;
    }
    
    /**
     * This function turns debug statements OFF.
     **/
    public static void clearDebug() {
        debug = false;
    }
    
    /**
     * This function checks the status of the debug flag.
     **/
    public static Boolean isDebugOn() {
        return (debug == true);
    }
    
    /**
     * This function helps determine if the current node is the root node or not.
     *
     * @return True if the current node is the root, false if not.
     */
    public boolean isRoot() {
        return (height == 0);
    }

    /**
     * This function prints out some information of a 'this' node.
     */
    public void printNode() {
        System.out.print("== ");
        for(int i = 0; i < height; i++) {System.out.print("\t");}
        System.out.println("name   : " + name);

        System.out.print("== ");
        for(int i = 0; i < height; i++) {System.out.print("\t");}
        System.out.println("height : " + height);

        System.out.print("== ");
        for(int i = 0; i < height; i++) {System.out.print("\t");}
        System.out.println("root   : " + ((root == null) ? "null" : root.name));

        System.out.print("== ");
        for(int i = 0; i < height; i++) {System.out.print("\t");}
        System.out.println("parent : " + ((parent == null) ? "null" : parent.name));
    }

    /**
     * This function provides a consistent header for printing sub-nodes in a tree.
     **/
    private void printSubNodeHeader() {
        System.out.print("== -----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
    }

    /**
     * This function provides a consistent header for printing trees.
     **/
    private void printTreeHeader() {
        System.out.print("\n=======================================================");
        System.out.println("======================================================");
    }

    /**
     * This function provides a consistent footer for printing trees.
     **/
    private void printTreeFooter() {
        System.out.println("==");
    }

    /**
     * This function performs a preorder print of all nodes in the tree starting from 'this'.
     **/
    public void printTree() {
        if (height == 0) {
            printTreeHeader();
        } else {
            printSubNodeHeader();
        }

        // Print this node and its progeny depth-first in the family tree.
        this.printNode();
        if (!children.isEmpty()) {
            //  Recursive case  :  Node does not meet search criteria  =>
            //      -- There's at least one child,
            //      -- Print recursively
            for (int i = 0; i < children.size(); i++) {
                children.get(i).printTree();
            }
        }

        if (height == 0) {

        }
    }

    /**
     * This function performs a level order print of all nodes in the tree starting from 'this'.
     */
    public void printTree_levelOrder() {
        // Level order traversal
        Queue<AwesomeTreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                AwesomeTreeNode node = queue.poll();
                assert node != null;

                if (node.height == 0) {
                    printTreeHeader();
                } else {
                    printSubNodeHeader();
                }

                // Print this node and its progeny breadth-first in the family tree.
                node.printNode();
                for (AwesomeTreeNode item : node.children) {
                    queue.offer(item);
                }
            }
        }

        if (this.height == 0) {
            printTreeFooter();
        }
    }

    /**
     * This function returns the node within the current tree identified by a given string.
     *
     * @param nodeName The name of the node to retrieve.
     * @return The node identified by the parameter 'nodeName'.
     */
    public AwesomeTreeNode get(String nodeName) {
        String funcName = "[AwesomeTreeNode.get()]:: ";
        AwesomeTreeNode retval = null;

        if (this.name.equalsIgnoreCase(nodeName)) {
            // Base case: Node found => return this node
            if (isDebugOn()) {
                System.out.println(funcName + "BASE CASE[FOUND]: " + this.name);
            }
            retval = this;
        } else if (!this.children.isEmpty()) {
            //  Recursive case  :  Node does not meet search criteria  =>
            //      -- There's at least one child at this point,
            //      -- Search children recursively
            if (isDebugOn()) {
                System.out.println(funcName + "RECURSIVE CASE[Entry]: Search children for " +
                                   nodeName + " under " + this.name);
            }

            int i = 0;
            int ub = this.children.size();
            while ((retval == null) && (i < ub)) {
                retval = this.children.get(i).get(nodeName);
                if (isDebugOn()) {
                    System.out.print(funcName + "   retval[" + i + "]: " + this.children.get(i).name + " -> ");
                    if (retval == null) {
                        System.out.println("NOT FOUND");
                    } else {
                        System.out.println("FOUND");
                    }
                }

                if ((retval != null) && (retval.name.equalsIgnoreCase(nodeName))) {
                    i = ub;
                }
                else {
                    i++;
                }
            }
        }

        if (isDebugOn()) {
            System.out.println(funcName + "RETURN: retval " + ((retval == null) ? "null" : retval.name));
        }

        return retval;
    }

    /**
     * This function plucks the node within the current tree identified by a given string, assigns its children
     * to its parent, and returns the node plucked.
     *
     * @param nodeName The name of the node to retrieve.
     * @return The node identified by the parameter 'nodeName', sans children.
     */
    public AwesomeTreeNode pluck(String nodeName) {
        String funcName = "[AwesomeTreeNode.pluck()]:: ";
        AwesomeTreeNode retval = null;

        if (this.name.equalsIgnoreCase(nodeName)) {
            // Base case: Node found => add new node to list of children and return
            if (isDebugOn()) {
                System.out.println(funcName + "BASE CASE[FOUND]: " + this.name);
                System.out.println(funcName + "   Number of Children: " + this.children.size());
            }

            // Append this.children to parent.children
            IntStream.range(0, this.children.size()).forEachOrdered(i -> {
                    AwesomeTreeNode child = new AwesomeTreeNode(this.root,
                                                                this.parent,
                                                                this.children.getFirst().name);

                    if (isDebugOn()) {
                        System.out.println(funcName + "      [" + i + "]: " + child.name);
                    }

                    this.parent.children.add(child);
                    this.children.removeFirst();
                }
            );

            retval = this;
        } else if (!this.children.isEmpty()) {
            //  Recursive case  :  Node does not meet search criteria  =>
            //      -- There's at least one child at this point,
            //      -- Search children recursively
            if (isDebugOn()) {
                System.out.println(funcName + "RECURSIVE CASE[Entry]: Search children for " +
                                   nodeName + " under " + this.name);
            }

            int i = 0;
            int ub = this.children.size();
            while ((retval == null) && (i < ub)) {
                retval = this.children.get(i).pluck(nodeName);
                if (isDebugOn()) {
                    System.out.print(funcName + "   retval[" + i + "]: " + this.children.get(i).name + " -> ");
                    if (retval == null) {
                        System.out.println("NOT FOUND");
                    } else {
                        System.out.println("FOUND");
                    }
                }

                if ((retval != null) && (this.name.equalsIgnoreCase(retval.parent.name))) {
                    this.children.remove(i);
                    i = ub;
                }
                else {
                    i++;
                }
            }
        }

        if (isDebugOn()) {
            System.out.println(funcName + "RETURN: retval " + ((retval == null) ? "null" : retval.name));
        }

        return retval;
    }

    /**
     * Insert a node into the tree. It is assumed that the 'this' pointer represents any given node in the tree,
     * root or not, and that it is the intended parent of the child to insert. 
     *
     * @param childName Input parameter identifying the intended name of the child node to insert. The child is
     *        assumed not to exist in the tree.
     */
    public void insert(String childName) {
        AwesomeTreeNode child = new AwesomeTreeNode(this, childName);
        this.children.add(child);
    }

    /**
     * Insert a node into the tree. It is assumed that the 'this' pointer represents any given node in the tree,
     * root or not, and that it is the intended parent of the child to insert. 
     *
     * @param c Input parameter identifying the intended child node to insert. The child is assumed not to
     *        exist in the tree.
     */
    public void insert(AwesomeTreeNode c) {
        AwesomeTreeNode n = new AwesomeTreeNode(this, c.name);
        this.children.add(n);
    }

    /**
     * This function moves a node from one parent to another parent within the tree structure starting from this
     * node.
     *
     * @param childName The name of the child node being bandied about.
     * @param from Input string denoting the name of the parent from which the child will be taken.
     * @param to   Input string denoting the name of the parent to which the child will be given.
     *
     * ASSUMPTIONS:
     *
     *    1) This node is the starting point and is not the node to move.
     *    2) The node identified by 'childName' exists in the tree structure beneath the node identified by
     *       'from'.
     *    3) Both the node identified by 'from' and the node identified by 'to' exist in the tree structure
     *       beneath this node.
     */
    public void move(String childName, String from, String to) {
        AwesomeTreeNode fromNode = get(from);
        AwesomeTreeNode toNode = get(to);
        AwesomeTreeNode childNode = fromNode.pluck(childName);

        toNode.insert(childNode);
    }

    /**
     * This function moves a node from one parent to another parent within the tree structure starting from this
     * node.
     *
     * @param childName The name of the child node being bandied about.
     * @param from      Input node from which the child will be taken.
     * @param to        Input node to which the child will be given.
     *
     * ASSUMPTIONS:
     *
     *    1) This node is the starting point and is not the node to move.
     *    2) The node identified by 'childName' exists in the tree structure beneath 'from'.
     *    3) Both the 'from' and 'to' exist in the tree structure beneath this node.
     */
    public void move(String childName, AwesomeTreeNode from, AwesomeTreeNode to) {
        move(childName, from.name, to.name);
    }
}
