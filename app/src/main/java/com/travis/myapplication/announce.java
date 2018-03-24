package com.travis.myapplication;

import android.support.v7.app.AlertDialog;

import java.util.Calendar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import com.travis.myapplication.Adapters.ContactAdapter;
import com.travis.myapplication.Classes.ContactInfo;

public class announce extends AppCompatActivity implements Button.OnClickListener {

    private Button feedButton;
    private List<ContactInfo> list;
    private RecyclerView recList;
    private ContactAdapter ca;
    private EditText subEditText;
    private EditText surNameText;
    private EditText firstNameText;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Make an array list for the content of the Recyclerview
        list = new ArrayList<>();

        //This is the calendar to get the time of your device.=
        calendar = Calendar.getInstance();

        //Set the onclick listener for the 'post feed' button
        feedButton = (Button) findViewById(R.id.postFeedButton);
        feedButton.setOnClickListener(this);

        //Declares the view for your feed
        ContactInfo contactInfo = new ContactInfo();

        //Set the layout and the RecyclerView
        recList = (RecyclerView) findViewById(R.id.cardList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ca = new ContactAdapter(list);
        //Set the adapter for the recyclerlist
        recList.setAdapter(ca);

    }

    //Method to open the dialog to post a feed
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View subView = inflater.inflate(R.layout.dialog_layout, null);
        subEditText = (EditText)subView.findViewById(R.id.dialogEditText);
        surNameText = (EditText)findViewById(R.id.surNameEditText);
        firstNameText = (EditText)findViewById(R.id.nameEditText);

//        final ImageView subImageView = (ImageView)subView.findViewById(R.id.image);
//        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//        subImageView.setImageDrawable(drawable);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("UPDATE");
        builder.setMessage("NEWS FEED");
        builder.setView(subView);

        //Build the AlertDialog.
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ContactInfo ci = new ContactInfo();
                ci.feed = subEditText.getText().toString();
                ci.surName = surNameText.getText().toString();
                ci.firstName = firstNameText.getText().toString();
                //Add data to the list
                list.add(ci);
                //Notify the Adapter so that you can see the changes.
                ca.notifyDataSetChanged();
                //Scroll the RecyclerView to the bottom.
                recList.smoothScrollToPosition(ca.getItemCount());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //This will close the Dialog
            }
        });

        builder.show();
    }

    @Override
    //Method for when you click on the post feed button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.postFeedButton:
                openDialog();
        }
    }

}
