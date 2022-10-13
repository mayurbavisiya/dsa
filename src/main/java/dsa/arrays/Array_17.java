package dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array_17 {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 }, arr2 = { 0, 2, 6, 8, 9 };
		// merge(arr1, arr2, arr1.length, arr2.length);
		int[] arr = { 87, 78, 16, 94 };
		threeWayPartition(arr, 36, 72);
	}

	public static void threeWayPartition(int arr[], int a, int b) {
		int  n = arr.length;
        
        // Initialize ext available positions for
        // smaller (than range) and greater elements
        int start = 0, end = n-1;
         
         // Traverse elements from left
        for(int i = 0; i <= end;)
        {
             
            // If current element is smaller than
            // range, put it on next available smaller
            // position.
             
            if(arr[i] < a)
            {
                 
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
                 
            }
             
            // If current element is greater than
            // range, put it on next available greater
            // position.
            else if(arr[i] > b)
            {
                 
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
                  
            }
             
            else
               i++;
        }
         System.out.println(Arrays.toString(arr));
	}

	static Boolean subArrayExists(int arr[]) {
		// Creates an empty hashset hs
		Set<Integer> hs = new HashSet<Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || hs.contains(sum))
				return true;

			// Add sum to hash set
			hs.add(sum);
		}

		// We reach here only when there is
		// no subarray with 0 sum
		return false;
	}

	public static void merge(int arr1[], int arr2[], int m, int n) {
		// code here

		int i = m - 1, j = 0;
		while (i >= 0 && j < n) {
			if (arr1[i] > arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
			}
			i--;
			j++;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);

	}
}
