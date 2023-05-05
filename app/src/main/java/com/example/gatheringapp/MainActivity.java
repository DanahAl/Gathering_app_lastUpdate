package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView chaletList;
    Button AddButton;
    DataBaseHelper db;
    private TextView image_detailes;
    private ImageView imageView;
private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chaletList =(ListView) findViewById(R.id.chaletList);
        AddButton = (Button) findViewById(R.id.AddButton);

        db = new DataBaseHelper(this);





      // ArrayList<Chalet> chalets = db.getAllChalets();


/*
       ChaletAdaptor chaletAdaptor = new ChaletAdaptor(this , R.layout.item_chalet , chalets);
        chaletList.setAdapter(chaletAdaptor);
*/



        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddChalet.class);

                startActivity(intent);
            }
        });

        chaletList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this , Chalet_detiles.class);
                startActivity(intent);
            }
        });


    }






    /*
    protected void onResume( ) { // update list during running app
        super.onResume();


        ArrayList<Chalet> chalets = db.getAllChalets();


        ChaletAdaptor chaletAdaptor = new ChaletAdaptor(this , R.layout.item_chalet , chalets);
        chaletList.setAdapter(chaletAdaptor);


    }
*/




}