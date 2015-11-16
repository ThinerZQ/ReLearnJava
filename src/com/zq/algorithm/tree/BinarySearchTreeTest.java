package com.zq.algorithm.tree;

import java.util.Random;

/**
 * Created by zhengshouzi on 2015/11/14.
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {

        int[] a = {3,6,7,19,54,23,41,66,10,30};
        System.out.println("------------------���ɶ�����------------------------------");
        //����������
        BinarySearchTree binarySearchTree = new BinarySearchTree(a);

        System.out.println("--------------------����ڵ�----------------------------");
        //����һ������
        binarySearchTree.insert(15);

        System.out.println("--------------------�������----------------------------");
        //�������
        binarySearchTree.inorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //ǰ�����
        binarySearchTree.preorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //�������
        binarySearchTree.postorderTravral(binarySearchTree.getRoot());
        System.out.println();


        System.out.println("--------------------���ҽڵ�----------------------------");
        //���ҽڵ�
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 7);
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 66);
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 100);


        System.out.println("---------------------����ǰ���ڵ�---------------------------");
        //���ǰ���ڵ�
        binarySearchTree.predecessor(41);
        binarySearchTree.predecessor(3);
        binarySearchTree.predecessor(100);


        System.out.println("----------------------���Һ�̽ڵ�--------------------------");
        //��ú�̽ڵ�
        binarySearchTree.succeror(41);
        binarySearchTree.succeror(66);
        binarySearchTree.succeror(100);


        System.out.println("-----------------------���ֵ-------------------------");
        //���ֵ
        binarySearchTree.maxResursive(binarySearchTree.getRoot());
        System.out.println("------------------------��Сֵ------------------------");
        //��Сֵ
        binarySearchTree.minResursive(binarySearchTree.getRoot());


        System.out.println("------------------ɾ���ڵ�------------------------------");
        //ɾ���ڵ�
        binarySearchTree.delete(binarySearchTree.getRoot(), 15);


        System.out.println("----------------------�����ڵ�--------------------------");
        //�������
        binarySearchTree.inorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //ǰ�����
        binarySearchTree.preorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //�������
        binarySearchTree.postorderTravral(binarySearchTree.getRoot());
        System.out.println();


        System.out.println("------------------------------------------------");

    }

}

/**
 * �����������
 */
class BinarySearchTree{

    //���ĸ��ڵ�
    private Node root;
    //�ڵ����
    private int count=0;

    /**
     * ���ݴ���������һ��������й���һ��������
     * @param a һ����
     * @param randomValue ���һ��ֵ����Ϊ���ֵ���
     */
    public BinarySearchTree(int[] a,int randomValue){
        System.out.println("�����������������");
        Random random  = new Random(randomValue);
        int value = random.nextInt(a.length);
        //�õ�a�����һ���������
        for (int i = value; i < a.length+value; i++) {
            if (i>=a.length){
                insert(a[i-a.length]);
            }else {
                insert(a[i]);
            }
        }
    }

