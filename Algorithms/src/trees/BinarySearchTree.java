package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import stack.Queue;
import stack.Stack;

public class BinarySearchTree {

    private static Node root = null;

    public static class Node {
	private Integer value;
	public Node left;
	private Node right;
	private Node rightSibling;

	public Node(Integer value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return value + " ";
	}

    }

    public void insert(Integer value) {
	if (root == null) {
	    root = new Node(value);
	} else {
	    insert(value, root);
	}
    }

    private boolean insert(Integer value, Node parent) {

	if (value < parent.value) {
	    if (parent.left == null) {
		parent.left = new Node(value);
		return true;
	    }
	    insert(value, parent.left);
	}
	if (value > parent.value) {
	    if (parent.right == null) {
		parent.right = new Node(value);
		return true;
	    }
	    insert(value, parent.right);
	}

	return false;
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
	Queue<BinarySearchTree.Node> q = new Queue<BinarySearchTree.Node>();
	q.insert(node);

	while (!q.isEmpty()) {
	    // visit Queue's top element
	    Node topNode = q.delete();
	    System.out.print(topNode.value + "    ");

	    if (topNode.left != null) {
		q.insert(topNode.left);
	    }

	    if (topNode.right != null) {
		q.insert(topNode.right);
	    }

	}
    }

    public void levelOrderUsingList() {
	List<Node> list = new LinkedList<Node>();
	list.add(root);
	while (!list.isEmpty()) {
	    int levelSize = list.size();
	    for (int i = 0; i < levelSize; i++) {
		Node n = list.remove(0);
		System.out.print(n.value + " ");
		if (n.left != null) {
		    list.add(n.left);
		}
		if (n.right != null) {
		    list.add(n.right);
		}
	    }

	    System.out.println();
	}

    }

    public void preOrderIterative() {

	Stack<BinarySearchTree.Node> stack = new Stack<BinarySearchTree.Node>(3);
	stack.push(root);
	Node currNode;
	while (!stack.isEmpty()) {
	    // print the node
	    currNode = stack.pop();
	    if (currNode.right != null) {
		stack.push(currNode.right);
	    }

	    if (currNode.left != null) {
		stack.push(currNode.left);
	    }

	}

    }

    public void inOrderIterative() {

	Stack<BinarySearchTree.Node> stack = new Stack<BinarySearchTree.Node>(
		100);

	Node currNode = root;
	// go to left most child

	while (currNode != null) {
	    stack.push(currNode);
	    currNode = currNode.left;
	}

	while (!stack.isEmpty()) {

	    // get the top element from the stack

	    currNode = stack.pop();

	    // get the right child

	    Node rightChild = currNode.right;
	    // find the left most child
	    if (rightChild != null) {
		currNode = rightChild;
		while (currNode != null) {
		    stack.push(currNode);
		    currNode = currNode.left;
		}
	    }

	    else {
		continue;
	    }

	}

    }

    // Basically do preOrder. Use second stack to return the reverse order of
    // postOrder
    public void postOrderIterative() {

	Stack<BinarySearchTree.Node> input = new Stack<BinarySearchTree.Node>(
		100);
	Stack<BinarySearchTree.Node> output = new Stack<BinarySearchTree.Node>(
		100);

	// Find the left most node
	Node currNode = root;
	input.push(currNode);

	while (!input.isEmpty()) {

	    currNode = input.popWithoutPrint();

	    output.push(currNode);

	    if (currNode.left != null) {
		input.push(currNode.left);
	    }

	    if (currNode.right != null) {
		input.push(currNode.right);
	    }

	}

	while (!output.isEmpty()) {
	    output.pop();
	}

    }

    public void postOrderIterativeUsingPrevNode() {

	Stack<Node> stack = new Stack<Node>(100);

	Node currNode = root;
	Node prevNode = null;
	stack.push(root);

	while (!stack.isEmpty()) {
	    currNode = stack.peek();
	    // Traverse down the tree

	    if (prevNode == null || prevNode.left == currNode
		    || prevNode.right == currNode) {
		if (currNode.left != null) {
		    stack.push(currNode.left);
		} else if (currNode.right != null) {
		    stack.push(currNode.right);
		} else {
		    // print the node
		    stack.pop();
		}
	    }

	    else if (currNode.left == prevNode) {

		if (currNode.right != null) {
		    stack.push(currNode.right);
		} else {
		    stack.pop();
		}
	    }

	    else if (currNode.right == prevNode) {
		stack.pop();
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

    // Given a value in a binary search tree, print all the paths (starting from
    // the root or any other node) which sum up to that value.

    // Given a binary tree.
    // Print nodes of extreme corners of each level but in alternate order.
    // For a given BST, connect each of its right child to its inorder
    // successor.

    // Find kth smallest in BST

    // For a given binary tree, largest binary search sub-tree should be found.

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
}
