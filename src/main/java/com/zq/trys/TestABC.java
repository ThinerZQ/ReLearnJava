package com.zq.trys;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/4
 * Time: 14:22
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
class C {
    C() {
        System.out.print("C");
    }
}

class AD {
    C c = new C();

    AD() {
        this("AD");
        System.out.print("AD");
    }

    AD(String s) {
        System.out.print(s);
    }
}

class TestABC extends AD {
    TestABC() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new TestABC();
    }
}