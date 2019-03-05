package com.example.emon.medipast;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryDetailsActivity extends AppCompatActivity {
    ImageView imageTv;
    TextView nameET,detailsET,dateET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);
        imageTv=findViewById(R.id.IMAGETV);
        nameET=findViewById(R.id.NAMETV);
        detailsET=findViewById(R.id.DETAILSTV);
        dateET=findViewById(R.id.DATETV);

        Intent intent = getIntent();
        String image= intent.getStringExtra("image");
        String name=intent.getStringExtra("name");
        String details=intent.getStringExtra("details");
        String date=intent.getStringExtra("date");
        int id=intent.getIntExtra("id", 0);

        nameET.setText(name);
        detailsET.setText(details);
        dateET.setText(date);

        Bitmap bm=decodeImage(image);
        imageTv.setImageBitmap(bm);

    }
    public static Bitmap decodeImage(String input) {

        byte[] decodebyte = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
    }
}
