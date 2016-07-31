package com.zq.trys;

public class NonRuleArray {

	public static void main(String[] args) {
		
		int[][] a = new int[10][];
		
		for(int i=0;i<a.length;i++){
			a[i]=new int[i+1];
		}
		
		
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				a[i][j]=i*j;
			}
		}
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}

	}

}
