package com.blanat.blanatfront.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blanat.blanatfront.R;

public class ProfileActivity extends AppCompatActivity {
    Button logoutBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_profile);
         logoutBtn = findViewById(R.id.logout_btn);

         logoutBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 removeJwtTokenFromSharedPreferences();
                 Intent intent = new Intent(getBaseContext(),MainActivity.class);
                 startActivity(intent);
             }
         });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(getJwtTokenFromSharedPreferences() == null){
            setContentView(R.layout.activity_main);
        }
    }

    private  String getJwtTokenFromSharedPreferences() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPreferences", MODE_PRIVATE);
        return preferences.getString("jwtToken", null);
    }


    private void removeJwtTokenFromSharedPreferences() {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("jwtToken");
        editor.apply();

    }


}