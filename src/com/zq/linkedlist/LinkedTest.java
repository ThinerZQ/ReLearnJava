package com.zq.linkedlist;

/**
 * Created by zhengshouzi on 2015/10/1.
 */
public class LinkedTest {
    public static void main(String[] args) {


        /*
        Node root = new Node("root");
        Node n1 = new Node("data1");
        Node n2 = new Node("data2");
        Node n3 = new Node("data3");
        Node n4 = new Node("data4");
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Node currentNode = root;
        */
        /*
        while(currentNode!=null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        */

        //printNode(currentNode);


        Link link = new Link();
        link.add("zhengqiang");
        link.add("2423");
        link.add("2423");
        link.add("2423");
        link.add("2423");
        link.add("2423");
        link.add("2423");

        link.print();
        System.out.println(link.size());
        System.out.println(link.isEmpty());

    }
/*
    public static void printNode(Node currentNode) {

        if (currentNode != null) {
            System.out.println(currentNode.getData());
            printNode(currentNode.getNext());
        }
    }*/

}

class Link {
    private Node root;
    private int count;

    public void add(String data) {
        Node node = new Node(data);
        if (root != null) {
            this.root.addNode(node);
        } else {
            this.root = node;
        }
        this.count++;
    }

    public void print() {
        if (this.root != null) {
            this.root.printNode();
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clean() {
        this.root = null;
        this.count = 0;
    }

    public String get(int index) {


        //if()


        return "";
    }


    private class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void addNode(Node newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void printNode() {
            System.out.println(this.getData());
            if (this.next != null) {
                this.next.printNode();
            }
        }
    }

}

