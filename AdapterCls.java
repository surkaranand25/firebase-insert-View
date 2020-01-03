package com.example.fireinsert;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterCls extends ArrayAdapter<Item> {

    Activity activity;
    List<Item> list;

    public AdapterCls(Activity activity, List<Item> list) {
        super(activity, R.layout.layout_items, list);
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.layout_items, null, true);

        TextView name = (TextView) convertView.findViewById(R.id.txt_name);
        TextView email = (TextView) convertView.findViewById(R.id.txt_email);
        TextView contact = (TextView) convertView.findViewById(R.id.txt_contact);

        Item item = list.get(position);

        name.setText(item.getName());
        email.setText(item.getEmail());
        contact.setText(item.getContact());

        return convertView;
    }
}
