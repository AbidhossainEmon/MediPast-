package com.example.emon.medipast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADD_Doctor_activity extends AppCompatActivity {
   
   public EditText nameEt, phoneEt,detailsEt,appoinmentEt,emailEt;
   public Button Savebtn;
   public DBmanager manager;
   public person mperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__doctor_activity);
    
     nameEt=findViewById(R.id.nameEtId);
     detailsEt=findViewById(R.id.detailseEtId);
     appoinmentEt=findViewById(R.id.appointmentEtId);
     emailEt=findViewById(R.id.emailEtId);
     phoneEt=findViewById(R.id.phoneEtId);

     Savebtn=findViewById(R.id.SavebtnId);
     manager=new DBmanager(this);

     Intent intent=getIntent();
     nameEt.setText(intent.getStringExtra("name"));
     detailsEt.setText(intent.getStringExtra("details"));
     emailEt.setText(intent.getStringExtra("email"));
     appoinmentEt.setText(intent.getStringExtra("date"));
     phoneEt.setText(intent.getStringExtra("phone"));


     Savebtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String name=nameEt.getText().toString();
             String details=detailsEt.getText().toString();
             String appointment=appoinmentEt.getText().toString();
             String phone = phoneEt.getText().toString();
             String email=emailEt.getText().toString();

             mperson=new person(name,details,appointment,phone,email);

           boolean insert=manager.insertStudent(mperson);
   if(insert) {
        Toast.makeText(ADD_Doctor_activity.this, "Doctor profile Added", Toast.LENGTH_SHORT).show();
       Intent intent=new Intent(ADD_Doctor_activity.this,MainActivity.class);
       startActivity(intent);

    }else{
        Toast.makeText(ADD_Doctor_activity.this, "Failed", Toast.LENGTH_SHORT).show();
         }
    }
     });
        
     }
}
