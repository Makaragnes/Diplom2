package com.example.diplom;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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

import static android.view.Gravity.RIGHT;


public class Samlpe extends AppCompatActivity {

    private static final String TAG = "LOG";
    private String mJSONURLString = "https://myrik8333.github.io/test.json";
    private FrameLayout frameLayout;


    //private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samlpe);

        frameLayout = findViewById(R.id.FrameRoot);

        final ScrollView scrollView = new ScrollView(getApplicationContext());
        frameLayout.addView(scrollView);

        scrollView.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));



        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {

                        LinearLayout linearLayout1 = new LinearLayout(getApplicationContext());
                        linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        linearLayout1.setOrientation(LinearLayout.VERTICAL);

                        scrollView.addView(linearLayout1);

                        Log.d(TAG, "sfdfsdf");
                        try {
                            final JSONObject object = new JSONObject(response.toString());
                            JSONObject object1 = object.getJSONObject("response");
                            String count = object1.getString("count");
                            Log.d(TAG, count);
                            JSONArray array = object1.getJSONArray("items");

                            for( int i=0; i<array.length(); ++i){
//                                LinearLayout linearLayoutrow = new LinearLayout(getApplicationContext());
//                                linearLayout1.addView(linearLayoutrow);
//                                linearLayoutrow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                                linearLayoutrow.setOrientation(LinearLayout.HORIZONTAL);
//                                //linearLayoutrow.setGravity(RIGHT);
//                                linearLayoutrow.setPadding(16,16,16,16);


                                JSONObject item = array.getJSONObject(i);
                                Log.d(TAG, item.toString());
                                String id = item.getString("id");
                                Log.d(TAG, id);
                                String title = item.getString("title");
                                TextView textView = new TextView(getApplicationContext());
                                linearLayout1.addView(textView);
                                textView.append("Название Института " + title);
                                Log.d(TAG, title);
//                                    String medium = item.getString("medium");
//                                    Log.d(TAG, medium);
                                JSONArray faculties = item.getJSONArray("faculties");

                                for( int j=0; j<faculties.length(); ++j){
                                    JSONObject facultet = faculties.getJSONObject(j);
                                    String id2 = facultet.getString("id");

                                    String title2 = facultet.getString("title");
                                    TextView textView2 = new TextView(getApplicationContext());
                                    linearLayout1.addView(textView2);
                                    textView2.setText("Название факультета " + title2);
                                    String medium = facultet.getString("medium");

                                    JSONArray subjects = facultet.optJSONArray("subjects");

                                    for( int k=0; k<subjects.length(); ++k){
                                        JSONObject subject = subjects.getJSONObject(k);
                                        String id3 = subject.getString("id");
                                        Log.d(TAG, id3);
                                        String discipline = subject.getString("discipline");
                                        TextView textView3 = new TextView(getApplicationContext());
                                        linearLayout1.addView(textView3);
                                        textView3.append("Экзамен ЕГЭ " + k + " " + discipline);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);

    }


}
