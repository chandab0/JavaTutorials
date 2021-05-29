
/****************************************************************
Given an array arr of n integers where n>1, return an 			*
array output such that output[i] is equal to the product 		*
of all the elements of arr except arr[i].						*
																*
Test case:														*
input=[1, 2, 3, 4] output =[24, 12, 8, 6]						*
input= [-2, 10, -4] output =[-40, 8, -20]						*
																*
*****************************************************************/
package main.array;


public class FindProductExceptSelf {
	public static int[] withoutDivision(int[] input) {
		int[] left = new int[input.length];
		int[] right = new int[input.length];
		int[] product = new int[input.length];
		left[0] = 1;
		for (int i = 1; i < input.length; i++) {
			left[i] = left[i - 1] * input[i - 1];
		}

		right[input.length - 1] = 1;
		for (int j = input.length - 2; j >= 0; j--) {
			right[j] = right[j + 1] * input[j + 1];
		}

		for (int k = 0; k < input.length; k++) {
			product[k] = left[k] * right[k];
		}

		return product;
	}
	
	public static int[] withBruteForce(int[] input) {
		int[] product = new int[input.length];
		for(int i=0; i<input.length; i++) {
			int prod = 1;
			for(int j=0; j<input.length; j++) {
				if(j!=i)
					prod=prod * input[j];
			}
			product[i]=prod;
		}
		return product;
	}
	
	public static int[] withDivision(int[] input) {
		int[] product = new int[input.length];
		int prod = 1;
		for(int i=0; i<input.length; i++) {
			prod *= input[i];
		}
		for(int i=0; i<input.length; i++) {
			product[i] = prod/input[i];
		}
		return product;
	}

}