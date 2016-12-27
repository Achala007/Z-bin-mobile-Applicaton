package com.obsidian.teamobsidian.z_bin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.level;
import android.support.v7.app.AppCompatActivity;

public class Form extends AppCompatActivity {


   public class MainActivity extends AppCompatActivity {
      public Button Level;
      public Button Settings;


      public void MeasureLevel(){

         Level=(Button)findViewById(R.id.Level);
         Level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Show_Level.class);
               startActivity(intent);
            }
         });



      }
      @Override
      protected void onCreate(Bundle savedInstanceState) {
         Intent intent5 = getIntent();

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Settings();
         MeasureLevel();

      }

      public void Settings(){
         Settings=(Button)findViewById(R.id.Settings);
         Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent2 = new Intent(MainActivity.this, Settings.class);
               startActivity(intent2);
            }
         });


      }


   }



   }