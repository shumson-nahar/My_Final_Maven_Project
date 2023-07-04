package program;

public class FactorialExample {
	public static void main(String args[]){ //Write a Java program to find the factorial of a number using recursion. 
		  int i,fact=1;  
		  int number=5;//It is the number to calculate factorial    
		  for(i=1;i<=number;i++){    
		      fact=fact*i;    
		  }    
		  System.out.println("Factorial of "+number+" is: "+fact);    
		 }  
		}  


