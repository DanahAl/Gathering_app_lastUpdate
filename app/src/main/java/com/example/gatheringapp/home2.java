package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class home2 extends AppCompatActivity {
    private Button b_add;
    private Button LogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        b_add = (Button) findViewById(R.id.b_add);
        LogOut = (Button) findViewById(R.id.buttonLogOut);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });

        LogOut.setOnClickListener( new View.OnClickListener() {public void onClick(View view) {
            openHome();
        }});
    }

    public void openAdd(){
        Intent intent = new Intent(this, AddChalet.class);
        startActivity(intent);
    }
    public void openHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}