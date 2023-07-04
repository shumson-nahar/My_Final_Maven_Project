package program;

import java.util.Random;

public class RandomNumber {//Write a Java program to generate a random number between 1 and 100.
	
	    public static void main(String[] args)  {
	   
	        Random randI = new Random();
	        int myRandInt = randI.nextInt(100);
	        myRandInt = myRandInt+1;
	        System.out.println("Random number between 1 and 100: "+myRandInt);
	    }
	}

	 
	


