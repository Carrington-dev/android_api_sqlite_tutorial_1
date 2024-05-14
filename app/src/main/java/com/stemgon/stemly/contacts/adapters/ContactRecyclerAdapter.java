package com.stemgon.stemly.contacts.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stemgon.stemly.R;
import com.stemgon.stemly.contacts.holders.ContactHolder;
import com.stemgon.stemly.contacts.models.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactHolder> {
    ArrayList<Contact> contacts;
    Context context;

    public ContactRecyclerAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactHolder(LayoutInflater.from(context).inflate(R.layout.single_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        holder.fullName.setText(contacts.get(position).getFullName());
        holder.tagline.setText(contacts.get(position).getTagline());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd");
        String dateTime = simpleDateFormat.format(contacts.get(position).getCreatedAt()).toString();
        holder.dateView.setText(dateTime);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE dd, MMM yyyy");
        String dateTime2 = simpleDateFormat2.format(contacts.get(position).getCreatedAt()).toString();
        holder.fullDate.setText(dateTime2);
//        holder.tagline.setText("Senior Software Engineer Position");

        holder.contactIcon.setImageResource(R.drawable.baseline_done_24);
//        Log.d("INFO", contacts.get(position).getTagline());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
