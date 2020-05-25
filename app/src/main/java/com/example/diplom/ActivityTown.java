package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTown extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private Button button;
    private CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String string = sharedPreferences.getString("responce", "");
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("mos");
        editor.remove("pit");
        editor.remove("kas");

        button = findViewById(R.id.button);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("mos", "1");
                    editor.apply();
                }
                else editor.remove("mos");
                editor.apply();
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("pit", "0");
                    editor.apply();
                }
                else editor.remove("pit");
                editor.apply();
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editor.putString("kas", "2");
                    editor.apply();
                }
                else editor.remove("kas");
                editor.apply();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTown.this, Sample2.class);
                startActivity(intent);
            }
        });
    }
}
