package Coding;

import java.util.Arrays;
import java.util.List;

/**
 * BST can be balanced or unbalanced
 * 
 * No duplicate elements
 * 
 * 
 * left <= root < right => left biased
 * 
 * left < root <= right => right biased
 * 
 * Inorder traversal gives sorted array of values.
 * 
 * 
 * log(n) Avg search
 * 
 * 
 * 
 * Worst case (when the tree degenerates into a linear structure, like a linked
 * list) is O(n), which happens if the nodes are inserted in an already sorted
 * order.
 * 
 ** 2
 *** \
 **** 3
 ***** \
 ****** 4
 * 
 * @param root
 * @param val
 * @return
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    public TreeNode createBST(List<Integer> list) {
        TreeNode root = null;
        for (int value : list) {
            root = insert(root, value);
        }

        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.value) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.value + " ");
        inorderTraversal(root.right);
    }

    public boolean search(TreeNode root, int value) {

        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }

    }

    public TreeNode deleteNodeInBst(TreeNode root, int val) {
        // find node:
        // no child return null
        // 1 child replace and return child
        // 2 children:
        // replace with inorder succesor or inorder predecessor
        // delete the above got node(inorder succesor or inorder predecessor)

        if (root == null) {
            return root;
        }

        if (root.value < val) {
            root.right = deleteNodeInBst(root.right, val);
        } else if (root.value > val) {
            root.left = deleteNodeInBst(root.left, val);
        } else {
            // found node
            if (root.left == null && root.right == null) {
                return null;
            } else {
                // 1 child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    // 2 children

                    TreeNode inorderSuccessor = findMin(root.right); // O(logN)
                    root.value = inorderSuccessor.value;
                    root.right = deleteNodeInBst(root.right, inorderSuccessor.value); // O(logN search and delete that
                                                                                      // leaf node)
                }
            }

        }
        return root;

    }

    private TreeNode findMin(TreeNode rightNode) {
        while (rightNode.left != null) {
            rightNode = rightNode.left;
        }
        return rightNode;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        List<Integer> list = Arrays.asList(3, 1, 6, 8, 4);
        TreeNode node = bst.createBST(list);
        bst.inorderTraversal(node);
        System.out.println(bst.search(node, 4));
        System.out.println(bst.deleteNodeInBst(node, 1));
        System.out.println("After Deletion >>>>>>>");
        bst.inorderTraversal(node);
    }
}
