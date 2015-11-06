package com.zq.designpattern.dutychain;

/**
 * Created by zhengshouzi on 2015/10/24.
 */
public class DutyChain {
    public static void main(String[] args) {
        Request request = new Request(new Level(7));
        ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
        ConcreteHandler3 concreteHandler3 = new ConcreteHandler3();
        ConcreteHandler4 concreteHandler4 = new ConcreteHandler4();
        concreteHandler1.setNextHandler(concreteHandler2);
        concreteHandler2.setNextHandler(concreteHandler3);
        concreteHandler3.setNextHandler(concreteHandler4);
        concreteHandler1.handleRequest(request);
    }
}

class Level {
    private int level = 0;

    public Level(int level) {
        this.level = level;
    }

    public boolean above(Level level) {
        if (this.level >= level.level) {
            return true;
        }
        return false;
    }
}

class Request {
    Level level;

    public Request(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}

class Response {

}

abstract class Handler {
    private Handler nextHandler;

    public final Response handleRequest(Request request) {
        Response response = null;
        //判断这个请求的优先级是不是比我能处理的请求的优先级大
        if (this.getHandlerLevel().above(request.level)) {
            response = response(request);
        } else {
            if (this.nextHandler != null) {
                this.nextHandler.handleRequest(request);
            } else {
                System.out.println("没有合适的处理器--");
            }
        }
        return response;
    }

    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    protected abstract Response response(Request request);

    protected abstract Level getHandlerLevel();
}

class ConcreteHandler1 extends Handler {

    @Override
    protected Response response(Request request) {
        System.out.println("ConcreteHandler1 处理");
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return new Level(1);
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    protected Response response(Request request) {
        System.out.println("ConcreteHandler2 处理");
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return new Level(4);
    }
}

class ConcreteHandler3 extends Handler {

    @Override
    protected Response response(Request request) {
        System.out.println("ConcreteHandler3 处理");
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return new Level(7);
    }
}

class ConcreteHandler4 extends Handler {
    @Override
    protected Response response(Request request) {
        System.out.println("ConcreteHandler4 处理");
        return null;
    }

    @Override
    protected Level getHandlerLevel() {
        return new Level(9);
    }
}