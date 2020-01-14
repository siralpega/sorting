package com.github.siralpega.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quick 
{
	private static int[] numbers;
	private static int n = 1000;

	public static void main(String[]args) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("inputData.txt"));
		numbers = new int[n];
		for(int i = 0 ; i < n; i++)
			numbers[i] = input.nextInt();
		input.close();

		System.out.println("Aleksandr Gallagher, CS242, April 16th 2019");
		System.out.println("Original Array:");
		print(numbers);
		System.out.println("Sorted Array:");
		quick(0, numbers.length - 1);
		print(numbers);
	}

	public static void quick(int left, int right)
	{
		int x;
		if(left < right)
		{
			x = partition(left, right);
			//divide array into two sub-arrays split by the subscript of the pivot
			quick(left, x - 1);
			quick(x + 1, right);
		}
	}

	public static int partition(int left, int right)
	{
		//left is UP, right is DOWN
		int pivot = numbers[left];
		while(left < right)
		{
			while(left < right && numbers[right] > pivot)
				right--;
			numbers[left] = numbers[right];
			while(left < right && numbers[left] <= pivot) // <= b/c pivot is numbers[left]
				left++;
			numbers[right] = numbers[left];
		}
		numbers[left] = pivot;
		//System.out.println("Pivot is " + pivot + " and was placed at numbers[" + left + "]");
		return left;
	}

	public static void print(int[] a)
	{
		int j = 0, target = 50;
		for(int i = 0; i < 20; i++)
		{
			while(j < target)
			{
				System.out.print(a[j] + " ");
				j++;
			}
			target = target + 50;
			System.out.println();
		}
		System.out.println();
	}
}
