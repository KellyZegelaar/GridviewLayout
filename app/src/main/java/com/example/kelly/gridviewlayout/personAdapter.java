package com.example.kelly.gridviewlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kelly on 23-3-2018.
 */

public class personAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflator;
    private ArrayList<Person> persons;


    public personAdapter(Context mContext, LayoutInflater mInflator, ArrayList<Person> persons) {
        this.mContext = mContext;
        this.mInflator = mInflator;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null){
            view = mInflator.inflate(R.layout.gridview_object, null);

            viewHolder = new ViewHolder();

            viewHolder.name = view.findViewById(R.id.name);

            view.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Person person = persons.get(i);

        viewHolder.name.setText(person.getName());

        return view;
    }

    public static class ViewHolder{
        public TextView name;
    }
}
