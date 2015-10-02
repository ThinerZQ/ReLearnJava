package com.zq.innerclass;

/**
 * Created by zhengshouzi on 2015/9/29.
 */
public class TestParcel {

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();


        Contents c = p.contents();
        Destination d = p.destination("Tasmain");
        System.out.println(c.value());
        System.out.println(d.readLabel());


    }
}
