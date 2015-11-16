package com.zq.algorithm.tree;

import java.util.Random;

/**
 * Created by zhengshouzi on 2015/11/14.
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {

        int[] a = {3,6,7,19,54,23,41,66,10,30};
        System.out.println("------------------生成二叉树------------------------------");
        //生成树对象
        BinarySearchTree binarySearchTree = new BinarySearchTree(a);

        System.out.println("--------------------插入节点----------------------------");
        //插入一个数据
        binarySearchTree.insert(15);

        System.out.println("--------------------按序遍历----------------------------");
        //中序遍历
        binarySearchTree.inorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //前序遍历
        binarySearchTree.preorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //后序遍历
        binarySearchTree.postorderTravral(binarySearchTree.getRoot());
        System.out.println();


        System.out.println("--------------------查找节点----------------------------");
        //查找节点
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 7);
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 66);
        binarySearchTree.searchRecursion(binarySearchTree.getRoot(), 100);


        System.out.println("---------------------查找前驱节点---------------------------");
        //获得前驱节点
        binarySearchTree.predecessor(41);
        binarySearchTree.predecessor(3);
        binarySearchTree.predecessor(100);


        System.out.println("----------------------查找后继节点--------------------------");
        //获得后继节点
        binarySearchTree.succeror(41);
        binarySearchTree.succeror(66);
        binarySearchTree.succeror(100);


        System.out.println("-----------------------最大值-------------------------");
        //最大值
        binarySearchTree.maxResursive(binarySearchTree.getRoot());
        System.out.println("------------------------最小值------------------------");
        //最小值
        binarySearchTree.minResursive(binarySearchTree.getRoot());


        System.out.println("------------------删除节点------------------------------");
        //删除节点
        binarySearchTree.delete(binarySearchTree.getRoot(), 15);


        System.out.println("----------------------遍历节点--------------------------");
        //中序遍历
        binarySearchTree.inorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //前序遍历
        binarySearchTree.preorderTravral(binarySearchTree.getRoot());
        System.out.println();
        //后序遍历
        binarySearchTree.postorderTravral(binarySearchTree.getRoot());
        System.out.println();


        System.out.println("------------------------------------------------");

    }

}

/**
 * 二叉查找树类
 */
class BinarySearchTree{

    //树的根节点
    private Node root;
    //节点个数
    private int count=0;

    /**
     * 根据传入的数组的一个随机排列构建一个二叉树
     * @param a 一组数
     * @param randomValue 随便一个值，作为随机值标记
     */
    public BinarySearchTree(int[] a,int randomValue){
        System.out.println("随机构造二叉查找树：");
        Random random  = new Random(randomValue);
        int value = random.nextInt(a.length);
        //得到a数组的一个随机排列
        for (int i = value; i < a.length+value; i++) {
            if (i>=a.length){
                insert(a[i-a.length]);
            }else {
                insert(a[i]);
            }
        }
    }

