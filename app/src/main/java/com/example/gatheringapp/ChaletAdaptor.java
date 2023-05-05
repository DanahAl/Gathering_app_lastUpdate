package com.example.gatheringapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ChaletAdaptor extends ArrayAdapter<Chalet>{
 Context context;
 int resource;

    public ChaletAdaptor(@NonNull Context context, int resource, @NonNull List<Chalet> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }



    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource , parent , false);
         // conertview to help when scroll down list
        TextView name =(TextView) convertView.findViewById(R.id.Name1);
        TextView price =(TextView) convertView.findViewById(R.id.EditPrice);
        TextView description = (TextView)  convertView.findViewById(R.id.EditDec);
        TextView address = (TextView)  convertView.findViewById(R.id.EditAddress);
        ImageView imgUser = (ImageView) convertView.findViewById(R.id.chaletImg);

        Chalet currentChalet = getItem(position);

       name.setText(currentChalet.getChalet_name());
       price.setText(String.valueOf(currentChalet.getChalet_price()));
       description.setText(currentChalet.getChalet_decription());
       address.setText(currentChalet.getChalet_address());
       Bitmap bitmap = BitmapFactory.decodeByteArray(currentChalet.getImage() , 0 , currentChalet.getImage().length);
       imgUser.setImageBitmap(bitmap);
        return convertView;
    }


}
