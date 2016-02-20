package com.zq.linkedlist;

/**
 * Created by zhengshouzi on 2015/10/1.
 */
public class SingleLinkedTest {
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


        SingleLink link = new SingleLink();
        link.insert(10);
        link.insert(20);
        link.insert(21);


        link.print();

        System.out.println("链表大小："+ link.size());
        System.out.println("链表是否为空："+link.isEmpty());

    }
/*
    public static void printNode(Node currentNode) {

        if (currentNode != null) {
            System.out.println(currentNode.getData());
            printNode(currentNode.getNext());
        }
    }*/

}

class SingleLink {
    private Node root;
    private int count;

    public void insert(int data) {
        Node node = new Node(data);
        if (root != null) {
            this.root.addNode(node);
        } else {
            this.root = node;
        }
        this.count++;
    }

    public void delete(int k){
        //先查找到这个Node
        Node currentNode = root;
        Node lastNode=currentNode;
        while (currentNode != null && currentNode.getData() != k){
            lastNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode==root){
            //要删除的元素是第一个，或者链表为空
            if (currentNode==null){
                System.out.println("链表为空");
            }else {
                //要删除的是第一个
                root = root.getNext();
            }
        }else {
            //断开连接
            lastNode.setNext(currentNode.getNext());
        }
    }

    public Node search(int k){

        Node currentNode = root;
        while (currentNode != null && currentNode.getData()!=k){
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public void sort(){





    }


    public void print() {
        if (this.root != null) {
            System.out.print("输出链表元素：");
            this.root.printNode();
            System.out.println();
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

    public Node get(int index) {

        Node currentNode = root;
        if (index<=count && index>0){
            index--;
            while (currentNode != null && index>0){
                currentNode = currentNode.getNext();
                index--;
            }
        }
        return currentNode;
    }
}
class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
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
            System.out.print(newNode.getData());
        }
    }

    public void printNode() {
        System.out.print(this.getData() + "  ");
        if (this.next != null) {
            this.next.printNode();
        }
    }

}
