package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;


public class home2 extends AppCompatActivity {
    private Button b_add;
    private Button LogOut;
    private Button viewButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        b_add = (Button) findViewById(R.id.b_add);
        LogOut = (Button) findViewById(R.id.buttonLogOut);
        viewButton = (Button)findViewById(R.id.b_view);



        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });

        LogOut.setOnClickListener( new View.OnClickListener() {public void onClick(View view) {
            openHome();
        }});

        viewButton.setOnClickListener(new View.OnClickListener()  {public void onClick(View view){

            openView();


         }

         }


        );




    }

    public void openAdd(){
        Intent intent = new Intent(this, AddChalet.class);
        startActivity(intent);
    }
    public void openHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

    public void openView(){
        Intent intent = new Intent(this, ChaletsList.class);
        startActivity(intent);
    }




}