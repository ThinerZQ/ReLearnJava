package com.zq.concurrent.communication;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/12
 * Time: 14:32
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class WaitNotifyInsertTest {
    public static void main(String[] args) {

        class BackupA extends Thread{
            private DBTools dbTools ;

            public BackupA(DBTools dbTools) {
                this.dbTools = dbTools;
            }

            @Override
            public void run() {
                dbTools.backupA();
            }
        }

        class BackupB extends Thread {
            private DBTools dbTools ;

            public BackupB(DBTools dbTools) {
                this.dbTools = dbTools;
            }

            @Override
            public void run() {
                dbTools.backupB();
            }
        }

        DBTools dbTools = new DBTools();

        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            backupA.start();
            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }


    private static class DBTools{
        volatile private boolean prevISA= false;
        synchronized public void backupA(){
            try {
                while (prevISA ==true){
                    wait();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("*****");
                }
                prevISA = true;
                notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        synchronized public void backupB(){
            try {
                while (prevISA == false){
                    wait();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("-----");
                }
                prevISA=false;
                notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
