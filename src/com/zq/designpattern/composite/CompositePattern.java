package com.zq.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/10/28.
 */
public class CompositePattern {
    public static void main(String[] args) {

        //创建文件夹
        Component root  = new Folder("D:\\");
        Component myPicture = new Folder("我的照片");
        Component myDocument = new Folder("我的文档");
        Component myVideo = new Folder("我的视频");
        Component mySoftware = new Folder("我的软件");

        Component studyVideo = new Folder("学习视频");
        Component entertainmentVideo = new Folder("娱乐视频");
        Component adultVideo = new Folder("adult视频");

        //创建文件
        Component androidVideo1 = new File("android1.avi");
        Component androidVideo2 = new File("android2.avi");
        Component androidVideo3 = new File("android3.avi");
        Component androidVideo4 = new File("android4.avi");
        Component phpvideo = new File("php.avi");
        Component javavideo = new File("java.avi");

        //把文件夹和文件添加到相应的位置
        root.add(myDocument);
        root.add(myPicture);
        root.add(myVideo);
        root.add(mySoftware);

        myVideo.add(studyVideo);
        myVideo.add(entertainmentVideo);
        myVideo.add(adultVideo);

        studyVideo.add(androidVideo1);
        studyVideo.add(androidVideo2);
        studyVideo.add(androidVideo3);
        studyVideo.add(androidVideo4);
        studyVideo.add(phpvideo);
        studyVideo.add(javavideo);

        root.delete(myDocument);
        root.updateName("F:\\");

        //拷贝文件夹
        root.copy();





    }
}

//文件和文件夹共有的操作，接口
interface Component{
    void add(Component component);
    void delete(Component component);
    void updateName(String name);
    void copy();
}
//文件夹类
class Folder implements Component{

    //保存文件夹里面的东西
    private List<Component> list ;

    private String folderName;

    public List<Component> getList() {
        return list;
    }

    public void setList(List<Component> list) {
        this.list = list;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Folder(String folderName){
        setFolderName(folderName);
        setList(new ArrayList<Component>());
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void delete(Component component) {
        list.remove(component);
    }

    @Override
    public void updateName(String name) {
        setFolderName(name);
    }

    //当拷贝文件夹的时候，连带文件夹里面的所有内容一起拷贝，当然这个工作，交给各自的组合对象完成就行了
    @Override
    public void copy() {
        System.out.println("复制文件夹："  +getFolderName());
        for (Component component :getList()){
            component.copy();
        }
    }
}
//文件类
class File implements Component{

    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void delete(Component component) {

    }

    @Override
    public void updateName(String name) {
        setFileName(name);
    }
    //文件拷贝工作
    @Override
    public void copy() {
        System.out.println("复制文件： "+getFileName());
    }
}


