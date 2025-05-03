package com.sudhanshu.singlyLL;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(10);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertLast(20);
        list.insertLast(99);
        list.insertIntermediate(100,3);

        list.display();
        list.display();
        list.deleteLast();
        list.display();
        list.deleteInt(3);
        list.display();
        list.get(2);


    }
}
