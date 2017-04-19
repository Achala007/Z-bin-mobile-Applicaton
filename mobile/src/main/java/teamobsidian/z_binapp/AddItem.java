package com.obsidian.teamobsidian.z_bin;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class AddItem extends AppCompatActivity {
public Button AddtoDatabase;
    public EditText item;
    String itemName;
    String itemID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        sendItem();
    }

    Firebase myRef = new Firebase("https://zbin-6eb81.firebaseio.com/");
    Firebase myChildRef = myRef.child("Cart");
    public void sendItem(){
        item=(EditText) findViewById(R.id.item);


        AddtoDatabase=(Button)findViewById(R.id.AddtoDatabase);
        AddtoDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemName=item.getText().toString();

                if(!(itemName.equals(""))) {

                    myChildRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //receive data as datasnapshot
                            Map<String,String> map = dataSnapshot.getValue(Map.class);
                            //get value to String valueLevel
                            itemID = map.get("CartSize");

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    if(itemID!=null) {
                        int integerItemId = Integer.parseInt(itemID);
                        itemID = Integer.toString(++integerItemId);
                        myChildRef.child(itemID).setValue(itemName);
                        myChildRef.child("CartSize").setValue("6");
                        Intent intent = new Intent(AddItem.this, Settings.class);
                        startActivity(intent);
                    }else{
                        myChildRef.child("1").setValue(itemName);
                        myChildRef.child("CartSize").setValue("6");
                        Intent intent = new Intent(AddItem.this, Settings.class);
                        startActivity(intent);
                    }
                }else{

                    AlertDialog alertDialog = new AlertDialog.Builder(AddItem.this).create();
                    alertDialog.setTitle("Shopping list doesn't upgrade");
                    alertDialog.setMessage("please add item");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }
            }
        });



    }


}
