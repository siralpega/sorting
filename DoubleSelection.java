package com.github.siralpega.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoubleSelection
{
	private static int[] numbers;
	private static int n = 1000;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("inputData.txt"));
		numbers = new int[n];
		for(int i = 0 ; i < n; i++)
			numbers[i] = input.nextInt();
		input.close();
		
		System.out.println("Aleksandr Gallagher, CS242, April 2nd 2019");
		System.out.println("Original Array:");
		print(numbers);
		doubleSelectionSort();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type a positive integer (n) < 1,000 to display the nth element in the sorted array");
		int num = keyboard.nextInt();
		if(num < 0 || num > numbers.length - 1)
			System.out.println("Error: n was < 0 or n was > " + (n - 1));
		else
			System.out.println(numbers[num]);
		
		keyboard.close();
	}
	
	public static void doubleSelectionSort()
	{
		//Step 1: Form pairwise order
		for(int i = 0; i < n/2; i++)
			if(numbers[i] > numbers[n - i - 1])
				swap(i, n - i - 1);
		
		int left = 0, right = n - 1, p, q;
		while(right - left != 1)
		{
			//Step 2: Find smallest in left side of array & largest in right side of array
			p = left; 
			q = right;
			for(int i = left + 1; i < n/2; i++)
			{
				if(numbers[i] < numbers[p])
					p = i;
				if(numbers[n - i - 1] > numbers[q])
					q = n - i - 1;
			}
			swap(p, left);
			swap(q, right);
			
			//Step 3: Fix pairwise w/ p & q
			if(numbers[p] > numbers[n - p - 1])
				swap(p, n - p - 1);
			if(numbers[q] < numbers[n - q - 1])
				swap(q, n - q - 1);
			
			left++;
			right--;
		}
		if(numbers[left] > numbers[right])
			swap(left, right);
	}
	
	public static void swap(int x, int y)
	{
		int temp = numbers[x];
		numbers[x] = numbers[y];
		numbers[y] = temp;
	}
	
	public static void print(int[] a)
	{
		//debug only
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
