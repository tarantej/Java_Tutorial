public class Test {
public static void main(String[] args){


System.out.println("\nArithematic Operation\n");

int a = 20;
int b = 10;

int resultAdd = a+b;
int resultSub = a-b;
int resultMul = a*b;
int resultDiv = a/b;

boolean resultCompare = a > b;
boolean resultAndCompare = a > b && b > 0;

System.out.println("Addition: "+resultAdd);
System.out.println("Subtraction: "+resultSub);
System.out.println("Multiplication: "+resultMul);
System.out.println("Division: "+resultDiv);
System.out.println("Is a greater than b? "+resultCompare);
System.out.println("Is a > b and b > 0? "+resultAndCompare);

System.out.println("\nIf else Conditional Statements\n");

int score = 75;
char grade = 'B';

// Passed or Failed

if (score >= 50)
{
System.out.println("Passed");
} else
  {
System.out.println("Failed");
}

// Grading

if (score >= 90)
{
System.out.println("Grade: A");
} else if (score >= 75 && score <= 89)
{
System.out.println("Grade: B");
} else if (score >= 60 && score <= 74)
{
System.out.println("Grade: C");
} else
  {
System.out.println("Grade: D");
}

System.out.println("\nFor, While and do-while loops\n");

// TODO: Print numbers 1 to 5 using for loop

int i;

System.out.print("For Loop: ");

for (i = 1;i <= 5;i++)
{
System.out.print(i + " ");
}

// TODO: Print numbers 1 to 5 using while loop

System.out.print("While Loop: ");

i = 1;

while (i <= 5)
{
System.out.print(i+" ");
i++;
}


// TODO: Print numbers 1 to 5 using do-while loop

System.out.print("Do-While Loop: ");

i = 1;

do
{
System.out.print(i+" ");
i++;
}
while (i <= 5);
}
}