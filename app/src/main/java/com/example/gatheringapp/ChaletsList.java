package com.example.gatheringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChaletsList extends AppCompatActivity {


    ListView chaletList;
    Button AddButton1;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chalets_list);


        chaletList =(ListView) findViewById(R.id.chaletList1);

        db = new DataBaseHelper(this);

        ArrayList<Chalet> chalets = db.getAllChalets();

       // AddButton1 = (Button) findViewById(R.id.AddButton);


        ChaletAdaptor chaletAdaptor = new ChaletAdaptor(this , R.layout.item_chalet , chalets);

        /*
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
        chalets.add(new Chalet("chalet1"));
*/
        chaletList.setAdapter(chaletAdaptor);




/*
        chaletList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(ChaletsList.this , Chalet_detiles.class);
                startActivity(intent);
            }
        });
*/

    }


}