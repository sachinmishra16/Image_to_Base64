package com.blueapple.file_classfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    String filedata="";
    Button button;

    ImageView imageView;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonid);
        imageView=findViewById(R.id.imageid);
/*
        File file = new File(  Environment.getExternalStorageDirectory().getAbsolutePath(), "testing.txt");

        Log.d("file", String.valueOf(file));
        Log.d("path_stroage",Environment.getExternalStorageDirectory().getAbsolutePath());

        FileOutputStream overWrite = null;
        try {
            overWrite = new FileOutputStream(file, false);

        overWrite.write(" hello india world".getBytes(Charset.forName("UTF-8")));

        overWrite.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String data;

        try {
            InputStream fileStream = new FileInputStream(file);
            int fileLen = fileStream.available();
            // Read the entire resource into a local byte buffer.
            byte[] fileBuffer = new byte[fileLen];
            fileStream.read(fileBuffer);
            fileStream.close();
            data = new String(fileBuffer);

            Log.d("data_inputstream",data);
            Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            // exception handling
        }*/



        //encode image to base64 string


        //compressing the image in Base64

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.heart);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

       byte[] imageBytes = outputStream.toByteArray();


       String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        Log.d("imagestring",imageString);


        //write the base64 string in image.txt file

        File newfile = new File(  Environment.getExternalStorageDirectory().getAbsolutePath(), "image.txt");


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(newfile, false);

            fileOutputStream.write(imageString.getBytes(Charset.forName("UTF-8")));

            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //read the base64 string from text file


        try {
            FileInputStream inputStream=new FileInputStream(newfile);

            int filelength=inputStream.available();

            byte[] fileBuffer = new byte[filelength];
            inputStream.read(fileBuffer);
            inputStream.close();
            filedata = new String(fileBuffer);

            Log.d("filedata",filedata);


        } catch (Exception e) {
            e.printStackTrace();
        }


        // decoding the image fom base64

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               byte[] imageBytesarray = Base64.decode(filedata, Base64.DEFAULT);

                Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytesarray, 0, imageBytesarray.length);

                imageView.setImageBitmap(decodedImage);
            }
        });


       /* //decode base64 string to image

        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        imageView.setImageBitmap(decodedImage);*/
    }











    /*    try {
            FileReader fileReader=new FileReader(file);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((data = bufferedReader.readLine()) != null)
            {

                Log.d("filedata",data);

                bufferedReader.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

