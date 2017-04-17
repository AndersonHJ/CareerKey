package com.smartphone.neu.CareerKey;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by houjian on 3/31/17.
 */

public class ListItemAdapter extends ArrayAdapter<EventItem> {
    List<EventItem> list;
    Context context;



    public ListItemAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<EventItem> objects) {
        super(context, resource, textViewResourceId, objects);
        this.list = objects;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.event_item, parent, false);

        TextView title = (TextView) rowView.findViewById(R.id.title_item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.pic_item);
        TextView time = (TextView) rowView.findViewById(R.id.time_item);
        TextView description = (TextView) rowView.findViewById(R.id.disc_item);


        title.setText(list.get(position).getTitle());
        //imageView.setBackgroundColor();
        time.setText(list.get(position).getStartTime());
        description.setText(list.get(position).getDescription());


        return rowView;

    }


}