    /**
     * �������һ��Ԫ�ؿ�ʼ����
     * @param a
     */
    public BinarySearchTree(int[] a){
        System.out.println("�������һ��Ԫ�ؿ�ʼ��������������");
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    /**
     * ������������������������˳���
     * @param root ���ĸ��ڵ�
     */
    public void inorderTravral(Node root){

        if (root==this.root){
            System.out.print("�������: ");
        }
        if (root!=null){

            inorderTravral(root.getLchild());
            System.out.print(root.getData() + "  ");
            inorderTravral(root.getRchild());
        }
    }
    /**
     * ǰ����������������������˳���
     * @param root ���ĸ��ڵ�
     */
    public void preorderTravral(Node root){
        if (root==this.root){
            System.out.print("ǰ�����: ");
        }

        if (root!=null){

            System.out.print(root.getData() + "  ");
            preorderTravral(root.getLchild());
            preorderTravral(root.getRchild());
        }
    }
    /**
     * ������������������������˳���
     * @param root ���ĸ��ڵ�
     */
    public void postorderTravral(Node root){
        if (root==this.root){
            System.out.print("�������: ");
        }

        if (root!=null){

            postorderTravral(root.getLchild());
            postorderTravral(root.getRchild());
            System.out.print(root.getData() + "  ");
        }
    }

    /**
     * ����Ԫ�أ�k����Ҫ����Ĺؼ��֣�
     * @param k
     */
    public void insert(int k){

        Node node = new Node(k);
        if (root != null) {
            //ÿ�ν���Ҫ�����Ԫ�ؽ�����Ӧ�Ľڵ����ȥ������ӹ�ϵ
            this.root.addNode(node);
        } else {
            //��һ������Ԫ�أ��������ڵ㴦��
            node.setParent(null);
            node.setLchild(null);
            node.setRchild(null);
            this.root = node;
        }
        this.count++;
    }

    /**
     * ɾ��Ԫ�أ����������
     * 1����Ҫɾ����Ԫ����Ҷ�ڵ�
     * 2����Ҫɾ����Ԫ����һ�����ӽڵ�
     * 3����Ҫɾ����Ԫ�����������ӽڵ�
     * ������������ֱ��Ӧ�˷����е�����if���
     * @param root ���ڵ�
     * @param k ��Ҫɾ����Ԫ��
     */
    public void delete(Node root , int k){

        Node node = searchRecursion(this.root,k);
        System.out.println("ɾ���ڵ㣺" + k);
        if (node==null){
            System.out.println("û������ڵ�: "+k+" ,����Ҫɾ��");
            return;
        }
        //�����Һ��Ӷ��ǿյģ�Ҳ����˵��Ҫɾ������Ҷ�ڵ㣬��ôֱ��ɾ����ֻ�޸ĸýڵ�ĸ��ڵ�ͺ���
        if (node.getLchild() == null  && node.getRchild() == null){
            //��null���滻node
            transplant(root, node, null);
        } else if (node.getRchild() == null  || node.getLchild() == null){
            if (node.getRchild() == null){
                //�Һ���Ϊ�գ�ֱ���������滻����ڵ�ͺ���
                //��node���������滻node
                transplant(root,node,node.getLchild());
            }else {
                //����Ϊ�գ����Һ������滻����ڵ�ͺ���

                //�õ�node�ڵ�ĺ��ֵ��һ���������Һ���Ϊ���������ϡ�
                Node tempSuccessor = minResursive(node.getRchild());

                //���node��̵Ĳ���node���Һ��ӣ������������ϵĽڵ㣬��ô����
                if (tempSuccessor.getParent() != node){
                    //��node�ĺ��Ԫ�غͺ��Ԫ�ص��Һ��ӻ���
                    transplant(root,tempSuccessor,tempSuccessor.getRchild());
                    //���Ԫ�������Һ��ӣ�Ϊnode���Һ���
                    tempSuccessor.setRchild(node.getRchild());
                    //���Ԫ���Һ�����Ӹ��׹�ϵ
                    tempSuccessor.getRchild().setParent(tempSuccessor);
                }
                //ͨ������if����ĸı䣬�Ѿ���tempSuccessor ��������node�������Ķ��㣬���ǻ�û����node��tempsuccessor�м佨����ϵ������Ĵ�������֮�佨����ϵ��ͬʱ�������Ĵ��벻ִ�У���ô��ʾ
                //�����node���Һ��ӣ���ôֱ�Ӱ������̺�node�滻�����ˡ�
                transplant(root,node,tempSuccessor);
            }

        }else {
            //��������˵��ֻ�����Ӳ�Ϊ�գ��Һ��Ӳ�Ϊ�ա�
            //�õ�node�ڵ�ĺ��ֵ��һ���������Һ���Ϊ���������ϡ�
            Node tempSuccessor = minResursive(node.getRchild());

            //���node��̵Ĳ���node���Һ��ӣ������������ϵĽڵ㣬��ô����
            if (tempSuccessor.getParent() != node){
                //��node�ĺ��Ԫ�غͺ��Ԫ�ص��Һ��ӻ���
                transplant(root,tempSuccessor,tempSuccessor.getRchild());
                //���Ԫ�������Һ��ӣ�Ϊnode���Һ���
                tempSuccessor.setRchild(node.getRchild());
                //���Ԫ���Һ�����Ӹ��׹�ϵ
                tempSuccessor.getRchild().setParent(tempSuccessor);
            }
            //ͨ������if����ĸı䣬�Ѿ���tempSuccessor ��������node�������Ķ��㣬���ǻ�û����node��tempsuccessor�м佨����ϵ������Ĵ�������֮�佨����ϵ��ͬʱ�������Ĵ��벻ִ�У���ô��ʾ
            //�����node���Һ��ӣ���ôֱ�Ӱ������̺�node�滻�����ˡ�
            transplant(root,node,tempSuccessor);
            //��ԭ��node�����ӣ���Ӹ����������
            tempSuccessor.setLchild(node.getLchild());
            //��������Ӹ��׽ڵ�
            tempSuccessor.getLchild().setParent(tempSuccessor);
        }
    }

    /**
     * ��������Ԫ�أ�����ɾ����������
     * @param root ���ڵ�
     * @param deleteNode ��Ҫɾ���Ľڵ�
     * @param replaceNode �滻�Ľڵ�
     */
    private void transplant(Node root,Node deleteNode,Node replaceNode){

        if (deleteNode.getParent() == null){
            //��ɾ�����Ǹ��ڵ�
                this.setRoot(replaceNode);
        }else if (deleteNode == deleteNode.getParent().getLchild()){
            //����ɾ���Ľڵ�ĸ��׵���������Ϊ�滻�ڵ�
            deleteNode.getParent().setLchild( replaceNode );
        }else if (deleteNode == deleteNode.getParent().getRchild()){
            //����ɾ���Ľڵ�ĸ��׵��Һ�������Ϊ�滻�ڵ�
            deleteNode.getParent().setRchild(replaceNode);
        }
        //����滻�ڵ㲻Ϊ�գ���ô���滻�ڵ�ĸ�������Ϊɾ���ڵ�ĸ���
        if (replaceNode != null){
            replaceNode.setParent(deleteNode.getParent());
        }
    }

    /**
     * �ݹ����ĳһ��Ԫ��
     * @param root ָ����ڵ�ģ����ã�
     * @param k ��Ҫ���ҵ�ֵ
     * @return �����ҵ��Ľڵ㣬Ϊ����û�����ֵ��
     */
    public Node searchRecursion(Node root ,int k){

        //root ==null ,��ʾû���ҵ���Ԫ�أ�k==root.getData() ��ʾ�ҵ������Ԫ��
        if (root==null || k==root.getData()){
            if (root==null){
                System.out.println("û���ҵ� ��" +k);
            }else if (k==root.getData()){
                System.out.println("�ҵ���" +k);
            }
            return root;
        }
        //�ݹ���ң������߲��ҿ���
        if (k<root.getData()){
            return searchRecursion(root.getLchild(), k);
        }else{
            return searchRecursion(root.getRchild(),k);
        }
    }
    /**
     * ѭ������ĳһ��Ԫ��
     * @param root ָ����ڵ�ģ����ã�
     * @param k ��Ҫ���ҵ�ֵ
     * @return �����ҵ��Ľڵ㣬Ϊ����û�����ֵ��
     */
    public Node searchCirculation(Node root ,int k){

        while (root!=null && k!=root.getData()){
            if (k<root.getData()){
                root=root.getLchild();
            }else{
                root=root.getRchild();
            }
        }
        if (root==null){
            System.out.println("û���ҵ� ��" +k);
        }else if (k==root.getData()){
            System.out.println("�ҵ���" +k);
        }
        return root;
    }

    /**
     * �ݹ�����Сֵ
     * @param root ָ����ڵ�ģ����ã�
     * @return �ҵ�����Сֵ����
     */
    public Node minResursive(Node root){

        if (root.getLchild()==null){
            System.out.println("��Сֵ��" +root.getData());
            return root;
        }else {
            return minResursive(root.getLchild());
        }
    }

    /**
     * ѭ������Сֵ
     * @param root ָ����ڵ�ģ����ã�
     * @return �ҵ�����Сֵ����
     */
    public Node minCirculation(Node root){

        while (root.getLchild() != null){
            root = root.getLchild();
        }
        System.out.println("��Сֵ��" +root.getData());
        return root;
    }

    /**
     * �ݹ�����Сֵ
     * @param root ָ����ڵ�ģ����ã�
     * @return �ҵ�����Сֵ����
     */
    public Node maxResursive(Node root){

        if (root.getRchild()==null){
            System.out.println("���ֵ��" +root.getData());
            return root;
        }else {
            return maxResursive(root.getRchild());
        }
    }

    /**
     * ѭ������Сֵ
     * @param root ָ����ڵ�ģ����ã�
     * @return �ҵ�����Сֵ����
     */
    public Node maxCirculation(Node root){

        while (root.getRchild() != null){
            root = root.getRchild();
        }
        System.out.println("���ֵ��" +root.getData());
        return root;
    }

    /**
     * ����ǰ�������ؼ��ֲ��ң����ҵ�����ؼ��֣��õ�����ؼ��ֶ�Ӧ�Ľڵ����Ȼ���ٷ���
     * ǰ����Ϊ���������
     * 1������ڵ�node ���������ǿգ���ônode��ǰ��ǡ����node�������е����ڵ�
     * 2������ڵ�node��������Ϊ�գ���ô��̾���node����ײ����ȣ����Һ�̵�����Ҳ��node�����ȡ�
     * @param k �ؼ��֣��������ʹ��node�ڵ���Ϊ��Ҫ���ҵĽڵ㣬��Ϊ����ڵ��������ͬ��keyֵ
     * @return ���ҵ���ǰ���ڵ�
     */

    public Node predecessor(int k){
        Node node = searchRecursion(this.root,k);
        if (node==null){
            System.out.println("û�� " + k + " ���Ԫ��");
            return null;
        }
        if (minResursive(this.root)==node){
            System.out.println(k + " ����С��Ԫ�أ�û��ǰ��");
        }
        //��Ե�һ�����
        if (node.getLchild() !=null){
            Node preNode = minCirculation(node.getLchild());
            System.out.println(k+" ��ǰ���ǣ�" +preNode.getData());
            return preNode;
        }
        //��ʱtemp�ڵ�
        Node temp = node.getParent();
        //���ϲ���node�ڵ��ǰ��ֵ,ֱ����Ҫ���ҵĽڵ�ĸ��ڵ㣬����temp�ڵ������
        while (temp != null &&  node == temp.getLchild()){
            node = temp;
            temp = temp.getParent();
        }
        if (temp!= null){
            System.out.println(k+" ��ǰ���ǣ�" +temp.getData());
        }

        return temp;

    }
    /**
     * ���Һ�̣����ؼ��ֲ��ң����ҵ�����ؼ��֣��õ�����ؼ��ֶ�Ӧ�Ľڵ����Ȼ���ٷ���
     * ��̷�Ϊ���������
     * 1������ڵ�node ���������ǿգ���ônode�ĺ��ǡ����node�������е���С�ڵ�
     * 2������ڵ�node��������Ϊ�գ���ô��̾���node����ײ����ȣ����Һ�̵�����Ҳ��node�����ȡ�
     * @param k �ؼ���
     * @return ���ҵ��ĺ�̽ڵ�
     */
    public Node succeror(int k){
        Node node = searchRecursion(this.root,k);

        if (node==null){
            System.out.println("û�� "+k+" ���Ԫ��");
            return null;
        }
        if (maxResursive(this.root)==node){
            System.out.println(k+" ������Ԫ�أ�û�к��");
        }
        //��Ե�һ�����
        if (node.getRchild() !=null){
            Node postNode = maxResursive(node.getRchild());
            System.out.println(k+" �ĺ���ǣ�" +postNode.getData());
            return postNode;
        }
        //��ʱtemp�ڵ�
        Node temp = node.getParent();
        //���ϲ���node�ڵ�ĺ��ֵ,ֱ����Ҫ���ҵĽڵ�ĸ��ڵ㣬����temp�ڵ���Һ���
        while (temp != null &&  node == temp.getRchild()){

            node = temp;
            temp = temp.getParent();
        }
        if (temp!= null){
            System.out.println(k+" �ĺ���ǣ�" +temp.getData());
        }
        return temp;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


/**
 * �ڵ���
 */
class Node{
    //���ӣ��Һ��ӣ����׽ڵ㣬�� key ���ݣ���Ȼ�����key�������κζ���Ҳ���Դ���������
    private Node lchild;
    private Node rchild;
    private Node parent;

    private int data;

    /**
     * ��ӽڵ�ķ�����ÿ���ڵ�������� data ֵ�����ж��Ƿ񽫵�ǰ������ӵ�����ĺ��ӽڵ㡣
     * @param newNode ��Ҫ��ӵĽڵ�
     */
    public void addNode(Node newNode) {

        if (this.getData() > newNode.getData()){
            //���뵽�˽ڵ�����
            if (this.getLchild()!=null){
                this.getLchild().addNode(newNode);
            }else {
                //��ʼ����
                newNode.setParent(this);
                this.setLchild(newNode);
                System.out.println("����ڵ㣺" +newNode.getData());
            }
        }else {
            //���뵽�˽ڵ���ұ�
            if (this.getRchild()!=null){
                this.getRchild().addNode(newNode);
            }else{
                newNode.setParent(this);
                this.setRchild(newNode);
                System.out.println("����ڵ㣺" + newNode.getData());
            }
        }
    }


    public Node(int data) {
        this.data = data;
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }
}

