package com.example.diplom;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private static final String TAG = "log";
    SharedPreferences sharedPreferences;
    Context context;
    private LayoutInflater inflater;
    private List<ResorsesForRow> resorsesForRowList;

    DataAdapter(Context context, List<ResorsesForRow> resorsesForRowList){
        this.resorsesForRowList = resorsesForRowList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_listview, parent, false);
        ViewHolder vh = new ViewHolder(view, new MyCustomEditTextListener());
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
        ResorsesForRow resorsesForRow = resorsesForRowList.get(position);

        holder.imageView.setImageResource(resorsesForRow.getImg());
        holder.textView.setText(resorsesForRow.getName());
        holder.editText.setText("3");

    }

    @Override
    public int getItemCount() {
        return resorsesForRowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final EditText editText;
        final ImageView imageView;
        final TextView textView;
        public MyCustomEditTextListener myCustomEditTextListener;

        ViewHolder(View view, MyCustomEditTextListener myCustomEditTextListener){
            super(view);
            imageView = view.findViewById(R.id.image_view);
            textView = view.findViewById(R.id.name);
            editText = view.findViewById(R.id.edittext);
        }
    }

    private class MyCustomEditTextListener implements TextWatcher {
        private int position;

        void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d(TAG, charSequence.toString());
            Log.d(TAG, String.valueOf(position));
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }
}
