package com.blanat.blanatfront.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blanat.blanatfront.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginButton = findViewById(R.id.btnLogin);
        Button signupButton = findViewById(R.id.btnSignup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the LoginScreen activity
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the SignupScreen activity
                Intent signupIntent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }
        });

    }
}