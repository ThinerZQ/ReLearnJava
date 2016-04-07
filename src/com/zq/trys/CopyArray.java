package com.zq.trys;

public class CopyArray {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int[] b = a;
		
		a[2]=66;
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}

	}

}