    /**
     * 由数组第一个元素开始构建
     * @param a
     */
    public BinarySearchTree(int[] a){
        System.out.println("以数组第一个元素开始构造二叉查找树：");
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    /**
     * 中序遍历二叉搜索树，结果是顺序的
     * @param root 树的根节点
     */
    public void inorderTravral(Node root){

        if (root==this.root){
            System.out.print("中序遍历: ");
        }
        if (root!=null){

            inorderTravral(root.getLchild());
            System.out.print(root.getData() + "  ");
            inorderTravral(root.getRchild());
        }
    }
    /**
     * 前序遍历二叉搜索树，结果是顺序的
     * @param root 树的根节点
     */
    public void preorderTravral(Node root){
        if (root==this.root){
            System.out.print("前序遍历: ");
        }

        if (root!=null){

            System.out.print(root.getData() + "  ");
            preorderTravral(root.getLchild());
            preorderTravral(root.getRchild());
        }
    }
    /**
     * 后序遍历二叉搜索树，结果是顺序的
     * @param root 树的根节点
     */
    public void postorderTravral(Node root){
        if (root==this.root){
            System.out.print("后序遍历: ");
        }

        if (root!=null){

            postorderTravral(root.getLchild());
            postorderTravral(root.getRchild());
            System.out.print(root.getData() + "  ");
        }
    }

    /**
     * 插入元素，k是需要插入的关键字，
     * @param k
     */
    public void insert(int k){

        Node node = new Node(k);
        if (root != null) {
            //每次将需要插入的元素交给相应的节点对象去处理添加关系
            this.root.addNode(node);
        } else {
            //第一个插入元素，当做根节点处理
            node.setParent(null);
            node.setLchild(null);
            node.setRchild(null);
            this.root = node;
        }
        this.count++;
    }

    /**
     * 删除元素，分三种情况
     * 1、需要删除的元素是叶节点
     * 2、需要删除的元素有一个孩子节点
     * 3、需要删除的元素有两个孩子节点
     * 上面三种情况分别对应了方法中的三个if语句
     * @param root 根节点
     * @param k 需要删除的元素
     */
    public void delete(Node root , int k){

        Node node = searchRecursion(this.root,k);
        System.out.println("删除节点：" + k);
        if (node==null){
            System.out.println("没有这个节点: "+k+" ,不需要删除");
            return;
        }
        //左孩子右孩子都是空的，也就是说需要删除的是叶节点，那么直接删除，只修改该节点的父节点就好了
        if (node.getLchild() == null  && node.getRchild() == null){
            //用null来替换node
            transplant(root, node, null);
        } else if (node.getRchild() == null  || node.getLchild() == null){
            if (node.getRchild() == null){
                //右孩子为空，直接用左孩子替换这个节点就好了
                //用node的左孩子来替换node
                transplant(root,node,node.getLchild());
            }else {
                //左孩子为空，用右孩子来替换这个节点就好了

                //得到node节点的后继值，一定是在以右孩子为根的子树上。
                Node tempSuccessor = minResursive(node.getRchild());

                //如果node后继的不是node的右孩子，而是右子树上的节点，那么进行
                if (tempSuccessor.getParent() != node){
                    //将node的后继元素和后继元素的右孩子互换
                    transplant(root,tempSuccessor,tempSuccessor.getRchild());
                    //后继元素设置右孩子，为node的右孩子
                    tempSuccessor.setRchild(node.getRchild());
                    //后继元素右孩子添加父亲关系
                    tempSuccessor.getRchild().setParent(tempSuccessor);
                }
                //通过上面if里面的改变，已经把tempSuccessor 调整到了node右子树的顶层，但是还没有在node和tempsuccessor中间建立关系，下面的代码是在之间建立关系，同时如果上面的代码不执行，那么表示
                //后继是node的右孩子，那么直接把这个后继和node替换就行了。
                transplant(root,node,tempSuccessor);
            }

        }else {
            //进入这里说明只有左孩子不为空，右孩子不为空。
            //得到node节点的后继值，一定是在以右孩子为根的子树上。
            Node tempSuccessor = minResursive(node.getRchild());

            //如果node后继的不是node的右孩子，而是右子树上的节点，那么进行
            if (tempSuccessor.getParent() != node){
                //将node的后继元素和后继元素的右孩子互换
                transplant(root,tempSuccessor,tempSuccessor.getRchild());
                //后继元素设置右孩子，为node的右孩子
                tempSuccessor.setRchild(node.getRchild());
                //后继元素右孩子添加父亲关系
                tempSuccessor.getRchild().setParent(tempSuccessor);
            }
            //通过上面if里面的改变，已经把tempSuccessor 调整到了node右子树的顶层，但是还没有在node和tempsuccessor中间建立关系，下面的代码是在之间建立关系，同时如果上面的代码不执行，那么表示
            //后继是node的右孩子，那么直接把这个后继和node替换就行了。
            transplant(root,node,tempSuccessor);
            //将原来node的左孩子，添加给后继做左孩子
            tempSuccessor.setLchild(node.getLchild());
            //给左孩子添加父亲节点
            tempSuccessor.getLchild().setParent(tempSuccessor);
        }
    }

    /**
     * 互换两个元素，用于删除操作过程
     * @param root 根节点
     * @param deleteNode 需要删除的节点
     * @param replaceNode 替换的节点
     */
    private void transplant(Node root,Node deleteNode,Node replaceNode){

        if (deleteNode.getParent() == null){
            //被删除的是根节点
                this.setRoot(replaceNode);
        }else if (deleteNode == deleteNode.getParent().getLchild()){
            //将被删除的节点的父亲的左孩子设置为替换节点
            deleteNode.getParent().setLchild( replaceNode );
        }else if (deleteNode == deleteNode.getParent().getRchild()){
            //将被删除的节点的父亲的右孩子设置为替换节点
            deleteNode.getParent().setRchild(replaceNode);
        }
        //如果替换节点不为空，那么将替换节点的父亲设置为删除节点的父亲
        if (replaceNode != null){
            replaceNode.setParent(deleteNode.getParent());
        }
    }

    /**
     * 递归查找某一个元素
     * @param root 指向根节点的（引用）
     * @param k 需要查找的值
     * @return 返回找到的节点，为空则没有这个值。
     */
    public Node searchRecursion(Node root ,int k){

        //root ==null ,表示没有找到此元素，k==root.getData() 表示找到了这个元素
        if (root==null || k==root.getData()){
            if (root==null){
                System.out.println("没有找到 ：" +k);
            }else if (k==root.getData()){
                System.out.println("找到：" +k);
            }
            return root;
        }
        //递归查找，分两边查找咯。
        if (k<root.getData()){
            return searchRecursion(root.getLchild(), k);
        }else{
            return searchRecursion(root.getRchild(),k);
        }
    }
    /**
     * 循环查找某一个元素
     * @param root 指向根节点的（引用）
     * @param k 需要查找的值
     * @return 返回找到的节点，为空则没有这个值。
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
            System.out.println("没有找到 ：" +k);
        }else if (k==root.getData()){
            System.out.println("找到：" +k);
        }
        return root;
    }

    /**
     * 递归求最小值
     * @param root 指向根节点的（引用）
     * @return 找到的最小值对象
     */
    public Node minResursive(Node root){

        if (root.getLchild()==null){
            System.out.println("最小值：" +root.getData());
            return root;
        }else {
            return minResursive(root.getLchild());
        }
    }

    /**
     * 循环求最小值
     * @param root 指向根节点的（引用）
     * @return 找到的最小值对象
     */
    public Node minCirculation(Node root){

        while (root.getLchild() != null){
            root = root.getLchild();
        }
        System.out.println("最小值：" +root.getData());
        return root;
    }

    /**
     * 递归求最小值
     * @param root 指向根节点的（引用）
     * @return 找到的最小值对象
     */
    public Node maxResursive(Node root){

        if (root.getRchild()==null){
            System.out.println("最大值：" +root.getData());
            return root;
        }else {
            return maxResursive(root.getRchild());
        }
    }

    /**
     * 循环求最小值
     * @param root 指向根节点的（引用）
     * @return 找到的最小值对象
     */
    public Node maxCirculation(Node root){

        while (root.getRchild() != null){
            root = root.getRchild();
        }
        System.out.println("最大值：" +root.getData());
        return root;
    }

    /**
     * 查找前驱，按关键字查找，先找到这个关键字，得到这个关键字对应的节点对象，然后再分析
     * 前驱分为两种情况，
     * 1、如果节点node 的左子树非空，那么node的前驱恰好是node左子树中的最大节点
     * 2、如果节点node的左子树为空，那么后继就是node的最底层祖先，并且后继的左孩子也是node的祖先。
     * @param k 关键字，这里最好使用node节点作为需要查找的节点，因为多个节点可能由相同的key值
     * @return 查找到的前驱节点
     */

    public Node predecessor(int k){
        Node node = searchRecursion(this.root,k);
        if (node==null){
            System.out.println("没有 " + k + " 这个元素");
            return null;
        }
        if (minResursive(this.root)==node){
            System.out.println(k + " 是最小的元素，没有前驱");
        }
        //针对第一种情况
        if (node.getLchild() !=null){
            Node preNode = minCirculation(node.getLchild());
            System.out.println(k+" 的前驱是：" +preNode.getData());
            return preNode;
        }
        //零时temp节点
        Node temp = node.getParent();
        //往上查找node节点的前驱值,直到需要查找的节点的父节点，不是temp节点的左孩子
        while (temp != null &&  node == temp.getLchild()){
            node = temp;
            temp = temp.getParent();
        }
        if (temp!= null){
            System.out.println(k+" 的前驱是：" +temp.getData());
        }

        return temp;

    }
    /**
     * 查找后继，按关键字查找，先找到这个关键字，得到这个关键字对应的节点对象，然后再分析
     * 后继分为两种情况，
     * 1、如果节点node 的右子树非空，那么node的后继恰好是node右子树中的最小节点
     * 2、如果节点node的右子树为空，那么后继就是node的最底层祖先，并且后继的左孩子也是node的祖先。
     * @param k 关键字
     * @return 查找到的后继节点
     */
    public Node succeror(int k){
        Node node = searchRecursion(this.root,k);

        if (node==null){
            System.out.println("没有 "+k+" 这个元素");
            return null;
        }
        if (maxResursive(this.root)==node){
            System.out.println(k+" 是最大的元素，没有后继");
        }
        //针对第一种情况
        if (node.getRchild() !=null){
            Node postNode = maxResursive(node.getRchild());
            System.out.println(k+" 的后继是：" +postNode.getData());
            return postNode;
        }
        //零时temp节点
        Node temp = node.getParent();
        //往上查找node节点的后继值,直到需要查找的节点的父节点，不是temp节点的右孩子
        while (temp != null &&  node == temp.getRchild()){

            node = temp;
            temp = temp.getParent();
        }
        if (temp!= null){
            System.out.println(k+" 的后继是：" +temp.getData());
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
 * 节点类
 */
class Node{
    //左孩子，右孩子，父亲节点，和 key 数据，当然这里的key可以是任何对象，也可以带卫星数据
    private Node lchild;
    private Node rchild;
    private Node parent;

    private int data;

    /**
     * 添加节点的方法，每个节点根据自身 data 值，来判断是否将当前数据添加到自身的孩子节点。
     * @param newNode 需要添加的节点
     */
    public void addNode(Node newNode) {

        if (this.getData() > newNode.getData()){
            //插入到此节点的左边
            if (this.getLchild()!=null){
                this.getLchild().addNode(newNode);
            }else {
                //开始插入
                newNode.setParent(this);
                this.setLchild(newNode);
                System.out.println("插入节点：" +newNode.getData());
            }
        }else {
            //插入到此节点的右边
            if (this.getRchild()!=null){
                this.getRchild().addNode(newNode);
            }else{
                newNode.setParent(this);
                this.setRchild(newNode);
                System.out.println("插入节点：" + newNode.getData());
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

