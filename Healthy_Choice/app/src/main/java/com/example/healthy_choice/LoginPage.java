package com.example.healthy_choice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthy_choice.db.LoginTable;

public class LoginPage extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button signInButton;
    ProgressDialog progressDialog;
    String username,password;
    LoginTable loginTable;
    TextView signUptxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        setContentView(R.layout.activity_login_page);

        loginUsername = findViewById(R.id.username_edit);
        loginPassword = findViewById(R.id.password_edit);
        signInButton = findViewById(R.id.SignInBtn);
        signUptxt = findViewById(R.id.signUpTxt);

        loginTable = new LoginTable(this);


        /*signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();



            }
        });*/

        signUptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddUser.class);
                startActivity(intent);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = loginUsername.getText().toString();
                String password = loginPassword.getText().toString();

                if (username.equals("") || password.equals(""))
                {

                    Toast.makeText(LoginPage.this,"Fields cannot be empty!",Toast.LENGTH_LONG).show();

                }

                else{
                    Boolean checkuserpass = loginTable.checkusernamepassword(username, password);
                    if (checkuserpass == true)
                    {
                        Toast.makeText(LoginPage.this,"Login Successfully",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(LoginPage.this,MainActivity.class);
                        startActivity(i);

                    }
                    else{
                        Toast.makeText(LoginPage.this,"Username or Password doesn't match!",Toast.LENGTH_LONG).show();
                    }

                }


            }
        });



    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are your sure you want to exit?")
                .setCancelable(false);
        builder.setIcon(R.drawable.ic_baseline_info_24);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoginPage.super.onBackPressed();
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    /*public void Login(){

        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();


        if (username.equals("") || password.equals("")){

            Toast.makeText(this,"Fields cannot be empty!",Toast.LENGTH_LONG).show();

        }

        else if (username.equals("administrator") && password.equals("123456")){


            Toast.makeText(this,"Login Successfully",Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginPage.this,MainActivity.class);
            startActivity(i);
        }

        else{
            Toast.makeText(this,"Username or Password doesn't match!",Toast.LENGTH_LONG).show();
        }


    }*/


}