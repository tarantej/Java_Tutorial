// Run java Hello (the class name on console)

// JVM - Java Virtual MAchine
// JRE - Java Runtime Environment - contains the JVM with additional libraries
// JDK - Java Development Kit - Installed on the machine to enable Java code development
// WORA - Write once run anywhere
// Variable - Where you store your values of your data
// Variable types - String, Int
// Always first compile using javac file.java and then run with java filename
// while we can use the print function like System.out.print, the line System.out.println prints the output in the next line

// Data Types 

// Lot of in built data

// Primitive Data Types - Simple, Basic to use

// Data Type Categories - 

/*
    Integer - byte, short, int, long 
    Float - double, flat
    Character -  char
    Boolean - True, False

    each type has its own size

//		Integer Types
    int - 4 bytes
    long - 8 bytes
    short - 2 bytes
    Byte - 1 byte (8 bits) 
    
    Integer Range : -128 to 127
    
    Float - 4 bytes
    Double - 8 bytes 
    
    Char - 2 bytes  
*/

// Type Conversion and Casting

/*
										byte b;
												int a;

b=a will not work as we cannot assign a value of a byte to integer

a = b will work since integer has a much larger range of value than b. This is also called implicit conversion

*/

// How to convert int value to byte (Typecasting)

/*

//		Casting is explicit conversion of variable data type

//		b=(byte)a;

//		you cannot do type casting for a character or boolean type value

*/

// Converting a float value to integer

//		float f  = 5.6f;  //				We add f at the end otherwise the system assumes it is a double data type value by default

//		int x = (int)f;

// Java if else statement Test

/*
    Java Conditionals: Evaluate Student Result with If-Else and Grading Logic

Student Performance Evaluation Using If-Else in Java

Write a Java program to evaluate a student's performance using if-else and else-if statements.

You are given the following:

    An integer variable score = 75

    A character variable grade = 'B'

Your task is to:

    Use if-else to check if the student passed or failed.

        A score of 50 or above is considered a pass.

        Print "Passed" or "Failed" accordingly.

    Use else-if conditions to assign and print a grade based on the score:

        A for 90 and above

        B for 75 to 89

        C for 60 to 74

        D for below 60

    Use System.out.println() to clearly display the output.

Instructions:

    The variables score and grade are already declared for you.

    Use if-else to evaluate pass/fail status.

    Use else-if to assign and print the grade based on the score.

    Ensure the output formatting matches the example output.

    Do not use ternary or switch statements in this exercise.


Expected Output:

  Passed

  Grade:  B
*/

// Output

/*

    public class Exercise {
   public static void main(String[] args) {
       
        int score = 75;
        char grade = 'B';
        
        // Passed or Failed
        
       if(score>=50)
       {
           System.out.println("Passed");
       }
       else
       {
           System.out.println("Failed");
       }
       
        // Grading
        
        if(score>=90)
        {
            System.out.println("Grade: A");
        }
        else if(score>=75 && score<=89)
        {
            System.out.println("Grade: B");
        }
        else if(score>=60 && score<=74)
        {
            System.out.println("Grade: C");
        }
        else
        {
            System.out.println("Grade: D");
        }
       
   }
}

 */

