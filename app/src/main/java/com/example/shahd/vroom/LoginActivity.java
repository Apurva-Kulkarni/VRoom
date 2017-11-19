package com.example.shahd.vroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        final EditText etUsername=(EditText) findViewById(R.id.etUsername);
        final EditText etPassword=(EditText) findViewById(R.id.etPassword);
        final Button etLogin= (Button) findViewById(R.id.bLogin);

        final TextView RegisterLink= (TextView) findViewById(R.id.b1Login);
        RegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

    }

    public void buttonClick(View view) {
        Intent intent= new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
