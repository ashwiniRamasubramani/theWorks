package com.ashu.tutorials;

public class ArithmeticOperators {

	public static void main(String[] args) {
		double myDouble = 20d;
		double mySecondDouble=80d;
		
		double myResult = (myDouble+mySecondDouble)*25;
		System.out.println("The total was : " + myResult);
		
		double myRemainder =myResult%40;
		
		if(myRemainder <= 20)
			System.out.println("The total was below the limit : " + myRemainder);
			
			
	}

}
