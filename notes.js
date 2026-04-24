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

// Type casting example

// System.out.println("\nType Casting Example");

/*
int b = 127;
int c = 12;
byte k = (byte)c;

System.out.println(k);
*/


// 	If the value being converted is beyond the range of the converted/ casting type, then it will use a modulus operator and divide the byte range (256) with the number and show the remainder as output

//	System.out.println("\nIf the value being converted is beyond the range of the converted/ casting type, then it will use a modulus operator and divide the byte range (256) with the number and show the remainder as output");


/*
int TypeCastInt = 257;
byte tcEx = (byte)TypeCastInt;
System.out.println("\nDivide the input number (TypeCastInt) with the byte range (256) and show the remainder as output: " +tcEx);
*/

// Assignment Operators

int AOnum1 = 7;
int AOnum2 = 5;

//Addition

int resultAdd = AOnum1+AOnum2;
System.out.println("\nAddition: "+ resultAdd);

//Subtraction

int resultSub = AOnum1-AOnum2;
System.out.println("\nSubtraction: "+ resultSub);

//Multiplication

int resultMul = AOnum1*AOnum2;
System.out.println("\nMultiplication: "+ resultMul);

//Division / Modulus

int resultDiv = AOnum1%AOnum2;
System.out.println("\nDivision / Modulus: "+ resultDiv);

//		Incrementing Values

//		Method 1
int incMet1 = num1+1;
System.out.println("\nIncrement Method 1 (num1+1): "+incMet1);

//Method 2 (Post Increment)
int incMet2 = num1++;
System.out.println("\nIncrement Method 2 (Post Increment(num1++)): "+incMet2);

//Method 3 (Pre Increment)
int incMet3 = ++num1;
System.out.println("\nIncrement Method 3 Pre Increment(++num1)): "+incMet3);

//		Decrementing Values
int decMet = num1--;
System.out.println("\nDecrement Method (num1--): "+decMet);

//		Why are there two different types on increment methods

//					The difference comes when we are fetching the value

int exVal = 10;

//							If we use pre increment, the increment is applied to the value before showing the result

int preInc = ++exVal; //		The incremented value should be 11

System.out.println("\nPre Increment Method (++exVal): "+preInc);

//							If we use post increment, the increment is applied to the value after the value has been fetched

int postInc = exVal++; //		The incremented value should still be 11

System.out.println("\nPost Increment Method (exVal++): "+postInc);

// Logical Operators



// Ternary Operators

/*
    int n = 5;
    int result = 0;

    We want to show the value of result based on the condition being true or false

    if the condition is true, the value of result will be 10; else it will be 20.

    We can show this using the Ternary operator

    result = n%2==0 ? 10:20

    System.out.println(result);


 */



//	Conditional Statements

//	Executing code based on set of pre-defined conditions and depending whether the pre-defined conditions match in the code during execution

//  Switch Statement

/*

int n = 7;
switch(n)
{

    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    case 6:
        System.out.println("Saturday");
        break;
    case 7:
        System.out.println("Sunday");
        break;
    default:
        System.out.println("Enter a valid number");
        break;



}


 */


// If Else

/*

int x = 28;
if(x>10 && x<=20)
{
    System.out.println("Hello");
}
else
{
    System.out.println("Bye");
}

 // If Else if

 int eifx = 8;
 int eify = 7;
 int eifz = 9;

 if(eifx>eify && eify>eifz)
 {
    System.out.println(eifx);
 }
 else if(eify>eifx && eify>eifz)
 {
    System.out.println(eify);
 }
 else
 {
    System.out.println(eifz);
 }

 */


//  For Loop

/*
		int i=1;
		for(i<5)
		{
  			System.Out.Print("For Loop: "+ i + " ");
		}
*/

/*



 */