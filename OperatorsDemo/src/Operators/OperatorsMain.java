package Operators;

import java.util.Scanner;

public class OperatorsMain {
	
	public void m1(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={10,12,30};
		//System.out.println(a);
		
		int arr[]=new int[3];
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter 3 Array Elements:");
		for (int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
