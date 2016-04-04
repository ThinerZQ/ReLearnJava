package com.zq.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/25
 * Time: 20:46
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class InetAddressTest {
    public static void main(String[] args) {
        if (args.length>0){
            String host = args[0];
            try {
                InetAddress[] addresses =  InetAddress.getAllByName(host);
                for (InetAddress a : addresses){
                    System.out.println(a);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }else{
            try {
                System.out.println(InetAddress.getLocalHost());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
