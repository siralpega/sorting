package com.github.siralpega.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Insertion 
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
		
		System.out.println("Aleksandr Gallagher, CS242, April 9th 2019");
		System.out.println("Original Array:");
		print(numbers);
		System.out.println("Sorted Array:");
		insertion();
	//	classVersion();
	}
	
	public static void insertion()
	{ //need to use linkedlist?
		LinkedList<Integer> list = new LinkedList<Integer>();
		int temp, j;
		list.add(numbers[0]);
		for(int i = 1; i < n; i++)
		{
			temp = numbers[i];
			j = i - 1;
			while(j > -1 && temp < list.get(j))
			{
				j--;
			}
			list.add(j + 1, temp);
		}
		print(list.stream().mapToInt(i->i).toArray());
	}
	
	public static void classVersion()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(numbers[0]);
		for(int i = 1; i < n; i++)
		{
			int index = 0, val = numbers[i];
			while(index < list.size())
			{
				if(list.get(index) < val)
					index++;
				else
				{
					list.add(index, val);
					break;
				}
			}
		}
		for(int j = 0; j < list.size(); j++)
		{
			if(j % 10 == 0)
				System.out.println();
			System.out.print(list.get(j) + " ");
			
		}
		
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
