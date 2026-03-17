class hello
{
    public static void main(String a[])
    {
        // System.out.println("Hello World");

        // Adding two numbers
        
        /*
        
        int num1 = 3;
        int num2 = 5;
        int result = num1+num2;
        
        System.out.println(result);
        
        */
        
        // Type casting example
        
        //int b =127;
        int c = 12;
        byte k = (byte)c;
        
        System.out.println(k);
    }
}

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

Integer Types
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

// How to convert int value to byte (Typecasting)

Casting is explicit conversion of variable data type

b=(byte)a

you cannot do type casting for a character or boolean type value

// Converting a float value to integer

float f  = 5.6f;  (We add f at the end otherwise the system assumes it is a double data type value by default)

int x = (int)f; 

// If the value being converted is beyond the range of the converted/ casting type, then it will use a modulus operator

int a = 257; 

// For example, if we are trying to convert an integer value to a byte and the value of the variable is greater than 127, then a modulus operation will be performed

*/