package com.company;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    public SinglyLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertIndex(int val, int index){
        Node temp = head;

        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = new Node(val, temp.next); //assigning temp.next to a new node

        size++;
    }

    public void insertLast(int val){
        Node temp = new Node(val);

        if(tail == null){
            insertFirst(val);
        }
        else{
            temp.next = null;
            tail.next = temp;
            temp = tail;
        }
        size++;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List empty");
        }

        head = head.next;
        size--;
    }

    public void deleteLast(){
        Node temp = head;

        if(tail == head){
            deleteFirst();
            return;
        }
        for (int i = 1; i < size-1; i++) {
            temp = temp.next;
        }

        tail = temp;
        temp.next = null;

        size--;
    }

    public Node get(int index){  //It gets the node at the given index position
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void deleteIndex(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size-1){
            deleteLast();
            return;
        }

        Node before = head;
        Node indexNode = get(index);

        for (int i = 1; i < index; i++) {
            before = before.next;
        }

        before.next = indexNode.next;
        indexNode.next = null;

        size--;
    }

    private class Node{
        private Node next;
        private int val;

        public Node(){
            this.val = 0;
        }

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
//---------------------------------------------------------------------------
//Main function :
//---------------------------------------------------------------------------
package com.company;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();

        list1.insertFirst(6);
        list1.insertFirst(5);
        list1.insertFirst(4);
        list1.insertFirst(3);
        list1.insertFirst(2);
        list1.insertFirst(1);
        list1.display();

        System.out.println();

        list1.deleteIndex(3);
        list1.display();
    }
}
