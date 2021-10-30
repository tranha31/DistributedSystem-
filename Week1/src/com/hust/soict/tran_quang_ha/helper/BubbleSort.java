package com.hust.soict.tran_quang_ha.helper;

public class BubbleSort implements NumberSorter{

	@Override
	public void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
		{
			for(int j=0; j<n-i-j; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[i];
					arr[i] = temp;
				}
			}

			
		}
	}

}
