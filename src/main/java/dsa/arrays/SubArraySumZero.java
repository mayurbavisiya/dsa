package dsa.arrays;

import java.util.HashSet;
import java.util.Set;

public class SubArraySumZero {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(findsum(arr, arr.length));
	}
	static boolean findsum(int arr[],int n)
    {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < arr.length;i++){
            hs.add(arr[i]);
        }
        int temp= 0;
        for(int i = 0;i<arr.length;i++){
            if(hs.contains(temp)){
                return true;
            }
            temp+=arr[i];

        }
        return false;
    }
}
