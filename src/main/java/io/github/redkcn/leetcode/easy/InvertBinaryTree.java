package io.github.redkcn.leetcode.easy;

/**
 * 226. Invert Binary
 * <p>
 * Tree Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Link: https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author vicente
 * @date 2022/3/19
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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


