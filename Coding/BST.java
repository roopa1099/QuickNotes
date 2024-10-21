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
 * log(n)
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

    public static void main(String[] args) {
        BST bst = new BST();
        List<Integer> list = Arrays.asList(3, 1, 6, 8, 4);
        TreeNode node = bst.createBST(list);
        bst.inorderTraversal(node);
        System.out.println(bst.search(node, 4));
    }
}
