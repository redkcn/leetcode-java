package io.github.redkcn.leetcode.easy;

/**
 * 700. Search in a Binary Search Tree You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 *
 * @author vicente
 * @date 2022/3/20
 */
public class SearchInBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}