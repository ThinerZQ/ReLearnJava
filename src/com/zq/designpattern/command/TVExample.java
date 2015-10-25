package com.zq.designpattern.command;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/10/24.
 */
public class TVExample {
}
//电视表示接收者类
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
//抽象的命令类，不同于其他地方说的Command接口 , 感觉可以写一个Commad接口只包含execute方法，然后用TVCommand实现它，有兴趣的可以试试
abstract class TVCommand{
    protected TV tv;
    public abstract void execute();
}
//一下都是具体的命令类
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
// 遥控器  调用者，和用户交互的接口
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
        System.out.println("此遥控板不支持此功能");

    }
}

class Client1{
    public static void main(String[] args) {
        //电视
        TV tv = new TV();
        //具体的命令
        TVCommand onCommand = new TurnOnConcreteTVcommand(tv);
        TVCommand offCommand = new TurnOffConcreteTVcommand(tv);
        TVCommand turnChannelCommand = new TurnChannelConcreteTVcommand(tv);
        TVCommand undoCommand = new UndoConcreteTVcommand(tv);
        //将命令加入到遥控器上，相当于所有的命令组合在一起形成了一个遥控器
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.addCommand(onCommand);
        controlPanel.addCommand(offCommand);
        controlPanel.addCommand(turnChannelCommand);
        //controlPanel.addCommand(undoCommand);
        //直接点击遥控器上的按钮
        controlPanel.turnon();
        //具体的点击的时候才选择切换到 XX 频道
        controlPanel.turnChannel(20);
        controlPanel.turnChannel(30);
        controlPanel.turnChannel(40);
        controlPanel.undo();
        controlPanel.turnoff();
        controlPanel.turnon();


    }
}