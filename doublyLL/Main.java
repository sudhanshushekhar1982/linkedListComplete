package com.sudhanshu.doublyLL;

public class Main {
    public static void main(String[] args) {
        doublyLL dll = new doublyLL();
        dll.insertFirst(10);
        dll.insertFirst(9);
        dll.insertFirst(8);
        dll.insertLast(13);
        dll.insertIntermediate(100,2);
        dll.display();
    }
}
