package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.view.Gravity.RIGHT;


public class Samlpe extends AppCompatActivity {

    private static final String TAG = "LOG";
    private String mJSONURLString = "https://myrik8333.github.io/test.json";
    private FrameLayout frameLayout;
    SharedPreferences sharedPreferences;
    private ListView listView;
    //private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samlpe);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String string = sharedPreferences.getString("responce", "");

        frameLayout = findViewById(R.id.FrameRoot);
        listView = findViewById(R.id.listview);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Samlpe.this, Vus.class);
                intent.putExtra("id", String.valueOf(position));
                startActivity(intent);
            }
        });

        try {
            final JSONObject object = new JSONObject(string);
            final JSONObject object1 = object.getJSONObject("response");

            String count = object1.getString("count");
            //Log.d(TAG, count);
            JSONArray array = object1.getJSONArray("items");

            for( int i=0; i<array.length(); ++i) {

                JSONObject item = array.getJSONObject(i);
                //Log.d(TAG, item.toString());
                String id = item.getString("id");
                //Log.d(TAG, id);
                String title = item.getString("title"); // Название вуза
                list.add(title);
                adapter.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }





}
