package com.obsidian.teamobsidian.z_bin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    public Button splashbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final ImageView im=(ImageView)findViewById(R.id.splashImage1);
        //load and rotate the splash screen 1
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        im.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
           
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                im.startAnimation(an2);
                finish();

                 
                        Intent i=new Intent( SplashScreen.this,Login.class);
                        startActivity(i);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



}
