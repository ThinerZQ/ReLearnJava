package com.zq.designpattern.command;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/10/24.
 */
public class TVExample {
}
//���ӱ�ʾ��������
class TV{
    private int currentChannel=0,lastChannel=0;
    public void turnon(){
        System.out.println("TV ON " + currentChannel);
    }
    public void turnoff(){
        System.out.println("TV OFF");
        lastChannel=currentChannel;
        currentChannel=0;
    }
    public void turnChanle(int to){
        System.out.println("change channel from  "+currentChannel+" to "+ to);
        lastChannel=currentChannel ;
        currentChannel = to;
    }
    public void undo(){
        turnChanle(lastChannel);
    }
}
//����������࣬��ͬ�������ط�˵��Command�ӿ� , �о�����дһ��Commad�ӿ�ֻ����execute������Ȼ����TVCommandʵ����������Ȥ�Ŀ�������
abstract class TVCommand{
    protected TV tv;
    public abstract void execute();
}
//һ�¶��Ǿ����������
class TurnOnConcreteTVcommand extends TVCommand{

    @Override
    public void execute() {
        tv.turnon();
    }
    public TurnOnConcreteTVcommand(TV tv){
        this.tv = tv;
    }
}
class TurnOffConcreteTVcommand extends TVCommand{

    @Override
    public void execute() {
        tv.turnoff();
    }
    public TurnOffConcreteTVcommand(TV tv){
        this.tv = tv;
    }
}
class TurnChannelConcreteTVcommand extends TVCommand{

    protected int tochannel;
    @Override
    public void execute() {
        tv.turnChanle(tochannel);
    }
    public void setTochannel(int tochannel) {
        this.tochannel = tochannel;
    }
    public TurnChannelConcreteTVcommand(TV tv){
        this.tv = tv;
    }
}
class UndoConcreteTVcommand extends TVCommand{

    @Override
    public void execute() {
        tv.undo();
    }
    public UndoConcreteTVcommand(TV tv){
        this.tv = tv;
    }
}
// ң����  �����ߣ����û������Ľӿ�
class ControlPanel{
    private ArrayList<TVCommand>  commandArryList = new ArrayList<>();

    public void turnon(){
        boolean flag= false;
        for (TVCommand command :commandArryList){
            if (command instanceof TurnOnConcreteTVcommand){
                command.execute();
                flag=true;
                break;
            }
        }
        if (!flag){
            alert();
        }
    }
    public void turnoff(){
        boolean flag= false;
        for (TVCommand command :commandArryList){
            if (command instanceof TurnOffConcreteTVcommand){
                command.execute();
                flag=true;
                break;
            }
        }
        if (!flag){
            alert();
        }
    }
    public void turnChannel(int to){
        boolean flag= false;
        for (TVCommand command :commandArryList){
            if (command instanceof TurnChannelConcreteTVcommand){
                TurnChannelConcreteTVcommand turnChannelConcreteTVcommand = (TurnChannelConcreteTVcommand) command;
                turnChannelConcreteTVcommand.setTochannel(to);
                turnChannelConcreteTVcommand.execute();
                flag=true;
                break;
            }
        }
        if (!flag){
            alert();
        }

    }
    public void undo(){
        boolean flag =false;
        for (TVCommand command :commandArryList){
            if (command instanceof UndoConcreteTVcommand){
                command.execute();
                flag=true;
                break;
            }
        }
        if (!flag){
            alert();
        }
    }
    public void addCommand(TVCommand command){
        commandArryList.add(command);
    }
    private void alert(){
        System.out.println("��ң�ذ岻֧�ִ˹���");

    }
}

class Client1{
    public static void main(String[] args) {
        //����
        TV tv = new TV();
        //���������
        TVCommand onCommand = new TurnOnConcreteTVcommand(tv);
        TVCommand offCommand = new TurnOffConcreteTVcommand(tv);
        TVCommand turnChannelCommand = new TurnChannelConcreteTVcommand(tv);
        TVCommand undoCommand = new UndoConcreteTVcommand(tv);
        //��������뵽ң�����ϣ��൱�����е����������һ���γ���һ��ң����
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.addCommand(onCommand);
        controlPanel.addCommand(offCommand);
        controlPanel.addCommand(turnChannelCommand);
        //controlPanel.addCommand(undoCommand);
        //ֱ�ӵ��ң�����ϵİ�ť
        controlPanel.turnon();
        //����ĵ����ʱ���ѡ���л��� XX Ƶ��
        controlPanel.turnChannel(20);
        controlPanel.turnChannel(30);
        controlPanel.turnChannel(40);
        controlPanel.undo();
        controlPanel.turnoff();
        controlPanel.turnon();


    }
}