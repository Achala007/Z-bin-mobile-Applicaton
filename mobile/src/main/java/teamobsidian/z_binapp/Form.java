package com.obsidian.teamobsidian.z_bin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.ArrayList;

public class Form extends AppCompatActivity {
    public Button Donebtn;
    public CheckBox chkMonday;
    public CheckBox chkTuesday;
    public CheckBox chkWednesday;
    public CheckBox chkThursday;
    public CheckBox chkFriday;
    public CheckBox chkSaturday;
    public CheckBox chkSunday;
    final static ArrayList<String> days=new ArrayList<String>();

    public TextView txtex;
    int m=0;
   boolean Monday=true;
    public View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent3 = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        SetTime();
       //selectItem(view);
       DateTimeDone();
    }

    public void DateTimeDone(){

        Donebtn=(Button)findViewById(R.id.Donebtn);
        Donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Form.this, MainActivity.class);



//Create the bundle
               // Bundle bundle = new Bundle();

//Add your data to bundle
                intent4.putStringArrayListExtra("days", days);

//Add the bundle to the intent
               // intent4.putExtras(bundle);
                startActivity(intent4);
            }
        });

    }

    public void SetTime(){
        Firebase myRef = new Firebase("https://zbin-6eb81.firebaseio.com/");
        final Firebase myChildRef = myRef.child("Shedule");
        chkMonday = (CheckBox)findViewById(R.id.chkMonday);
        chkTuesday = (CheckBox)findViewById(R.id.chkTuesday);
        chkWednesday = (CheckBox)findViewById(R.id.chkWednesday);
        chkThursday = (CheckBox)findViewById(R.id.chkThursday);
        chkFriday = (CheckBox)findViewById(R.id.chkFriday);
        chkSaturday = (CheckBox)findViewById(R.id.chkSaturday);
        chkSunday = (CheckBox)findViewById(R.id.chkSunday);


        chkMonday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkMonday.isEnabled())
                {

                  Toast.makeText(Form.this,"Monday is selected ", Toast.LENGTH_SHORT).show();
                   // String text=chkMonday.getText().toString();
                    if(days.contains("Monday")){
                        //myChildRef.child("Monday").setValue("False");

                        days.remove("Monday");
                    }else{
                        myChildRef.child("Monday").setValue("True");

                        days.add("Monday");

                    }

                }else{

                   if(days.contains("Monday")){
                        myChildRef.child("Monday").setValue("False");

                        days.remove("Monday");}
                }




       }

     });
        chkTuesday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkTuesday.isEnabled())
                {

                    Toast.makeText(Form.this,"Tuesday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Tuesday")){
                       // myChildRef.child("Tuesday").setValue("False");

                        days.remove("Tuesday");
                    }else{
                        myChildRef.child("Tuesday").setValue("True");

                        days.add("Tuesday");

                    }

                }else{

                    if(days.contains("Tuesday")){
                        myChildRef.child("Tuesday").setValue("False");

                        days.remove("Tuesday");}
                }




            }

        });

        chkWednesday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkWednesday.isEnabled())
                {

                    Toast.makeText(Form.this,"Wednesday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Wednesday")){
                       // myChildRef.child("Wednesday").setValue("False");

                        days.remove("Monday");
                    }else{
                        myChildRef.child("Wednesday").setValue("True");

                        days.add("Wednesday");

                    }

                }else{

                    if(days.contains("Wednesday")){
                        myChildRef.child("Wednesday").setValue("False");

                        days.remove("Wednesday");}
                }




            }

        });

        chkThursday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkThursday.isEnabled())
                {

                    Toast.makeText(Form.this,"Thursday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Thursday")){
                       // myChildRef.child("Thursday").setValue("False");

                        days.remove("Thursday");
                    }else{
                        myChildRef.child("Thursday").setValue("True");

                        days.add("Thursday");

                    }

                }else{

                    if(days.contains("Thursday")){
                        myChildRef.child("Thursday").setValue("False");

                        days.remove("Thursday");}
                }




            }

        });

        chkFriday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkFriday.isEnabled())
                {
                    chkFriday.setAlpha(1);

                    Toast.makeText(Form.this,"Friday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Friday")){
                       // myChildRef.child("Friday").setValue("False");

                        days.remove("Friday");
                    }else{
                        myChildRef.child("Friday").setValue("True");

                        days.add("Friday");

                    }

                }else{
                    //chkFriday.setAlpha(0);


                    if(days.contains("Friday")){
                        myChildRef.child("Friday").setValue("False");

                        days.remove("Friday");}
                }




            }

        });

        chkSaturday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkSaturday.isEnabled())
                {

                    Toast.makeText(Form.this,"Saturday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Saturday")){
                       // myChildRef.child("Saturday").setValue("False");

                        days.remove("Saturday");
                    }else{
                        myChildRef.child("Saturday").setValue("True");

                        days.add("Saturday");

                    }

                }else{

                    if(days.contains("Saturday")){
                        myChildRef.child("Saturday").setValue("False");

                        days.remove("Saturday");}
                }




            }

        });
        chkSunday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(chkSunday.isEnabled())
                {

                    Toast.makeText(Form.this,"Sunday is selected ", Toast.LENGTH_SHORT).show();
                    // String text=chkMonday.getText().toString();
                    if(days.contains("Sunday")){
                       // myChildRef.child("Sunday").setValue("False");

                        days.remove("Sunday");
                    }else{
                        myChildRef.child("Sunday").setValue("True");

                        days.add("Monday");

                    }

                }else{

                    if(days.contains("Sunday")){
                        myChildRef.child("Sunday").setValue("False");

                        days.remove("Sunday");}
                }




            }

        });

        if(!days.isEmpty()) {
           // txtex.setText(days.get(0));

            for(String day : days){

                Log.v("d",day);

            }

        }






    }








    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notifications, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
