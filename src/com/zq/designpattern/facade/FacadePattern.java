package com.zq.designpattern.facade;

/**
 * Created by zhengshouzi on 2015/10/29.
 */

//服务员
class Waiter {
    //服务员坑定知道酒店内部有哪些服务
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

    //这些都是给服务员下的命令，至于具体怎么执行，交给服务员就好了
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

//餐饮部门的厨房服务
class KitchenService {
    public void cook(String[] foodnames) {
        for (String foodname : foodnames) {
            System.out.println("餐饮部：厨房做 ：" + foodname);
        }

    }
}

//餐饮部门的茶水服务
class DrinkService {
    public void taskDrink(String[] drinknames) {
        for (String drinkname : drinknames) {
            System.out.println("餐饮部：茶水间准备 ：" + drinkname + " ");
        }
    }
}

//客房部门的订房服务
class BookRoomService {
    public void book(String roomType) {
        System.out.println("客房部：预定房间 类型为：" + roomType);
    }
}

//收银台的收银服务
class PayService {
    public void pay() {
        System.out.println("收银台：结账");
    }
}

public class FacadePattern {
    public static void main(String[] args) {

        //迎面走来一个服务员
        Waiter waiter = new Waiter();

        String[] foods = {"红烧排骨", "铁板田鸡", "干煸四季豆"};
        String[] drinks = {"啤酒", "椰汁"};
        //下单
        waiter.takingOrder(foods, drinks);
        //这时候还想再来一点饮料
        waiter.takeDrink(new String[]{"鸡尾酒"});
        //吃饱喝足了，准备订一个房间
        waiter.bookRoom("大床房");
        //开始结账
        waiter.pay();
    }
}
