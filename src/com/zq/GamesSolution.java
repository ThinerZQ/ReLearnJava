package com.zq;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 强 on 2016/1/14.
 */
public class GamesSolution {
    public static void main(String[] args) {



        int sum=31;
        int min=100;
        int[] minline=new int[15];
        while (sum>30){
            ArrayList<Integer> left =new ArrayList<>();
            left.add(6);
            left.add(1);
            left.add(3);
            left.add(12);
            left.add(8);
            ArrayList<Integer> right = new ArrayList<>();
            sum=0;
            int[] line=new int[15];
            int j=0;
            for (int i=0;i<4;i++){
                int temp1 =left.get(new Random().nextInt(left.size()));
                left.remove(Integer.valueOf(temp1));
                //System.out.println("移除一个：size="+left.size());
                int temp2 =left.get(new Random().nextInt(left.size()));
                left.remove(Integer.valueOf(temp2));
               // System.out.println("移除两个：size=" + left.size());
                right.add(temp1);
                right.add(temp2);
                int temp3=0;
                if (i!=3){
                    temp3 = right.get(new Random().nextInt(right.size()));
                    right.remove(Integer.valueOf(temp3));
                    left.add(temp3);
                }
                int temp =(temp1>temp2 ?temp1 : temp2) +temp3;
                sum+=temp;
                line[j]=temp1;
                line[j+1]=temp2;
                line[j+2]=temp3;
                j=j+3;
            }
            if (min>sum){
                min=sum;
                for (int k=0;k<line.length;k++){
                    minline[k]=line[k];
                }
            }
            for (int k=0;k<line.length;k++){
                System.out.print(line[k]+",");
            }
            System.out.print("    -------   ");
            for (int k=0;k<line.length;k++){
                System.out.print(minline[k]+",");
            }
            System.out.print("       sum="+sum+"  min="+min);
            System.out.println();
        }
    }
    public static void just(){

      /*  int sum=100;

        while (sum>30){
            int[] left = {1,12,3,6,8};
            int[] right = new int[5];
            sum=0;
            for (int i=0;i<left.length;i++){
                for (int j=0;j<left.length;j++){
                    int temp1 =left[i];
                    int temp2 = left[j];
                    right[i]
                }
                int temp3=0;
                if (i!=3){
                    temp3 = right.get(new Random().nextInt(right.size()));
                    right.remove(Integer.valueOf(temp3));
                    left.add(temp3);
                }
                int temp =temp1+temp2+temp3;
                sum+=temp;
            }
            System.out.println("sum="+sum);
        }*/
    }
}
