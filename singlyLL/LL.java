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

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

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

    //rules
    /*
    * void return type and make changes in the ll
    * node return type that return the list node to change the structure
    *  */

    //insert using the recurssion
    public void insertRec(int val,int index) {
        head = insertRec(val,index,head);
    }

    private Node insertRec(int val,int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next =  insertRec(val,index--,node.next);
        return node;
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

    //questions
    public void duplicate() {
        Node node = head;
        while(node.next !=  null) {
            if( node.value == node.next.value )  {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // merge
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();
        while(f != null &&  s != null) {
            if(f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    // cycle detection code
    public boolean hasCycle(Node head) {
        if(head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    // find the length of the cycle
    public int hasCycleCounter(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected, now count the number of nodes in the cycle
                int count = 1;
                Node temp = slow.next;

                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }

                System.out.println("The number of members in the cycle is " + count);
                return count;
            }
        }

        return 0; // No cycle
    }

    public Node hasCycleFindNode(Node head) {

//        Node slow = head;
//        Node fast = head;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast) {
//                fast = head;
//                while(slow != fast) {
//                    slow = slow.next;
//                    fast = fast.next;
//                    if(slow == fast) {
//                        return slow;
//                    }
//                }
//            }
//        }
//        return null;

        Node slow = head;
        Node fast = head;

        // phase -1 detect the cycle in the ll
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                // phase - 2 : find the entryv point of the cycle
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    // google qn can be done using the concept of the floyds cycle detection technique
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(slow != fast) ;

        if( slow == 1) {
            return true;
        }
        return false;
    }

        /* helper - function */
    private int findSquare(int num) {
        int ans = 0;
        while(num != 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }


    // finding the middle node of the linked - list
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // reversing the linked - list by recurssion
    private void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;

    }

    // in place reversal of the linked - list

    public Node reverseList(Node head) {
        if(size < 2) {
            return head;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }


    public Node reverseBetween(Node head, int left, int right) {
        if(left == right) {
            return head;
        }

        // skip the first left - 1 nodes

        Node current = head;
        Node prev = null;

        for(int i = 0; (current != null && i< left - 1);i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        // reverse between left and right
        Node nextNode = current.next;
        for(int i = 0;i< right - left + 1 && current != null;i++) {
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        if(last != null ){
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = prev;
        return head;
    }


    // reversing the part of the linked  list
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }

    // auxilliary function for getting the length of the linked - list
    public int getLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }


    // checking whether a palindrome or not

    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node reverseHead = headSecond;

        // compare both the halves
        while(head != null && headSecond != null) {
            if(head.value != headSecond.value) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reverseHead);
        if(head == null || headSecond == null) {
            return true;
        }
        return false;
    }
    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);

        Node hs = reverseList(mid);
        Node hf = head;

        // rearrange
        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    // rigth rotation of the linked - list
    public Node rotateRight(Node head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(4);
        second.insertLast(14);

        LL ans = LL.merge(first,second);
        ans.display();
        ans.duplicate();

        ans.display();

//        ans.reverseList();
        ans.display();
    }

}
