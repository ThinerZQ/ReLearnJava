package com.zq.designpattern.command;

import com.sun.webpane.webkit.dom.RectImpl;

/**
 * Created by zhengshouzi on 2015/10/24.
 */
public abstract class Command {
    public abstract  void execute();
}
class ConcreteCommand extends Command{

    private Receiver receiver ;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}


class Invoker{
    Command command ;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    public void action(){
        this.command.execute();
    }
}
class Receiver{
    public void doSomething(){
        System.out.println("接收者，业务逻辑处理");
    }

}
class Client{
    public static void main(String[] args) {

        Invoker invoker = new Invoker();
        Command command = new ConcreteCommand(new Receiver());
        invoker.setCommand(command);
        invoker.action();

    }
}
