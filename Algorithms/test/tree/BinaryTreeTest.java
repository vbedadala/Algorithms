package tree;

import org.junit.Before;
import org.junit.Test;

import trees.BinarySearchTree;
import trees.BinarySearchTree.Node;

public class BinaryTreeTest {
    BinarySearchTree bst;
    BinarySearchTree mirrorbst;


    @Before
    public void setupBST() {
        //18, 12,25,4,15,	25,30,1,13,17,28.3, 14, 29
        bst = new BinarySearchTree();
        bst.insert(18);
        bst.insert(12);
        bst.insert(25);
        bst.insert(4);
        bst.insert(15);
        bst.insert(25);
        bst.insert(30);
        bst.insert(1);
        bst.insert(13);
        bst.insert(17);
        bst.insert(28);
        bst.insert(3);
        bst.insert(14);
        bst.insert(29);


    }

    @Test
    public void testInorder() {
        bst.inOrder();
    }

    @Test
    public void testPreorder() {
        bst.preOrder();
    }

    @Test
    public void testPreorderIt() {
        bst.preOrderIterative();
    }

    @Test
    public void testPostOrderIt() {
        bst.postOrderIterative();
    }

    @Test
    public void testPostOrderUsingPrevNode() {
        bst.postOrderIterativeUsingPrevNode();
    }

    @Test
    public void testPostorder() {
        bst.postOrder();
    }

    @Test
    public void testLevelorder() {
        bst.levelOrder();
    }

    @Test
    public void testReverseLevelorder() {
        bst.reverseLevelOrder();
    }


    @Test
    public void testInorderIterative() {
        bst.inOrderIterative();
    }

    @Test
    public void testPostorderIterative() {
        bst.postOrderIterative();
    }

    @Test
    public void testLevelorderUsingList() {
        bst.printLevelByLevel();
    }

    @Test
    public void testLowestCommonAncestor() {
        System.out.println("LCA of 14 & 29 is:" + bst.leastCommonAncestor(14, 29));
    }

    @Test
    public void testBinaryTreeConstructionUsingPreOrder() {
        int inOrder[] = {4, 10, 3, 1, 7, 11, 8, 2};
        int preOrder[] = {7, 10, 4, 3, 1, 2, 8, 11};

        Node n = bst.constructBinaryTreeUsingInOrderAndPreOrder(inOrder, preOrder);

        bst.inOrder(n);
    }

    @Test
    public void testBinaryTreeConstructionUsingPostOrder() {
        int inOrder[] = {4, 10, 3, 1, 7, 11, 8, 2};
        int postOrder[] = {4, 1, 3, 10, 11, 8, 2, 7};

        Node n = bst.constructBinaryTreeUsingInOrderAndPostOrder(inOrder, postOrder);

        bst.inOrder(n);


        System.out.println("LCA Of 4 and 3 is :" + bst.lca(4, 2, n));

    }

    @Test
    public void testDepth() {
        System.out.println("depth of binary tree " + bst.depth());
    }


    @Test
    public void testHasPathSum() {
        System.out.println("Binary tree has sum 20" + bst.hasPathSum(200));
    }

    @Test
    public void testMirror() {
        //bst.mirror();
        //bst.inOrder();
        System.out.print(bst.isMirror());
    }

    @Test
    public void testIsBst() {
        //bst.mirror();
        //bst.inOrder();
        System.out.print(bst.isBST());
    }
}
