package com.travis.myapplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import com.travis.myapplication.Classes.ContactInfo;
import androidstudioexamples.facebookfeed.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Calendar calendar = Calendar.getInstance();
        ContactInfo ci = contactList.get(i);
        //Set the text of the feed with your data
        contactViewHolder.feedText.setText(ci.feed);
        contactViewHolder.surNameText.setText(ci.surName);
        contactViewHolder.nameText.setText(ci.firstName);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }



    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView feedText;
        protected TextView nameText;
        protected TextView surNameText;
        protected TextView feedDate;

        public ContactViewHolder(View v) {
            super(v);
            feedText =  (TextView) v.findViewById(R.id.feedText);
            surNameText =  (TextView) v.findViewById(R.id.surName);
            nameText =  (TextView) v.findViewById(R.id.name);
        }
    }
}

