package com.dsa.practice;

public class DSATest {

	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 5};
		int[] arr2 = new int[]{2, 6};
		int[] arr3 = new int[]{3, 7};
		int[] arr4 = new int[]{4, 8};

		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int c5 = 0;

		int arr5[] = new int[arr1.length + arr2.length + arr3.length
				+ arr4.length];

		System.out.println(arr5.length);

		// while (c1 < arr1.length && c2 < arr2.length && c3 < arr3.length
		// && c4 < arr4.length && c5 < arr5.length) {
		//
		//
		//
		// }

		while (c5 < arr5.length) {
			if (arr1[c1] < arr2[c2] && arr1[c1] < arr3[c3]
					&& arr1[c1] < arr4[c4]) {
				arr5[c5] = arr1[c1];
				c5++;
				c1++;
			}
			if (arr2[c2] < arr1[c1] && arr2[c2] < arr3[c3]
					&& arr2[c2] < arr4[c4]) {
				arr5[c5] = arr2[c2];
				c5++;
				c2++;
			}

			if (arr3[c3] < arr1[c1] && arr3[c3] < arr2[c2]
					&& arr3[c3] < arr4[c4]) {
				arr5[c5] = arr3[c3];
				c5++;
				c3++;
			}
			if (arr4[c4] < arr1[c1] && arr4[c4] < arr2[c2]
					&& arr4[c4] < arr3[c3]) {
				arr5[c5] = arr4[c4];
				c5++;
				c4++;
			}
		}

		for (int element : arr5) {
			System.out.println(element);
		}

	}

}
