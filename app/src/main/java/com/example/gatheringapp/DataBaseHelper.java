package com.example.gatheringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_Name ="Renting_Chalet";
    private static final int DB_Version = 2;
    public static final String chalet_ID = " ID";
    public static final String chalet_name = " NAME";
    public static final String chalet_price = " PRICE";
    public static final String chalet_table = " CHALET";
    public static final String CHALET_DECRIPTION = " chalet_decription";
    public static final String CHALET_ADDRESS = " chalet_address";
    public static final String imageName = " imageName";

    public static final String image = " image";

   // public static final String DBNAME = "Login.db";
    public static final String TABLENAME = " users";
    public static final String name = " username";
    public static final String pass = " password";
    public static final String email = " emailAddress";
    public static final String phone = " phoneNumber";



    private ByteArrayOutputStream objectOutputStream;
    byte[] imageBytes;
    Context context;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE" + chalet_table + "(" + chalet_ID + " INTEGER PRIMARY KEY," + chalet_name +
                " Text ," + chalet_price + " INTEGER ," + CHALET_DECRIPTION + " Text ," + CHALET_ADDRESS + " Text ," + imageName + " Text ,"  + image+ " blob)";
        db.execSQL(create_table);

        db.execSQL("create Table " + TABLENAME + "(" + name + " TEXT primary key, " + pass + " TEXT , " + email + " TEXT ," + phone + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_query = "drop table if exists "+chalet_table;
       db.execSQL(delete_query);
     onCreate(db);
        db.execSQL("drop Table if exists " + TABLENAME);

    }

    public Boolean insertData(String username, String password , String emailAddress , String phoneNumber ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(name, username);
        contentValues.put(pass, password);
        contentValues.put(email, emailAddress);
        contentValues.put(phone, phoneNumber);
        long result = MyDB.insert(TABLENAME, null, contentValues);
        if(result==-1) return false;
        return true;
    }


    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TABLENAME + " where " + name + " = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;

        return false;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TABLENAME + " where " + name + " = ? and " + pass + " = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;

        return false;
    }






    public boolean addChalet(Chalet chalet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

    //    values.put(chalet_ID , chalet.getChalet_id());
        values.put(chalet_name , chalet.getChalet_name());
        values.put(CHALET_DECRIPTION , chalet.getChalet_decription());
        values.put(CHALET_ADDRESS , chalet.getChalet_address());
        values.put(chalet_price , chalet.getChalet_price());
        values.put(imageName , chalet.getImageName());
        values.put(image, chalet.getImage());



       long insert = db.insert(chalet_table , null , values);

       if (insert == -1)
           return false;
       else
           return true;
    }

    public boolean DeleteOne(String chalet) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "Delete From" + chalet_table + " WHERE " + chalet_name + "= '"+chalet+"'";
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            return true;
        } else {
            // nothing happens. no one is added.
            return false;
        }

    }





        public ArrayList<Chalet> getAllChalets() {

        ArrayList<Chalet> chalets = new ArrayList<>();

        String select_query = "select * from " + chalet_table ;

        SQLiteDatabase db = this.getReadableDatabase();
        //                      condition
       Cursor cursor= db.rawQuery(select_query , null );


       if(cursor.moveToFirst()) {
           do{
/*

               int ChaletID = cursor.getColumnIndex(chalet_ID);
              int CID = Integer.parseInt(cursor.getString(ChaletID));

                   int indexName = cursor.getColumnIndex(chalet_name);
                  String name = cursor.getString(indexName);

               int indexPrice = cursor.getColumnIndex(chalet_price);
              int price = Integer.parseInt(cursor.getString(indexPrice));

              int indexDec = cursor.getColumnIndex(CHALET_DECRIPTION)   ;
              String dec = cursor.getString(indexDec) ;

             int indexAddress = cursor.getColumnIndex(CHALET_ADDRESS)  ;
             String address = cursor.getString(indexAddress) ;


               int indexImageName = cursor.getColumnIndex(imageName)  ;
               String imageName = cursor.getString(indexImageName) ;

*/

         //  int imagesIndex = cursor.getColumnIndex(image);
         //   byte[] images = cursor.getBlob(imagesIndex);

             int ChaletID = cursor.getInt(0);
              String name = cursor.getString(1);
              int price = cursor.getInt(2);
               String dec = cursor.getString(3);
               String address = cursor.getString(4);
         //     String imageName = cursor.getString(5);

               byte[] image = cursor.getBlob(6);


         //      Chalet chalet = new Chalet( name ,ChaletID,  dec,  address,price , images , imageName);

               Chalet chalet = new Chalet( name , image);


               chalets.add(chalet);


           }while (cursor.moveToNext());

       }

       cursor.close();
       db.close();


        /*
       while(cursor.moveToNext()){

           int indexName = cursor.getColumnIndex(chalet_name);
           String name = cursor.getString(indexName);

           int indexPrice = cursor.getColumnIndex(chalet_price);
           int price = Integer.parseInt(cursor.getString(indexPrice));

           int indexDec = cursor.getColumnIndex(CHALET_DECRIPTION)   ;
           String dec = cursor.getString(indexDec) ;

           int indexAddress = cursor.getColumnIndex(CHALET_ADDRESS)  ;
           String address = cursor.getString(indexAddress) ;



           Chalet chalet = new Chalet(name ,dec , address , price);

           chalets.add(chalet);
       }

*/

        return chalets;
    }


    public void  storeImage (ModelImage modelImage) {

        try{

            SQLiteDatabase db = this.getWritableDatabase();
            Bitmap bitmap = modelImage.getImage();
            objectOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG , 100 , objectOutputStream)       ;
            imageBytes = objectOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put(image , imageBytes);


            long checkIfQueryRun = db.insert(chalet_table , null , contentValues);
            if(checkIfQueryRun!=0)
                Toast.makeText(context, "image added " , Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Failed image added " , Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();

        }





    }




}
