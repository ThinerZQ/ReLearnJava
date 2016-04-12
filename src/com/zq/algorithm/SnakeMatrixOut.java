package com.zq.algorithm;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/4/10
 * Time: 19:45
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class SnakeMatrixOut {

    public static void main(String[] args) {



        int n = 10;
        int x = 0, y = 0;
        int a[][] = new int[n][n];
        a[x][y] = 1;
        int tol = 1;
        while (tol < n * n) {
            //System.out.println(tol);
            while (y + 1 < n && a[x][y + 1] == 0) a[x][++y] = ++tol;
            while (x + 1 < n && a[x + 1][y] == 0) a[++x][y] = ++tol;
            while (y - 1 >= 0 && a[x][y - 1] == 0) a[x][--y] = ++tol;
            while (x - 1 >= 0 && a[x - 1][y] == 0) a[--x][y] = ++tol;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.printf("\n");
        }
    }
}