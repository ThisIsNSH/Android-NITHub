package com.travis.myapplication;

import android.content.Context;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Hostelallotmentback extends AppCompatActivity {
    public String rollno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floors);
        final ImageView imageView = findViewById(R.id.floormap);
        findViewById(R.id.floor_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.floor_1));
            }
        });

        findViewById(R.id.floor_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.floor_2));
            }
        });

        findViewById(R.id.floor_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.floor_3));
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final EditText roll = (EditText) findViewById(R.id.edittext_rollno);
                final String rollno = roll.getText().toString();


                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference rank = ref.child("hostel-ed177").child("roll").child(rollno);

                rank.addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String rank1 = dataSnapshot.getValue(String.class);
                        if(rank1=="-1")
                        {
                            Context context = getApplicationContext();
                            CharSequence text = "Already registered";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();


                        }
                        else {

                            rank.setValue("-1");
                            //do what you want with the email

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }


        });
    }




}



