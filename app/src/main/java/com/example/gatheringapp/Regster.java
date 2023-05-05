package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regster extends AppCompatActivity {

    DataBaseHelper DB;
    Button register;
    EditText username , password , emailAddress , phonenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regster);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        emailAddress = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phone);
        register = findViewById(R.id.register);

        DB = new DataBaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String email = emailAddress.getText().toString();
                String phone = phonenumber.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Regster.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUser = DB.checkUsername(user);
                    if(!checkUser){
                        Boolean insert = DB.insertData(user, pass , email , phone);
                        if(insert){
                            Toast.makeText(Regster.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),home2.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Regster.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Regster.this,"Already exists! please sign in",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


}