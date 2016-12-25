package com.obsidian.teamobsidian.z_bin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    public Button changebtn;
    public TextView SheduleArea;
    public Button backToStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent2 = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SheduleArea();
        ChangeTime();
        BackToStatus();
    }
    //set date time in this area
    public void SheduleArea(){
        TextView SheduleArea = (TextView)findViewById(R.id.SheduleArea);
        SheduleArea.setText("Click change to add Shedule Time table in this slot");

        SheduleArea.setTextSize(45);

    }
    //change time button
    public void ChangeTime(){

        changebtn=(Button)findViewById(R.id.changebtn);
        changebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Settings.this, Form.class);
                startActivity(intent3);
            }
        });
    }

    public void BackToStatus(){
        backToStatus=(Button)findViewById(R.id.backToStatus);
        backToStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Settings.this, MainActivity.class);
                startActivity(intent3);
            }
        });


    }



}
