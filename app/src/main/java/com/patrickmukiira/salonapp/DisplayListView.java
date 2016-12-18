package com.patrickmukiira.salonapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    CategoriesAdapter categoriesAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);
        listView = (ListView) findViewById(R.id.listview);
        categoriesAdapter = new CategoriesAdapter(this, R.layout.row_layout);
        listView.setAdapter(categoriesAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;
            String name, phone_number, hair, massage, others,time;
            while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                name = JO.getString("name");
                phone_number = JO.getString("phone_number");
                hair = JO.getString("hair");
                massage = JO.getString("massage");
                others = JO.getString("others");
                time = JO.getString("time");
                Categories categories = new Categories(name, phone_number, hair, massage, others,time);
                categoriesAdapter.add(categories);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
