package com.example.healthy_choice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthy_choice.db.LoginTable;

public class AddUser extends AppCompatActivity {

    EditText loginUsername, loginPassword, loginConfirm;
    Button signInButton;
    ProgressDialog progressDialog;
    String username,password;

    LoginTable loginTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(AddUser.this,R.color.colorPrimaryDark));
        }


        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1D8348"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginUsername = findViewById(R.id.username_edit);
        loginPassword = findViewById(R.id.password_edit);
        loginConfirm = findViewById(R.id.confirm_password_edit);
        signInButton = findViewById(R.id.SignInBtn);

        loginTable = new LoginTable(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = loginUsername.getText().toString();
                String password = loginPassword.getText().toString();
                String confirm = loginConfirm.getText().toString();

                if (username.equals("") || password.equals("") || confirm.equals(""))
                    Toast.makeText(AddUser.this, "Fields cannot be empty!", Toast.LENGTH_LONG).show();
                else{
                    if (password.equals(confirm)){
                        Boolean checkuser = loginTable.checkusername(username);
                        if (checkuser == false){
                            Boolean insert = loginTable.insertRecord(username, password);
                            if (insert == true){
                                Toast.makeText(AddUser.this, "Account Created Successfully!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(AddUser.this, "Failed!", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(AddUser.this, "User Already Exists!", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(AddUser.this, "Password do not Match!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}