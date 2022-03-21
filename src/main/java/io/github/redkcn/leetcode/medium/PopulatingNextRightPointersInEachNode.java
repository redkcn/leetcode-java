package io.github.redkcn.leetcode.medium;

/**
 * 116. Populating Next Right Pointers in Each Node You are given a perfect binary tree where all leaves are on the same level, and every parent has two
 * children. The binary tree has the following definition:
 * <p>
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each next pointer to point to its next right node. If there is no next right node, the
 * next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 *
 * @author vicente
 * @date 2022/3/20
 */

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        connectTwoNode(root.left, root.right);
        return root;
    }

    void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;

        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

