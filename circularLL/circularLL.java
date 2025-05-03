package com.sudhanshu.circularLL;

public class circularLL {

    private Node head;
    private Node tail;

    public circularLL() {
        this.head = null;
        this.tail = null;
    }

    /* insertion function for the circular linked - list */

    public void insert(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            head.next = head;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }


    /* Display - Function for the circular linked list*/

    // display
    public void display() {
        Node node = head;
        if(head != null) {
            do {
                System.out.print(node.val + "->");
                node = node.next;
            } while(node != head);
        }
    }

    public void display1() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            if(current == null) {
                break;
            }
            System.out.print(current.val + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }


    /* Delete function for the circular linked - list */

    public void delete(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        // Special case: if head is to be deleted
        if (head.val == val) {
            // Only one node
            if (head.next == head) {
                head = null;
                return;
            }

            // Find last node to update its next
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return;
        }

        // General case
        while (curr.next != head && curr.next.val != val) {
            curr = curr.next;
        }

        if (curr.next.val == val) {
            curr.next = curr.next.next;
        } else {
            System.out.println("Value not found");
        }
    }


    /* Node class */
    private class Node {
        int val;
        Node next;

        // constructor of the
        public Node(int val) {
            this.val = val;
        }
    }
}
