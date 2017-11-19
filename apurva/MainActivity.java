package com.example.apurva26.keep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*@Override
    public boolean onCreateOptionMenu(Menu,menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }*/

    public void onButtonClick(View v)
    {
        if(v.getId()==R.id.button)
        {
            EditText a = (EditText)findViewById(R.id.editText);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.editText2);
            String pass = a.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this,Login.class);
                i.putExtra("Password",str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(MainActivity.this,"Username & Passwords Don't Match",Toast.LENGTH_SHORT);
                temp.show();
            }

            Intent i = new Intent(MainActivity.this,Login.class);
            i.putExtra("Username",str);
            startActivity(i);
        }
        if(v.getId()== R.id.Bsignup)
        {
            Intent i = new Intent(MainActivity.this,SignUp.class);
            startActivity(i);
        }
    }
  /*
    @Override
    public boolean onOptionsItemSelected(MenuItem,item)
    {
        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    }
