package com.example.apurva26.keep;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Apurva26 on 13-11-2017.
 */

public class Login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        String username = getIntent().getStringExtra("Username");
        //TestView tv = (TextView)findViewById(R.id.tvusername);
        //tv.setText(username);
    }
}
