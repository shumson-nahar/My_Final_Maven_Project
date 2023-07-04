package program;

public class EvenNumber {
	public static void main(String[] args) {
	//Java program for printing the even numbers between1 and 100 using for loop?	
		
		
    int n = 100;
	System.out.print("Even Numbers from 1 to "+n+" are: ");
	for (int i = 1; i <= n; i++) {
	   //if number%2 == 0 it means its an even number
	   if (i % 2 == 0) {
		System.out.print(i + " , ");
	   }
	}
   }
}