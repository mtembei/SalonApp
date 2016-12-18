package com.patrickmukiira.salonapp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CategoriesAdapter extends ArrayAdapter {
    List list= new ArrayList<>();
    public CategoriesAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Categories object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_phoneNo = (TextView)row.findViewById(R.id.tx_phoneNo);
            contactHolder.tx_hair = (TextView)row.findViewById(R.id.tx_hair);
            contactHolder.tx_massage = (TextView)row.findViewById(R.id.tx_massage);
            contactHolder.tx_others = (TextView)row.findViewById(R.id.tx_others);
            contactHolder.tx_time= (TextView)row.findViewById(R.id.tx_time);
            row.setTag(contactHolder);


        }
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        Categories categories = (Categories) this.getItem(position);
        contactHolder.tx_name.setText(categories.getName());
        contactHolder.tx_phoneNo.setText(categories.getPhone_number());
        contactHolder.tx_hair.setText(categories.getHair());
        contactHolder.tx_massage.setText(categories.getMassage());;
        contactHolder.tx_others.setText(categories.getOthers());;
        contactHolder.tx_time.setText(categories.getTime());;
        return row;
    }
    static class  ContactHolder
    {
        TextView tx_name,tx_phoneNo,tx_hair,tx_massage,tx_others,tx_time;
    }
    }
