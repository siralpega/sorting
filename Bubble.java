package com.github.siralpega.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bubble
{
	private static int[] numbers, duplicates;
	private static int n = 1000;
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("inputData.txt"));
		numbers = new int[n];
		duplicates = new int[100]; //nums in inputData are 0-99
		for(int i = 0 ; i < n; i++)
			numbers[i] = input.nextInt();
		input.close();
		
		System.out.println("Aleksandr Gallagher, CS242, April 2nd 2019");
		System.out.println("Original Array:");
		print(numbers);
		System.out.println("Sorted Array:");
		bubble();
		print(numbers);
		System.out.println("Duplicates Array:");
		findDuplicates();
	//	print(duplicates);
		
	}
	public static void bubble()
	{
		int temp, i = 1;
		boolean exit = false;
		while(i <= n - 1 && !exit) //passes
		{
			exit = true;
			for(int j = 0; j < n - i; j++)
				if(numbers[j] > numbers[j + 1])
				{
					exit = false;
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
		}
	}

	public static void findDuplicates()
	{
		for(int i = 0; i < n; i++)
			duplicates[numbers[i]]++;	
		int j = 0, target = 10;
		for(int i = 0; i < 10; i++)
		{
			while(j < target)
			{
				System.out.print(duplicates[j] + "	");
				j++;
			}
			target = target + 10;
			System.out.println();
		}
		System.out.println();
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
