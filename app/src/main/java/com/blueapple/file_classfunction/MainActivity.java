package com.blueapple.file_classfunction;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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


public class MainActivity extends AppCompatActivity {

    String filedata = "";
    Button button;
    byte[] imageBytes;

    ImageView imageView;
    String imageString;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonid);
        imageView = findViewById(R.id.imageid);


      /*  Bitmap bm = BitmapFactory.decodeFile("/storage/emulated/0/image.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] byteArrayImage = baos.toByteArray();

        String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
*/

        Bitmap bm = BitmapFactory.decodeFile("/storage/emulated/0/download.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] byteArrayImage = baos.toByteArray();

        final String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

        Log.d("encoded_image",encodedImage);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                Log.d("bitmap_image", String.valueOf(decodedByte));


                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                decodedByte.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(MainActivity.this.getContentResolver(), decodedByte, "Title", null);
                Uri.parse(path);

                imageView.setImageURI(Uri.parse(path));

                Log.d("image_path",path);
            }
        });
       /* File imagefile = new File("/storage/emulated/0/image.jpg");
            FileInputStream fis = null;
            try
            {
                fis = new FileInputStream(imagefile);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            Bitmap bm = BitmapFactory.decodeStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
            byte[] b = baos.toByteArray();
            String encImage = Base64.encodeToString(b, Base64.DEFAULT);
            //Base64.de
            Log.d("encoded_image",encImage);

*/
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

       /* ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.download);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

       byte[] imageBytes = outputStream.toByteArray();
*/

        /*Bitmap bm = BitmapFactory.decodeFile("/storage/emulated/0/whatsapp.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();


        String imageString = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("imagestring", imageString);*/
       /* Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.download);

        String base64string=getEncoded64ImageStringFromBitmap(bitmap);

        Log.d("base64string",base64string);*/


        //retrofitClient.getJsonObject(uploadRequest));


     /*   File file = new File("/storage/emulated/0/whatsapp.jpg");
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        Log.d("multipartbody", String.valueOf(body));


// add another part within the multipart request
        RequestBody fullName =
                RequestBody.create(MediaType.parse("multipart/form-data"), "Sachin");

        Log.d("fullName", String.valueOf(fullName));


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.googlelogo);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        imageBytes= baos.toByteArray();
        imageString  = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        Log.d("base64string",imageString);

*/

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //decode base64 string to image


                imageBytes = Base64.decode(imageString, Base64.DEFAULT);

                Log.d("imageBytes", String.valueOf(imageBytes));

                Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                imageView.setImageBitmap(decodedImage);

                Log.d("decodedImage", String.valueOf(decodedImage));


            }
        });
        */


        //write the base64 string in image.txt file

      /*  File newfile = new File(  Environment.getExternalStorageDirectory().getAbsolutePath(), "image.txt");


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


       *//* //decode base64 string to image

        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        imageView.setImageBitmap(decodedImage);*//*
    }






*/




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


/*    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);



        return imgString;
    }*/


    }

}