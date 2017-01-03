    package com.obsidian.teamobsidian.z_bin;

    import android.content.Intent;
    import android.graphics.Color;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.RelativeLayout;
    import android.widget.TextView;

    import com.firebase.client.DataSnapshot;
    import com.firebase.client.Firebase;
    import com.firebase.client.FirebaseError;
    import com.firebase.client.ValueEventListener;

    import java.util.Map;

    public class Show_Level extends AppCompatActivity{

        public TextView Value;
        String valueLevel;
        public Button back;
        public void setValue(){
            //get the depth level from firebase as a String
            Firebase myRef = new Firebase("https://zbin-6eb81.firebaseio.com/");
            Firebase myChildRef = myRef.child("level");
            myChildRef.addValueEventListener(new ValueEventListener() {
               
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //receive data as datasnapshot
                    Map<String,String> map = dataSnapshot.getValue(Map.class);
                    //get value to String valueLevel
                    valueLevel = map.get("currentLevel");
                    
                    Intent intent = getIntent();
                    TextView Value = (TextView)findViewById(R.id.Value);
                    //convert String to double
                    double valueInt=Double.parseDouble(valueLevel);
                   
                    if(valueInt>=100){
                        Value.setText("100%");

                    }else {
                        Value.setText(valueLevel + "%");
                    }

                    RelativeLayout rl = (RelativeLayout)findViewById(R.id.activity_show__level);
                       //change color according to the percentage of the depth level
                    if(valueInt<=100 && valueInt>=90){

                        Value.setTextColor(Color.parseColor("red"));
                        rl.setBackgroundColor(Color.RED);

                    }else if(valueInt<90 && valueInt>=70){

                        Value.setTextColor(Color.parseColor("YELLOW"));
                        rl.setBackgroundColor(Color.YELLOW);

                    }else if(valueInt<70 && valueInt>=40){

                        Value.setTextColor(Color.parseColor("blue"));
                        rl.setBackgroundColor(Color.BLUE);

                    }else if(valueInt<40 && valueInt>=0){
                        Value.setTextColor(Color.parseColor("green"));
                        rl.setBackgroundColor(Color.GREEN);

                    }else if(valueInt>=100){

                        Value.setTextColor(Color.parseColor("red"));
                        rl.setBackgroundColor(Color.RED);
                    }


                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });





        }


    //start
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show__level);
            setValue();
            backToLevel();


        }
        //back button
       public void backToLevel(){
            back=(Button)findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(Show_Level.this, MainActivity.class);
                    startActivity(intent1);
                }
            });

        }


    }

