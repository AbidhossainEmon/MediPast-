package com.example.emon.medipast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DoctorDetail extends AppCompatActivity {
    TextView NameTv,detailsTv,dateTv,phoneTv,emailTv;
    DBmanager myManager;
    int Id;
    String name, details, date, phone, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        NameTv=findViewById(R.id.nameTVId);
        detailsTv=findViewById(R.id.detailTvID);
        dateTv=findViewById(R.id.appointmentTvId);
        phoneTv=findViewById(R.id.phoneTvId);
        emailTv=findViewById(R.id.emailTvId);

        Intent intent= getIntent();
         name=intent.getStringExtra("name");
         details=intent.getStringExtra("details");
         date=intent.getStringExtra("date");
         phone=intent.getStringExtra("phone");
         email= intent.getStringExtra("email");
         Id=intent.getIntExtra("id",0);

        NameTv.setText(name);
        detailsTv.setText(details);
        dateTv.setText(date);
        phoneTv.setText(phone);
        emailTv.setText(email);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doctordetail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.delete_menu) {
             myManager=new DBmanager(this);
             myManager.deleteStudent(Id);
             Intent intent=new Intent(this,MainActivity.class);
             startActivity(intent);

        }else if (id== R.id.update_menu){
            myManager=new DBmanager(this);
            myManager.deleteStudent(Id);

            Intent intent= new Intent(this,ADD_Doctor_activity.class);
            intent.putExtra("name",name);
            intent.putExtra("details",details);
            intent.putExtra("date",date);
            intent.putExtra("phone",phone);
            intent.putExtra("email",email);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
