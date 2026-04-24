package com.dashboard;

public class DashboardUsers {

String first_name;
String last_name;

    public DashboardUsers(String first_name, String last_name)
    {
        this.first_name = first_name;
        this.last_name = last_name;
    }


    public String welcome()
    {
    //return first_name and last_name in the method
    return "Welcome to the Dashboard, "+first_name+" "+last_name;
    }


}