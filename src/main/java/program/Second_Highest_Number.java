package program;

import java.util.Arrays;
import java.util.Scanner;

public class Second_Highest_Number {//Write a Java program to find the second highest number in an array.
	public static void main(String[] args)
	  {
	    Scanner sc=new Scanner(System.in);

	    int n=sc.nextInt();
	    int a[]=new int[n];

	    for(int i=0;i<n;i++)
	      a[i]=sc.nextInt();

	    Arrays.sort(a);
	    System.out.print("The second highest number: "+a[n-2]);
	  }
	}



