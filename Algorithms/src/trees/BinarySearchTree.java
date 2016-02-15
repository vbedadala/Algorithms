package trees;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class BinarySearchTree {

    private static Node root = null;

    public static class Node implements Serializable {
	private Integer value;
	private Node left;
	private Node right;
	private Node rightSibling;
	private Node parent;

	public Node(Integer value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return value + " ";
	}

	public Boolean isLeftChild() {
	    if (this.parent.left == this) {
		return true;
	    } else
		return false;
	}

    }

    public void insert(Integer value) {
	if (root == null) {
	    root = new Node(value);
	} else {
	    insert(value, root);
	}
    }

    private boolean insert(Integer value, Node node) {

	if (value <= node.value) {
	    if (node.left == null) {
		node.left = new Node(value);
		node.left.parent = node;
		return true;
	    }
	    insert(value, node.left);
	}
	if (value > node.value) {
	    if (node.right == null) {
		node.right = new Node(value);
		node.right.parent = node;
		return true;
	    }
	    insert(value, node.right);
	}

	return false;
    }

    public void delete(Integer value) {
	Node nodeToBeDeleted = find(value, root);
	if (nodeToBeDeleted == null) {
	    System.out.println("Node to be deleted is not found");
	    return;
	}

	if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
	    // trash the node without a thought. Very simple
	    if (nodeToBeDeleted.isLeftChild())
		nodeToBeDeleted.parent.left = null;
	    else
		nodeToBeDeleted.parent.right = null;
	    nodeToBeDeleted = null;
	    return;
	}

	if (nodeToBeDeleted.right == null && nodeToBeDeleted.left != null) {

	    if (nodeToBeDeleted.isLeftChild())
		nodeToBeDeleted.parent.left = nodeToBeDeleted.left;
	    else
		nodeToBeDeleted.parent.right = nodeToBeDeleted.left;
	    nodeToBeDeleted = null;
	    return;
	}

	if (nodeToBeDeleted.left == null && nodeToBeDeleted.right != null) {
	    if (nodeToBeDeleted.isLeftChild())
		nodeToBeDeleted.parent.left = nodeToBeDeleted.right;
	    else
		nodeToBeDeleted.parent.right = nodeToBeDeleted.right;
	    nodeToBeDeleted = null;
	    return;

	}

	// Final case. where there are Left and right children( may beSubtrees)
	// We can either replace our node to be deleted with previous node or
	// next node.

	if (nodeToBeDeleted.right != null && nodeToBeDeleted.left != null) {
	    Node successor = successor(nodeToBeDeleted);
	    int temp = 0;

	    temp = nodeToBeDeleted.value;
	    nodeToBeDeleted.value = successor.value;
	    successor.value = temp;

	    if (successor.isLeftChild()) {
		successor.parent.left = null;
	    } else {
		successor.parent.right = null;
		successor = null;
	    }
	}

    }

    private Node successor(Node node) {
	if (node.right != null) {
	    return minOfSubtree(node);
	} else {
	    Node tempNode = node.parent;
	    while (tempNode.value < node.value) {
		tempNode = tempNode.parent;
	    }
	    return tempNode;
	}
    }

    private Node minOfSubtree(Node node) {
	while (node!=null && node.left != null) {
	    node = node.left;
	}
	return node;
    }
    
    private Node maxOfSubtree(Node node) {
    	while (node!=null && node.right != null) {
    	    node = node.right;
    	}
    	return node;
        }

    private Node find(Integer value, Node node) {

	// Base cases!
	if (node == null) {
	    return null;
	}
	if (node.value == value) {
	    return node;
	}

	if (value <= node.value) {
	    return find(value, node.left);
	} else {
	    return find(value, node.right);
	}

    }

    public void inOrder() {
	System.out.println("InOrder");

	inOrder(root);
    }

    public void preOrder() {

	System.out.println("PreOrder");

	preOrder(root);
    }

    public void postOrder() {
	System.out.println("PostOrder");
	postOrder(root);
    }

    public void levelOrder() {
	System.out.println("LevelOrder");
	levelOrder(root);
    }

    // prints the inorder traversal of the tree
    public void inOrder(Node node) {
	// Base case
	if (node == null) {
	    return;
	}

	inOrder(node.left);
	System.out.print(node.value + " ");

	inOrder(node.right);

    }

    // prints the preorder traversal of the tree
    public void preOrder(Node node) {
	// Base case
	if (node == null) {
	    return;
	}
	System.out.print(node.value + "    ");

	preOrder(node.left);
	preOrder(node.right);
    }

    // prints the postorder traversal of the tree
    public void postOrder(Node node) {
	// Base case
	if (node == null) {
	    return;
	}
	postOrder(node.left);
	postOrder(node.right);
	System.out.print(node.value + "    ");

    }

    public void levelOrder(Node node) {
	java.util.Queue<Node> queue = new LinkedList<Node>();
	queue.add(node);
	while (!queue.isEmpty()) {
	    node = queue.remove();
	    System.out.print(node.value + " ");

	    if (node.left != null) {
		queue.add(node.left);
	    }
	    if (node.right != null) {
		queue.add(node.right);
	    }
	}

    }

    public void reverseLevelOrder() {
	java.util.Queue<Node> queue = new LinkedList<Node>();
	java.util.Stack<Node> stack = new java.util.Stack<BinarySearchTree.Node>();
	Node node = root;
	Node dummy = new Node(-1);
	queue.add(node);
	int currLevelCount = 1;
	int nextLevelCount = 0;
	while (!queue.isEmpty()) {
	    node = queue.remove();
	    currLevelCount--;
	   
	    // System.out.print(node.value + " ");
	    stack.push(node);
	    if (node.right != null) {
		queue.add(node.right);
		nextLevelCount++;
	    }
	    if (node.left != null) {
		queue.add(node.left);
		nextLevelCount++;
	    }

	    if (currLevelCount == 0) {
		currLevelCount = nextLevelCount;
		nextLevelCount = 0;
		stack.push(dummy);

	    }

	 
	}
	   while (!stack.isEmpty()) {
			if (stack.peek() != dummy) {
			    System.out.print(stack.pop() + " ");
			} else {
			    stack.pop();
			    System.out.println();
			}
		    }

    }

    public void printLevelByLevel() {

	List<Node> levelList = new LinkedList<Node>();
	levelList.add(root);
	boolean firstElement = true;

	while (!levelList.isEmpty()) {
	    List<Node> nextLevelList = new LinkedList<BinarySearchTree.Node>();
	    for (Node n : levelList) {
		StringBuilder nodeDisplay = new StringBuilder();
		if (n.left != null) {
		    nextLevelList.add(n.left);
		}

		if (n == root)
		    System.out.print(+n.value + " ");

		else if (n.isLeftChild())
		    System.out.print("L: " + n.value + " ");
		else
		    System.out.print("R: " + n.value + " ");

		if (n.right != null) {
		    nextLevelList.add(n.right);
		    // System.out.print("  ");

		}
	    }
	    levelList.clear();
	    levelList.addAll(nextLevelList);
	    System.out.println();
	}

    }

    public static String repeat(String str, int times) {
	StringBuilder ret = new StringBuilder();
	for (int i = 0; i < times; i++)
	    ret.append(str);
	return ret.toString();
    }

    /*
     * Idea : Use stack, pop & print. Push the right child first and then left
     * child in order for left to processed first! Psuedo code -> Push root for
     * stack while : pop the top element ( Print value) push right child as
     * right needs to be processed second push left child as left needs to be
     * processed first end while
     */
    public void preOrderIterative() {
	java.util.Stack<Node> stack = new java.util.Stack<Node>();

	stack.push(root);

	while (!stack.isEmpty()) {
	    Node currNode = stack.pop();
	    System.out.print(currNode.value + " ");
	    if (currNode.right != null) {
		stack.push(currNode.right);
	    }

	    if (currNode.left != null) {
		stack.push(currNode.left);
	    }

	}

    }

    /*
     * Idea: Use stack, push root first. Push left childs. When pop the left
     * child, push right to be processed
     * 
     * Psuedo code : push root to stack currNode <-null while stack Not empty
     * and CurrNode not null( initially stack is empty so we need to have Curr
     * node check) -- The if condition ensures that left childs are kept first
     * in processing (i.e pushed to stack first) if currNode not null retrieve
     * left child and point currNode to left child // else will be called when
     * currNode becomes null, i.e left most child is on the stack now we have to
     * proces right child else Now we should take care of right child.
     * Initialize currNode to rightChild and then continue loop!
     * 
     * @@@Important@@@ Note that currNode <- currNode.right will not check for
     * NULL as it makes sure that first if loop skips for our left nodes on
     * stack which does not have right child. end While
     */

    public void inOrderIterative() {

	java.util.Stack<Node> stack = new java.util.Stack<Node>();
	Node currNode = root;

	while (!stack.isEmpty() || currNode != null) {
	    if (currNode != null) {
		stack.push(currNode);
		currNode = currNode.left;
	    }

	    // left most node. Time to print and then process right.
	    else {
		currNode = stack.pop();
		System.out.print(currNode.value + " ");
		currNode = currNode.right;
	    }
	}

    }

    /*
     * Idea : Use two stacks. Post order is reverse of reverse PreOrder -:).
     * PostOrder LRN - PreOrder - NLR - reverse -NRL - REVERSE - LRN (post
     * order) Use stack to do Iterative pre order ( reverse right and left -
     * push right first, push left next)
     */
    public void postOrderIterative() {

	java.util.Stack<Node> preOrderStack = new java.util.Stack<Node>();
	java.util.Stack<Node> postOrderStack = new java.util.Stack<Node>();
	preOrderStack.push(root);
	while (!preOrderStack.isEmpty()) {
	    Node currNode = preOrderStack.pop();
	    postOrderStack.push(currNode);
	    if (currNode.left != null) {
		preOrderStack.push(currNode.left);

	    }
	    if (currNode.right != null) {
		preOrderStack.push(currNode.right);
	    }

	}

	while (!postOrderStack.isEmpty()) {
	    System.out.print(postOrderStack.pop() + " ");
	}

    }

    /**
     * Idea : Think about Post order traversal. You would only print the value
     * after its children(subtrees) are printed SO WE WILL ONLY PRINT WHILE
     * TRAVERSING BACK! we can have 3 traversals
     * 
     * Case 1 . Going down Case 2. Going Up from Left child Case 3 . Going Up
     * from right child
     * 
     * Since we don't have parent pointers, we need to keep tracking using
     * previous traversed node
     * 
     * if previous traversed node left child or right child equals current node.
     * Then it is parent. (Case 1.)
     * 
     * Push the left child first if available and break.
     * 
     * Push the right child if available and break
     * 
     * if both are not available. Print the data. (leaf nodes)
     * 
     * 
     * if the current node left child is equal previous node. then it is left
     * child going UP (Case 2)
     * 
     * Push the right child if available. As in post order traversal we need to
     * look at curr node's right child first.
     * 
     * if right child is not available, then POP - print the CURRNODE's data.
     * 
     * 
     * If the current node right child is equal previous node. Then it is right
     * child going up (Case 3)
     * 
     * If it is right child, we have taken care of it.then POP- Print the
     * currnode data
     * 
     */

    public void postOrderIterativeUsingPrevNode() {

	java.util.Stack<Node> stack = new java.util.Stack<Node>();

	Node currNode = root;
	Node prevNode = null;
	stack.push(root);
	while (!stack.isEmpty()) {
	    currNode = stack.peek();

	    if (prevNode == null || prevNode.left == currNode
		    || prevNode.right == currNode) {
		if (currNode.left != null) {
		    stack.push(currNode.left);
		} else if (currNode.right != null) {
		    stack.push(currNode.right);
		} else {
		    System.out.print(stack.pop() + " ");
		}

	    } else if (prevNode == currNode.left) {
		if (currNode.right != null) {
		    stack.push(currNode.right);
		} else {
		    System.out.print(stack.pop() + " ");

		}
	    }

	    else if (prevNode == currNode.right) {
		System.out.print(stack.pop() + " ");
	    }

	    prevNode = currNode;

	}
    }

    public int count(Node node) {
	if (node == null) {
	    return 0;
	}
	if (node.left == null && node.right == null) {
	    return 1;
	} else {
	    return 1 + count(node.left) + count(node.right);
	}

    }

    public Integer min() {
	return null;
    }

    public Integer max() {
	return null;
    }

    public Integer findSmallestValueGreaterThanKey(Integer key) {
	return null;
    }

    public Integer findLargestValueSmallerThanKey(Integer key) {
	return null;
    }

    public int leastCommonAncestor(int value1, int value2) {

	Node currNode = root;

	while (currNode != null) {

	    if (currNode.value > value1 & currNode.value > value2) {
		currNode = currNode.left;
	    } else if (currNode.value < value1 & currNode.value < value2) {
		currNode = currNode.right;
	    } else {
		return currNode.value;
	    }
	}

	return -1;
    }

    // construct a Binary tree using inOrder and preOrder

    public Node constructBinaryTreeUsingInOrderAndPreOrder(int[] inOrder,
	    int[] preOrder) {
	if (inOrder == null || preOrder == null || inOrder.length == 0
		|| inOrder.length == 0) {
	    return null;
	}
	if (inOrder.length == 1 || preOrder.length == 1) {
	    return new Node(preOrder[0]);
	}

	Node root = new Node(preOrder[0]);

	// Find root's index in inOrder

	int divideIndex = findKey(inOrder, root.value);

	root.left = constructBinaryTreeUsingInOrderAndPreOrder(
		Arrays.copyOfRange(inOrder, 0, divideIndex),
		Arrays.copyOfRange(preOrder, 1, divideIndex + 1));

	root.right = constructBinaryTreeUsingInOrderAndPreOrder(
		Arrays.copyOfRange(inOrder, divideIndex + 1, inOrder.length),
		Arrays.copyOfRange(preOrder, divideIndex + 1, preOrder.length));

	return root;

    }

    // construct a Binary tree using inOrder and preOrder

    public Node constructBinaryTreeUsingInOrderAndPostOrder(int[] inOrder,
	    int[] postOrder) {
	if (inOrder == null || postOrder == null || inOrder.length == 0
		|| inOrder.length == 0) {
	    return null;
	}
	if (inOrder.length == 1 || postOrder.length == 1) {
	    return new Node(postOrder[0]);
	}

	Node root = new Node(postOrder[postOrder.length - 1]);

	// Find root's index in inOrder

	int divideIndex = findKey(inOrder, root.value);

	root.left = constructBinaryTreeUsingInOrderAndPreOrder(
		Arrays.copyOfRange(inOrder, 0, divideIndex),
		Arrays.copyOfRange(postOrder, 0, divideIndex + 1));

	root.right = constructBinaryTreeUsingInOrderAndPreOrder(
		Arrays.copyOfRange(inOrder, divideIndex + 1, inOrder.length),
		Arrays.copyOfRange(postOrder, divideIndex, postOrder.length - 1));

	return root;

    }

    private int findKey(int[] inOrder, int rootValue) {

	for (int i = 0; i < inOrder.length; i++) {
	    if (inOrder[i] == rootValue) {
		return i;
	    }
	}
	return -1;

    }

    // Given two binary trees T1 and T2 which store character data, write an
    // algorithm to decide whether T2 is a subtree of T1.
    // T1 has millions of nodes and T2 has hundreds of nodes, and each may have
    // duplicates.

    // Given a value in a binary QuickSelect tree, print all the paths (starting from
    // the root or any other node) which sum up to that value.

    // Given a binary tree.
    // Print nodes of extreme corners of each level but in alternate order.
    // For a given BST, connect each of its right child to its inorder
    // successor.

    // Find kth smallest in BST

    // For a given binary tree, largest binary QuickSelect sub-tree should be found.

    // public Node getLeftSibling(Node node) {
    //
    // // if(node.)
    // //
    // //
    // // return null;
    //
    // }

    public int lca(int node1, int node2, Node node) {

	if (node == null) {
	    return 0;
	}

	if (countMatches(node.left, node1) + countMatches(node.left, node2) == 2) {

	    lca(node1, node2, node.left);

	} else if (countMatches(node.left, node1)
		+ countMatches(node.left, node2) == 1) {

	    // node is the LCA.
	    return node.value;
	}

	else if (countMatches(node.left, node1)
		+ countMatches(node.left, node2) == 0) {

	    lca(node1, node2, node.right);
	}

	return -1;

    }

    public int countMatches(Node node, int key) {

	if (node == null) {
	    return 0;
	}

	if (node.value == key) {
	    return 1 + countMatches(node.left, key)
		    + countMatches(node.right, key);

	} else {
	    return countMatches(node.left, key) + countMatches(node.right, key);
	}

    }

    public void BSTToCircularDoubleLinkedList(Node node, Node prev, Node head) {

	if (node == null) {
	    return;
	}
	// Do Inorder
	BSTToCircularDoubleLinkedList(node.left, prev, head);

	node.left = prev;

	// Do the right node mapping using Prev Node.
	if (prev != null) {
	    prev.right = node;
	}
	{
	    // smallest node to head. Initialize head pointer.
	    head = node;
	}

	// Always point the right of curr node to head. At the end of recursion
	// this will point back to head(i.e first node)
	node.right = head;

	// This makes sure at the end of recursion first node.left
	head.left = node;

	prev = node;

	BSTToCircularDoubleLinkedList(node.right, prev, head);

    }

    public void connectRightSibling(Node node) {
	if (node == null) {
	    return;
	}
	Node currNode = node;
	while (currNode != null) {
	    currNode.left.rightSibling = currNode.right;

	    currNode.right.rightSibling = currNode.rightSibling.left;

	    currNode = currNode.rightSibling;

	}

	connectRightSibling(node.left);

    }

    // link all the nodes at each level

    public void linkNodesAtEachLevel(Node node) {

	List<LinkedList<Node>> nodesListByLevel = new ArrayList<LinkedList<Node>>(
		0);
	int level = 0;

	nodesListByLevel.add(new LinkedList<BinarySearchTree.Node>());
	nodesListByLevel.get(0).add(root);
	level++;
	Boolean termainteFlag = false;

	while (!termainteFlag) {

	    LinkedList<Node> levelList = new LinkedList<BinarySearchTree.Node>();

	    for (int i = 0; i < nodesListByLevel.get(level).size(); i++) {
		Node levelNode = nodesListByLevel.get(level).get(i);
		levelList.add(levelNode.left);
		levelList.add(levelNode.right);
	    }

	    if (!levelList.isEmpty()) {
		nodesListByLevel.add(levelList);
		level++;
	    } else {
		termainteFlag = true;
	    }

	}

    }

    public int depth() {

	return depth(root);
    }

    public int depth(Node node) {

	if (node == null) {
	    return 0;
	}

	return Math.max((1 + depth(node.left)), (1 + depth(node.right)));
    }
    
    public boolean hasPathSum(int sum) {
    	return hasPathSum(root, sum);
    }
    public boolean hasPathSum(Node node,int sum) {
    	//Base case.
    	if(sum<=0){
    		return true;
    	}
    	if(node == null){
    		return false;
    	}
    	return hasPathSum(node.left, sum-node.value) || hasPathSum(node.right, sum-node.value); 	
    }
    
    public void mirror(){
    	inOrder(root);
    	System.out.println();
    	mirror(root);
    }

    public Node mirror(Node node){
    	if(node==null || (node.left==null && node.right==null)){
    		return node;
    	}
    	Node temp = node.left;
    	node.left= node.right;
    	node.right = temp;
    	if(node.left!=null){
    	mirror(node.left);
    	}
    	if(node.right!=null){
    	mirror(node.right);
    	}
    	return node;
    }
    
    public boolean isMirror(){
    	
    	
    	return isMirror(root,mirror(SerializationUtils.clone(root)));
    }
    public boolean isMirror(Node n1, Node n2){
    	if(n1 ==null && n2 ==null){
    		return true;
    	}   	
    	
    return n1.value.equals(n2.value) && (isMirror(n1.left, n2.right)) && (isMirror(n1.right, n2.left));
    }
    
    public boolean isBST(){
      return	isBST(root);
    }
    
    private boolean isBST(Node n) {
    	if(n == null){
    		return true;
    	}
    	
    	if(n.left!=null && n.value < maxOfSubtree(n.left).value) {
    		return false;
    	}
    	
    	if(n.right!=null && n.value >= minOfSubtree(n.right).value) {
    		return false;
    	}
    	
    	if(!isBST(n.left) || !isBST(n.right) ){
    		return false;
    	}
    	return true;
    	}
    
    
    	
    	
   
}
