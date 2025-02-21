package com.example.counterapp.ListViewExample.MultiColumnListViewExample;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.counterapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class my_multi_column_list_adapter extends BaseAdapter {
    Activity activity;
    public ArrayList<HashMap<String,String>> list;

    public my_multi_column_list_adapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        this.activity = activity;
        this.list = list;
    }

    public static final String First_Column = "First Column";
    public static final String Second_Column = "Second Column";
    public static final String Third_Column = "Third Column";
    public static final String Fourth_Column = "Fourth Column";

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = activity.getLayoutInflater();
        if (view == null){
            view = inflater.inflate(R.layout.multicolumnlistview, null);
            viewHolder.textViewFirst = view.findViewById(R.id.txtlistfirst);
            viewHolder.textViewSecond = view.findViewById(R.id.txtlistsecond);
            viewHolder.textViewThird = view.findViewById(R.id.txtlistthird);
            viewHolder.textViewFourth = view.findViewById(R.id.txtlistfourth);
            view.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        HashMap<String, String> hashMap = list.get(i);
        viewHolder.textViewFirst.setText(First_Column);
        viewHolder.textViewFirst.setText(Second_Column);
        viewHolder.textViewFirst.setText(Third_Column);
        viewHolder.textViewFirst.setText(Fourth_Column);
        return view;
    }

    public class ViewHolder{
        TextView textViewFirst, textViewSecond, textViewThird, textViewFourth;

    }
}
