package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityCheckBalls extends AppCompatActivity {

    private static final String TAG = "log";
    public EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    SharedPreferences sharedPreferences;
    String string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11;
    int pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10, pass11;
    int sumballs;

    private Boolean flag=false;  // Флаг указывающий что если хоть одно число больше 100 то нихера перехода не будет

    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balls);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        String string = sharedPreferences.getString("responce", "");

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    Intent intent = new Intent(ActivityCheckBalls.this, ActivityTown.class);
                    startActivity(intent);
                }
            }
        });

        editText1 = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.edittext2);
        editText3 = findViewById(R.id.edittext3);
        editText4 = findViewById(R.id.edittext4);
        editText5 = findViewById(R.id.edittext5);
        editText6 = findViewById(R.id.edittext6);
        editText7 = findViewById(R.id.edittext7);
        editText8 = findViewById(R.id.edittext8);
        editText9 = findViewById(R.id.edittext9);
        editText10 = findViewById(R.id.edittext10);
        editText11 = findViewById(R.id.edittext11);

        string1 = editText1.getText().toString();
        pass1 = Integer.parseInt(string1);

        string2 = editText2.getText().toString();
        pass2 = Integer.parseInt(string2);

        string3 = editText3.getText().toString();
        pass3 = Integer.parseInt(string3);

        string4 = editText4.getText().toString();
        pass4 = Integer.parseInt(string4);

        string5 = editText5.getText().toString();
        pass5 = Integer.parseInt(string5);

        string6 = editText6.getText().toString();
        pass6 = Integer.parseInt(string6);

        string7 = editText7.getText().toString();
        pass7 = Integer.parseInt(string7);

        string8 = editText8.getText().toString();
        pass8 = Integer.parseInt(string8);

        string9 = editText9.getText().toString();
        pass9 = Integer.parseInt(string9);

        string10 = editText10.getText().toString();
        pass10 = Integer.parseInt(string10);

        string11 = editText11.getText().toString();
        pass11 = Integer.parseInt(string11);
        Log.d(TAG, string1);

        if( pass1>100 || pass2>100 || pass3>100 || pass4>100 || pass5>100 || pass6>100 || pass7>100 || pass8>100 || pass9>100 || pass10>100 || pass11>100)
        {
            flag = false;
        } else {
            flag = true;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if( pass1!=0){
                editor.putString("rus", string1);
            }
            if( pass2!=0){
                editor.putString("math", string2);
            }
            if( pass3!=0){
                editor.putString("obh", string3);
            }
            if( pass4!=0){
                editor.putString("bio", string4);
            }
            if( pass5!=0){
                editor.putString("eng", string5);
            }
            if( pass6!=0){
                editor.putString("his", string6);
            }
            if( pass7!=0){
                editor.putString("xim", string7);
            }
            if( pass8!=0){
                editor.putString("geo", string8);
            }
            if( pass9!=0){
                editor.putString("inf", string9);
            }
            if( pass10!=0){
                editor.putString("lit", string10);
            }
            if( pass11!=0){
                editor.putString("phi", string11);
            }
            editor.apply();


        }
    }
}
