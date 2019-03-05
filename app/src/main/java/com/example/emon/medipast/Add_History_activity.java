package com.example.emon.medipast;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class Add_History_activity extends AppCompatActivity {
    private  ImageView imageView;
    public EditText nameEt,detailsEt,date;
    public Button Savebtn, takePHotobtn;
    public DBmanager manager;
    private History history;
    private static final int REQUEST_CODE_FOR_CAMERA = 1;
    String imageFromCamera;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_FOR_CAMERA && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageFromCamera = encodeImage(bitmap, Bitmap.CompressFormat.JPEG, 70);
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__history_activity);

    imageView=findViewById(R.id.ImageVid);
    nameEt=findViewById(R.id.NAMEID);
    detailsEt=findViewById(R.id.DETAILSID);
    date=findViewById(R.id.DATEID);
    Savebtn=findViewById(R.id.SAVEID);
    takePHotobtn=findViewById(R.id.takephotoID);

    manager=new DBmanager(this);

    takePHotobtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_CODE_FOR_CAMERA);
            }
        }
    });


        Savebtn.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
                String name=nameEt.getText().toString();
                String details=detailsEt.getText().toString();
                String appointment=date.getText().toString();



                history=new History(name,details,appointment,imageFromCamera);
                boolean insert=manager.insertHistory(history);
                if(insert) {
                    Toast.makeText(Add_History_activity.this, "History added successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Add_History_activity.this,MainActivity.class);
                    startActivity(intent);

               }else{
                    Toast.makeText(Add_History_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
          }
        });



    }
    public static String encodeImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int quality) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, quality, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeImage(String input) {

        byte[] decodebyte = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
    }
}
