package com.example.nick.tvschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nick on 15/03/17.
 */

public class ShowAdapter extends ArrayAdapter<Show> {

    public ShowAdapter(Context context, ArrayList<Show> shows){
     super(context, 0, shows);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Show shows = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView showName = (TextView) convertView.findViewById(android.R.id.text1);

        showName.setText(shows.name());

        return convertView;

    }
}
