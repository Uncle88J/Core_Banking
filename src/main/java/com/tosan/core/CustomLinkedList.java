package com.tosan.core;

public class CustomLinkedList<T> {

    private class Node {
        private T data;
        private Node next;
    }

    private Node head;
    private int size = 0;


    public void add(T o) {
        if (head == null) {
            head = new Node();
            head.data = o;
        } else {
            Node newHead = new Node();
            newHead.data = o;
            newHead.next = head;

            head = newHead;
        }

        size++;
    }


    public T removeFromHead() {
        Node prevHead = head;
        head = head.next;
        return prevHead.data;
    }


    public T getHead() {
        return head.data;
    }


    public int getSize() {
        return size;
    }

    public void test() {
        Node selected = head;
        while (selected.next != null) {
            System.out.println(selected);
            selected = selected.next;
        }
    }
}
