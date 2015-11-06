package com.zq.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/10/28.
 */
public class CompositePattern {
    public static void main(String[] args) {

        //�����ļ���
        Component root = new Folder("D:\\");
        Component myPicture = new Folder("�ҵ���Ƭ");
        Component myDocument = new Folder("�ҵ��ĵ�");
        Component myVideo = new Folder("�ҵ���Ƶ");
        Component mySoftware = new Folder("�ҵ����");

        Component studyVideo = new Folder("ѧϰ��Ƶ");
        Component entertainmentVideo = new Folder("������Ƶ");
        Component adultVideo = new Folder("adult��Ƶ");

        //�����ļ�
        Component androidVideo1 = new File("android1.avi");
        Component androidVideo2 = new File("android2.avi");
        Component androidVideo3 = new File("android3.avi");
        Component androidVideo4 = new File("android4.avi");
        Component phpvideo = new File("php.avi");
        Component javavideo = new File("java.avi");

        //���ļ��к��ļ���ӵ���Ӧ��λ��
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

        //�����ļ���
        root.copy();


    }
}

//�ļ����ļ��й��еĲ������ӿ�
interface Component {
    void add(Component component);

    void delete(Component component);

    void updateName(String name);

    void copy();
}

//�ļ�����
class Folder implements Component {

    //�����ļ�������Ķ���
    private List<Component> list;

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

    public Folder(String folderName) {
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

    //�������ļ��е�ʱ�������ļ����������������һ�𿽱�����Ȼ����������������Ե���϶�����ɾ�����
    @Override
    public void copy() {
        System.out.println("�����ļ��У�" + getFolderName());
        for (Component component : getList()) {
            component.copy();
        }
    }
}

//�ļ���
class File implements Component {

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

    //�ļ���������
    @Override
    public void copy() {
        System.out.println("�����ļ��� " + getFileName());
    }
}


