package org.sort;

import java.math.BigDecimal;

public class FastSort {
	public static void main(String[] args) {
		int[] a = { 12, 2, 1, 34, 122, 42 };
		int start = 0;
		int end = a.length - 1;
		sort2(a, start, end);
		selectSort1(a);
		for (int i : a) {
			System.out.println(i);
		}

		BigDecimal b = new BigDecimal(9.656);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.err.println(f1);
		System.err.println(Math.round(-11.4));
		System.err.println(Math.round(11.5));

	}

	public static void sort(int[] a, int low, int high) {
		int start = low;
		int end = high;
		int key = a[low];

		while (end > start) {
			// 从后往前比较
			while (end > start && a[end] >= key) // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
				end--;
			if (a[end] <= key) {
				int tmp = a[end];
				a[end] = a[start];
				a[start] = tmp;
			}
			// 从前往后比较
			while (end > start && a[end] <= key) // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
				start++;
			if (a[start] >= key) {
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
			}
			// 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
		}
		// 左边序列。第一个索引位置到关键值索引-1
		if (start > low)
			sort(a, low, start - 1);
		// 右边序列。从关键值索引+1到最后一个
		if (end < high)
			sort(a, end + 1, high);
	}

	public static void sort1(int a[], int low, int hight) {
		int start = low;
		int end = hight;
		int key = a[low];
		while (start < end) {
			while (start < end && a[end] >= key)
				end--;
			if (a[end] <= key) {
				int tmp = a[end];
				a[end] = a[start];
				a[start] = tmp;
			}

			while (start < end && a[end] <= key)
				start++;
			if (a[start] >= key) {
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
			}
		}
		if (start > low)
			sort1(a, low, start - 1);
		if (end < hight)
			sort1(a, end + 1, hight);
	}

	public static void sort2(int[] a, int low, int higth) {
		int start = low;
		int end = higth;
		int key = a[low];
		while (end > start) {
			while (end > start && a[end] >= key)
				end--;
			if (a[end] <= key) {
				int tmp = a[end];
				a[end] = a[start];
				a[start] = tmp;
			}
			while (end > start && a[end] <= key)
				start++;
			if (a[start] >= key) {
				int tmp = a[start];
				a[start] = a[end];
				a[end] = tmp;
			}
		}
		if (start > low)
			sort2(a, low, start - 1);
		if (end < higth)
			sort2(a, end + 1, higth);
	}

	public static void selectSort(int[] a) {
		int size = a.length, tmp;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j > i; j--) {
				if (a[j] < a[k])
					k = j;
			}
			tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;

		}
	}

	public static void selectSort1(int[] a) {
		int size = a.length, tmp;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j > i; j--) {
				if (a[j] < a[k])
					k = j;
			}
			tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
		}
	}
}
