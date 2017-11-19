package com.example.apurva26.keep;

import android.widget.TextView;

/**
 * Created by Apurva26 on 13-11-2017.
 */

public class Contact
{

    int age;
    String name , uname , pass , gender , surname;


    public void  setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }

    public void  setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void  setSurname(String surname)
    {
        this.surname = surname;
    }
    public String getSurname()
    {
        return this.surname;
    }

    public void  setGender(String gender)
    {
        this.gender = gender;
    }
    public String getGender()
    {
        return this.gender;
    }

    public void  setUname(String uname)
    {
        this.uname = uname;
    }
    public String getUname()
    {
        return this.uname;
    }

    public void  setPass(String pass)
    {
        this.pass = pass;
    }
    public String getPass()
    {
        return this.pass;
    }


}
