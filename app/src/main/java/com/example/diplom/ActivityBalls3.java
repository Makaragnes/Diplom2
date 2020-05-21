package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityBalls3 extends AppCompatActivity {

    List<ResorsesForRow> resorsesForRowList = new ArrayList<>();
    private String[] names = {"Русский язык", "Математика", "Обществознание", "Биология", "Иностранный язык", "История", "Химия", "География", "Информатика", "Литература", "Физика"};
    private int[] images = {R.drawable.icons1, R.drawable.icons2, R.drawable.icons3, R.drawable.icons4, R.drawable.icons5, R.drawable.icons6, R.drawable.icons7, R.drawable.icons8, R.drawable.icons9, R.drawable.icons9, R.drawable.icons10, R.drawable.icons11};
    private static final String TAG = "log";
    SharedPreferences sharedPreferences;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balls3);

        button = findViewById(R.id.button);

        InitData();
        RecyclerView recyclerView = findViewById(R.id.list);
        DataAdapter adapter = new DataAdapter(this, resorsesForRowList);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                StringBuilder sumid = new StringBuilder();
                for(int i=0; i<11; i++){
                    String string = DataAdapter.resorsesForRowList.get(i).getEditTextValue();
                    int l = Integer.parseInt(string);


                    if(l>0 && l<=100){
                        sumid.append(i);
                        edit.putString(String.valueOf(i), string);
                        Log.d(TAG, String.valueOf(i));
                        Log.d(TAG, string);
                        Log.d(TAG, sumid.toString());
                        edit.apply();
                    }
                }
                edit.putString("sumid", sumid.toString());
                edit.apply();
                Intent intent = new Intent(ActivityBalls3.this, ActivityTown.class);
                startActivity(intent);
            }
        });
    }

    private void InitData(){
        for(int i=0; i<11; i++){
            resorsesForRowList.add(new ResorsesForRow(names[i], images[i], "0"));
        }
    }

//    private List<ResorsesForRow> populateList(){
//
//        List<ResorsesForRow> list = new ArrayList<>();
//
//        for (int i=0; i<11; i++){
//            String edit;
//
//            ResorsesForRow resorsesForRow = new ResorsesForRow(names[i], images[i], "");
//            resorsesForRow.setEditTextValue(String.valueOf(i));
//            Log.d(TAG, resorsesForRow.getEditTextValue());
//
//        }
//
//
//        return list;
//    }
}
