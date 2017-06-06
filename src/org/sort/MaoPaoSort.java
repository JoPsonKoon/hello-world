package org.sort;

public class MaoPaoSort {
	public static void main(String[] args) throws InterruptedException {
		int arr[] = { 12, 2, 1, 34, 122, 42 };
		Thread.sleep(5000);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] =tmp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
