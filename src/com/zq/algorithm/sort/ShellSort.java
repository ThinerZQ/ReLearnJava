package com.zq.algorithm.sort;

/**
 * Created by zhengshouzi on 2015/11/1.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {57,68,59,52,72,28,96,33,24,19};
        shellSort(a);
    }
    public static  void shellSort(int[] a){
        int d =a.length/2;
        int count=0;
        while (d>=1){
            for (int i = d; i <a.length ; i++) {
                //交换
                if (a[i]<a[i-d]){
                    //记住需要插入的值
                    int j = i-d;
                    int temp = a[i];
                    //往前找插入位置
                    //“j>=0”表示最后插入位置在第一个位置时候不再循环，“temp<a[j]”第一次循环肯定要进入，接着不断改变j的值，判断待插入的值与之前的每一个值那个大，并把比较的值向后移动d位,直到找到插入位置。
                    while (j>=0&&temp<a[j]){
                        a[j+d] = a[j];
                        j-=d;//j的变化速度应该和增量一样，因为每一插入都是正对子序列插入排序
                        count++;
                    }
                    //插入
                    a[j+d]=temp;
                }
            }
            System.out.print("排序 ：");
            for (int i = 0; i <a.length ; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
            d=d/2;
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
        System.out.println(count);
    }
}
