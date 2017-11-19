package com.example.apurva26.keep;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Apurva26 on 13-11-2017.
 */

public class SignUp extends Activity
{
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.Bsignupbutton)
        {
            TextView name = (TextView) findViewById(R.id.TFname);
            TextView uname = (TextView)findViewById(R.id.TFusername);
            TextView surname = (TextView)findViewById(R.id.TFsurname);
            TextView gender = (TextView)findViewById(R.id.TFgender);
            TextView age = (TextView)findViewById(R.id.TFage);
            TextView pass1 = (TextView)findViewById(R.id.TFpass1);
            TextView pass2 = (TextView)findViewById(R.id.TFpass2);

            String nstr = name.getText().toString();
            String ustr = uname.getText().toString();
            String sstr = surname.getText().toString();
            String gstr = gender.getText().toString();
            int agestr = Integer.parseInt(age.getText().toString());
            String p1str = pass1.getText().toString();
            String p2str = pass2.getText().toString();

            if(!p1str.equals(p2str))
            {
                //pop up msg
                Toast pass = Toast.makeText(SignUp.this,"Passwords Don't Match",Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert details in db
                Contact c = new Contact();
                c.setName(nstr);
                c.setAge(agestr);
                c.setGender(gstr);
                c.getSurname();
                c.setPass(p1str);
                c.setUname(ustr);

                helper.insertContact(c);
            }
        }
    }
}
