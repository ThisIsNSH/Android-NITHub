package com.travis.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
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
        setContentView(R.layout.announce);
        list = new ArrayList<>();
        calendar = Calendar.getInstance();
        feedButton = (Button) findViewById(R.id.postFeedButton);
        feedButton.setOnClickListener(this);
        ContactInfo contactInfo = new ContactInfo();
        recList = (RecyclerView) findViewById(R.id.cardList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ca = new ContactAdapter(list);
        recList.setAdapter(ca);

    }
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(announce.this);
        View subView = inflater.inflate(R.layout.dialog_layout, null);
        subEditText = (EditText)subView.findViewById(R.id.dialogEditText);
        surNameText = (EditText)findViewById(R.id.surNameEditText);
        firstNameText = (EditText)findViewById(R.id.nameEditText);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("UPDATE");
        builder.setMessage("NEWS FEED");
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ContactInfo ci = new ContactInfo();
                ci.feed = subEditText.getText().toString();
                ci.surName = surNameText.getText().toString();
                ci.firstName = firstNameText.getText().toString();
                list.add(ci);
                ca.notifyDataSetChanged();
                recList.smoothScrollToPosition(ca.getItemCount());
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.postFeedButton:
                openDialog();
        }
    }

}