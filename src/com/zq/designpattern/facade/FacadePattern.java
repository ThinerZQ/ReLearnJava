package com.zq.designpattern.facade;

/**
 * Created by zhengshouzi on 2015/10/29.
 */

//����Ա
class Waiter {
    //����Ա�Ӷ�֪���Ƶ��ڲ�����Щ����
    private KitchenService kitchenService;
    private BookRoomService bookRoomService;
    private DrinkService drinkService;
    private PayService payService;

    public Waiter() {
        this.kitchenService = new KitchenService();
        this.bookRoomService = new BookRoomService();
        this.drinkService = new DrinkService();
        this.payService = new PayService();
    }

    //��Щ���Ǹ�����Ա�µ�������ھ�����ôִ�У���������Ա�ͺ���
    public void takeOrderAndBookRoom(String[] foodnames, String roomType) {
        kitchenService.cook(foodnames);
        bookRoomService.book(roomType);
    }

    public void takingOrder(String[] foodnames, String[] drinknames) {
        kitchenService.cook(foodnames);
        drinkService.taskDrink(drinknames);
    }

    public void takeDrink(String[] drinknames) {
        drinkService.taskDrink(drinknames);
    }

    public void bookRoom(String roomType) {
        bookRoomService.book(roomType);

    }

    public void pay() {
        payService.pay();
    }

}

//�������ŵĳ�������
class KitchenService {
    public void cook(String[] foodnames) {
        for (String foodname : foodnames) {
            System.out.println("�������������� ��" + foodname);
        }

    }
}

//�������ŵĲ�ˮ����
class DrinkService {
    public void taskDrink(String[] drinknames) {
        for (String drinkname : drinknames) {
            System.out.println("����������ˮ��׼�� ��" + drinkname + " ");
        }
    }
}

//�ͷ����ŵĶ�������
class BookRoomService {
    public void book(String roomType) {
        System.out.println("�ͷ�����Ԥ������ ����Ϊ��" + roomType);
    }
}

//����̨����������
class PayService {
    public void pay() {
        System.out.println("����̨������");
    }
}

public class FacadePattern {
    public static void main(String[] args) {

        //ӭ������һ������Ա
        Waiter waiter = new Waiter();

        String[] foods = {"�����Ź�", "�����Ｆ", "�����ļ���"};
        String[] drinks = {"ơ��", "Ҭ֭"};
        //�µ�
        waiter.takingOrder(foods, drinks);
        //��ʱ��������һ������
        waiter.takeDrink(new String[]{"��β��"});
        //�Ա������ˣ�׼����һ������
        waiter.bookRoom("�󴲷�");
        //��ʼ����
        waiter.pay();
    }
}
