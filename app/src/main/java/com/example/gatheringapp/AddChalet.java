package com.example.gatheringapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.stream.Stream;

public class AddChalet extends AppCompatActivity {
DataBaseHelper db ;
    EditText EditName , EditPrice , EditDec , EditAddress , EditImageName ;
    Button AddButton;
    ImageButton pickImg;

    ImageView ImagesView;
    byte[] image = null;


    ImageView objectImageView;

    private  static final int code_img = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chalet);


        EditName = (EditText) findViewById(R.id.EditName);
        EditPrice = (EditText) findViewById(R.id.EditPrice);
        EditAddress = (EditText)  findViewById(R.id.EditAddress);
        EditDec = (EditText)  findViewById(R.id.EditDec);
        EditImageName = (EditText) findViewById(R.id.EditImageName);
        pickImg = (ImageButton) findViewById(R.id.image_button1);




        AddButton = (Button)  findViewById(R.id.AddButton);

        db = new DataBaseHelper(this);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = EditName.getText().toString();
               int Price =Integer.parseInt (EditPrice.getText().toString());
               String address = EditAddress.getText().toString();
               String description = EditDec.getText().toString();

               String imageName = EditImageName.getText().toString();


                BitmapDrawable drawable = (BitmapDrawable) pickImg.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                image = getBytes(bitmap);




                Chalet chalet = new Chalet(name , -1   ,description, address , Price , image , imageName );
             boolean added =   db.addChalet(chalet);
                Toast.makeText(AddChalet.this , "Chalet added " + added, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void openGalleries(View view) {

        try {

/*

            Intent intentImg = new Intent(Intent.ACTION_GET_CONTENT);
            intentImg.setType("image/*");
           startActivityForResult(intentImg, code_img);
*/

            Intent intentImg = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(intentImg, code_img);



        }catch (Exception E){
            Toast.makeText(this , E.getMessage() , Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    //to response result
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == code_img && data!=null && data.getData()!=null){
            Uri uri = data.getData();

            try {

                /*

                InputStream inputStream = getContentResolver().openInputStream(uri);

                //Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
               Bitmap bitmap = ((BitmapDrawable) pickImg.getDrawable()).getBitmap();

               // Bitmap decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(InputStream.toByteArray()));

                pickImg.setImageBitmap(bitmap);

                image = getBytes(bitmap);
*/

                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                pickImg.setImageBitmap(decodeStream);

                image = getBytes(decodeStream);


            }catch (Exception ex) {
                Toast.makeText(this , ex.getMessage() , Toast.LENGTH_SHORT).show();
            }



    }
}

public static byte[] getBytes(Bitmap bitmap) {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 0 , stream);
    return stream.toByteArray();
}


    public void storeImage(View view) {

        try{
            BitmapDrawable drawable = (BitmapDrawable) pickImg.getDrawable();
            Bitmap bitmap = drawable.getBitmap();

            if(bitmap!= null){
                db.storeImage(new ModelImage(EditImageName.getText().toString() , bitmap));
                image = getBytes(bitmap);

            }

            else
                Toast.makeText(this , " Please select image" , Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT).show();

        }
    }
}