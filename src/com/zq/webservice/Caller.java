package com.zq.webservice;

/**
 * Created by zhengshouzi on 2015/10/17.
 */
public class Caller {
    public static void main(String args[]) {

        Webservice wb = new WebserviceService().getWebservicePort();
        System.out.println(wb.toUpper("i love you"));
    }
}
