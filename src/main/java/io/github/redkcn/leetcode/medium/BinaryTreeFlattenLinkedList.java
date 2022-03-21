package io.github.redkcn.leetcode.medium;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always
 * null. The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 *
 * @author vicente
 * @date 2022/3/20
 */

public class BinaryTreeFlattenLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tempLeft = root.left, tempRight = root.right;
        root.left = null;
        root.right = tempLeft;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = tempRight;
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


