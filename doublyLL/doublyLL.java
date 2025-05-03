package com.sudhanshu.doublyLL;

public class doublyLL {

    Node head;
    Node tail;
    private int size = 0;

    /* INSERTION - FUNCTION */


    // insertFirst function
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        size++;
    }


    // insertLast Function
    public void insertLast(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next !=  null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
        size++;
    }


    //insert at the inetermediate - position
    public void insertIntermediate(int val,int index) {
        Node node = new Node(val);
        Node temp = head;
        int count = 0;
        while(count != index - 1) {
            temp = temp.next;
            count++;
        }
        // connection - 1
        node.next = temp.next;
        temp.next.prev = node;

        // connection - 2
        temp.next = node;
        node.prev = temp;

        size++;
    }

    /* DISPLAY - FUNCTION */

    public void display() {
        Node node = head;
        Node last = null;
        while(node != null) {
            System.out.print(node.val+"->");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("printing in the reverse order ");


        while(last != null ) {
            System.out.print(last.val+"->");
            last = last.prev;
        }
        System.out.println("START");
    }



    /* Node class with its constructors*/
    public class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,Node next,Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
