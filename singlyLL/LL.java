package com.sudhanshu.singlyLL;

// linked - list class
public class LL {

    private Node head = null;
    private Node tail = null ;

    private int size;

    public LL() {
        this.size = 0;
    }

    // different function for linked - list operartion

    /* insert function to insert the beginning of the linked - list */
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size++;
    }


    public void insertLast(int val) {
        Node node = new Node(val);

        Node temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = null;
        size++;
    }

    /* insert - last if the tail of the list is given  */
    public void addLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    /* insertion function for inserting in the intermediate position of the linked list*/
    public void insertIntermediate(int val,int pos) {
        if(pos == 0) {
            insertFirst(val);
            return;
        }

        if(pos == size - 1) {
            insertLast(val);
            return;
        }


        Node node = new Node(val);
        Node temp = head;
        int count = 1;
        while(count < pos ) { // if we follow the 0 based indexing in the linked - list then it is fine
            temp = temp.next;
            count++;
        }
        Node temp2 = temp.next;
        temp.next = node;
        node.next = temp2;
        size++;
    }

    /* insert - intermediate function told by kunal kushwaha */

    public void addInt(int val,int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 1; i<index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }


    /*function for deletion */

    /*function for delete first*/

    public int deleteFirst() {
        if(size == 0) {
            System.out.println("underflow error!!!");
            return -1;
        }
        Node temp = head;
        int val = temp.value;
        head = head.next;
        size--;
        return val;
    }

    /* function for deleting the last element*/
    public int deleteLast() {
          Node temp = head;
//        while(temp.next.next != null ) {
//            temp = temp.next;
//        }
//        int val = temp.next.value;
//        temp.next = null;
//        size--;

        for(int i =1;i<size-1;i++) {
            temp = temp.next;
        }
        temp.next = null;
        int val = temp.value;
        tail = temp;
        size--;
        return val;
    }

    /* delete the inetermediate node */

    public int deleteInt(int index) {
        int count = 1;
        Node temp = head;
        while(count < index - 1) {
            temp = temp.next;
            count++;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;
    }


    /* get functions */

    public Node get(int index) {
        Node temp = head;
        for(int i =1;i<index;i++) {
            temp = temp.next;
        }
//        System.out.println(temp.value);
        return temp;
    }

    /* function to get the value of the node */
    public int getValue(int index) {
        Node ans = get(index);
        return ans.value;
    }

    /* finding the node */
    public Node find(int value) {
        Node node = head;
        while(node != null){
            if(node.value == value) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    /* Display function for displaying the nodes of the linked - list*/
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Node class

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
