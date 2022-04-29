package io.github.redkcn.leetcode.easy;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public ListNode mergeByRecursion(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeByRecursion(list1.next, list2);
            return list1;
        }

        list2.next = mergeByRecursion(list1, list2.next);
        return list2;
    }

    public ListNode mergeByIterator(ListNode list1, ListNode list2) {
        ListNode guard = new ListNode();
        ListNode currentNode = guard;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode = list1;
                list1 = list1.next;
            } else {
                currentNode = list2;
                list2 = list2.next;
            }

            currentNode = currentNode.next;
        }

        currentNode.next = list1 == null ? list2 : list1;

        return guard.next;
    }

}

class ListNode {

    Integer val;
    ListNode next;

    ListNode() {
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}