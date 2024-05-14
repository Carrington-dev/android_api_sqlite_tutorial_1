package com.stemgon.stemly.contacts.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stemgon.stemly.R;

public class ContactHolder extends RecyclerView.ViewHolder {
    public TextView fullName;
    public TextView dateView, fullDate;
    public TextView tagline;
    public ImageView contactIcon;
    public ContactHolder(@NonNull View itemView) {
        super(itemView);

        fullName = itemView.findViewById(R.id.fullName);
        tagline = itemView.findViewById(R.id.tagline);
        dateView = itemView.findViewById(R.id.dateView);
        fullDate = itemView.findViewById(R.id.fullDate);
        contactIcon = itemView.findViewById(R.id.iconContact);
    }
}
