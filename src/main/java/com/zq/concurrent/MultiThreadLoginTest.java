package com.zq.concurrent;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/7
 * Time: 21:02
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class MultiThreadLoginTest {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Alogin a = new Alogin();
            a.start();
            Blogin b = new Blogin();
            b.start();
        }
    }

}


class LoginServlet {
    private static String username;
    private static String password;

    public static void doPost(String username, String password) {
        try {
            username = username;
            if (username.equals("a")) {
                Thread.sleep(1000);
            }
            password = password;
            System.out.println("username =" + username + " password =" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Alogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}

class Blogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
