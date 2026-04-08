package com.dashboard;
class Users {

//  Declare Variables
String first_name;
String last_name;
String username;
String password;
public String welcome()
{
//return first_name and last_name in the method
return "Welcome to the Dashboard, "+first_name+" "+last_name;
}

public static void main(String args[])
{
//  Create a new object u for class Users
Users u = new Users();
//  Call the first_name and last_name variables passed in the method and put it in a string variable to show output
u.first_name = "Tarantej";
u.last_name = "Singh";
String message = u.welcome();
System.out.println(message);

}


}