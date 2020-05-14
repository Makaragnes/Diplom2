package com.example.diplom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForList extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;

    ArrayList<ResorsesForRow> list;

    AdapterForList(Context context, ArrayList<ResorsesForRow> list){
        context = context;
        list = list;
        layoutInflater = (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();     // Общее кол-во элиментов
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = layoutInflater.inflate(R.layout.row_for_listview, parent, false);
        }

        ResorsesForRow resorsesForRow = getResorsessForRow(position);

        view.findViewById(R.id.bellowtext);
        view.findViewById(R.id.maintext);
        CheckBox checkBox = view.findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        checkBox.setTag(position);
        //checkBox.setChecked(resorsesForRow.);
        return view;
    }

    ResorsesForRow getResorsessForRow(int position) {
        return (ResorsesForRow) getItem(position);
    }

//    ArrayList<ResorsesForRow> getList(){
//        ArrayList<ResorsesForRow> list = new ArrayList<ResorsesForRow>();
//        for (ResorsesForRow resorsesForRow : list){
//
//        }
//    }

}
