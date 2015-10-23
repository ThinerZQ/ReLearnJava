package com.zq.designpattern.mediator;

/**
 * Created by zhengshouzi on 2015/10/22.
 */
abstract class AbstractMediator{
    AbstractColleague1 colleague1A ;
    AbstractColleague1 colleague1B;
    protected AbstractMediator(AbstractColleague1 colleague11,AbstractColleague1 colleague12){
        this.colleague1A =colleague11;
        this.colleague1B = colleague12;
    }
    public abstract   void aInfluenceB();
    public abstract   void bInfluenceA();

}
public class Mediator extends AbstractMediator{

    protected Mediator(AbstractColleague1 colleague11, AbstractColleague1 colleague12) {
        super(colleague11, colleague12);
    }

    @Override
    public void aInfluenceB() {
        colleague1B.setNumber(colleague1A.getNumber()*100);
    }

    @Override
    public void bInfluenceA() {
        colleague1A.setNumber(colleague1B.getNumber()/20);
    }


}
abstract class AbstractColleague{
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected  int number;

    public abstract void setNumber(int number,AbstractColleague colleague);

    @Override
    public String toString() {
        return "AbstractColleague{" +
                "number=" + number +
                '}';
    }
}

class ColleagueA extends AbstractColleague{
    @Override
    public void setNumber(int number, AbstractColleague colleague) {
        this.setNumber(number);
        colleague.setNumber(number*100);
    }
}


class ColleagueB extends AbstractColleague{
    @Override
    public void setNumber(int number, AbstractColleague colleague) {
        this.setNumber(number);
        colleague.setNumber(number/100);
    }
}

class Client{
    public static void main(String[] args) {
        //未使用中介者模式，耦合太强
        AbstractColleague colleagueA = new ColleagueA();
        AbstractColleague colleagueB = new ColleagueB();

        colleagueA.setNumber(20,colleagueB);

        System.out.println(colleagueA.toString());
        System.out.println(colleagueB.toString());

        colleagueB.setNumber(456, colleagueA);

        System.out.println(colleagueA.toString());
        System.out.println(colleagueB.toString());
        //开始使用中介者模式

        AbstractColleague1 colleague1A = new Colleague11();
        AbstractColleague1 colleague1B = new Colleague12();

        Mediator mediator = new Mediator(colleague1A,colleague1B);

        colleague1A.setNumber(20,mediator);
        System.out.println(colleague1A.toString());
        System.out.println(colleague1B.toString());

        colleague1B.setNumber(432, mediator);
        System.out.println(colleague1A.toString());
        System.out.println(colleague1B.toString());




    }
}
abstract class AbstractColleague1{
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    protected  int number;

    public abstract void setNumber(int number,Mediator mediator);

    @Override
    public String toString() {
        return "AbstractColleague{" +
                "number=" + number +
                '}';
    }
}
class Colleague11 extends AbstractColleague1{

    @Override
    public void setNumber(int number, Mediator mediator) {
        setNumber(number);
        mediator.aInfluenceB();
    }
}
class Colleague12 extends AbstractColleague1{

    @Override
    public void setNumber(int number, Mediator mediator) {
        setNumber(number);
        mediator.bInfluenceA();
    }
}



