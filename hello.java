class Hello
{
public static void main(String a[])
{
// System.out.println("Hello World");

// Adding two numbers

//System.out.println("\nAdding two numbers");


int num1 = 3;
int num2 = 5;
int result = num1+num2;

System.out.println("\nAdding two numbers:"+result);

// Type casting example

System.out.println("\nType Casting Example");


int b = 127;
int c = 12;
byte k = (byte)c;

System.out.println(k);

//		// If the value being converted is beyond the range of the converted/ casting type, then it will use a modulus operator and divide the byte range (256) with the number and show the remainder as output

System.out.println("\nIf the value being converted is beyond the range of the converted/ casting type, then it will use a modulus operator and divide the byte range (256) with the number and show the remainder as output");

int TypeCastInt = 257;
byte tcEx = (byte)TypeCastInt;
System.out.println("\nDivide the input number (TypeCastInt) with the byte range (256) and show the remainder as output: " +tcEx);

//Assignment Operators

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

//  For Loop
int i=1;
for(i<5)
{
  System.Out.Print("For Loop: "+ i + " ");
}

}
}