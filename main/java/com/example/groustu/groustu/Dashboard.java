package com.example.groustu.groustu;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This activity is the main page of the app. After logging in or registering,
 * this will be the page at which you can view other study groups and their
 * information as well as create new study groups or edit your user profile.
 */
public class Dashboard extends AppCompatActivity {

    ListView allGroups;
    ArrayList<String> studyGroups = new ArrayList<String>();
    ArrayList<String> studyGroupsTimes = new ArrayList<String>();
    SimpleAdapter adapter;
    BottomNavigationView BNV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BNV = findViewById(R.id.navigation);
        BNV.setSelectedItemId(R.id.action_go_dashboard);
        BNV.setLabelVisibilityMode(2);
        BNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_new_study_group:
                        startActivity(new Intent(Dashboard.this, CreateGroup.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_view_profile:
                        startActivity(new Intent(Dashboard.this, UserProfile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_go_dashboard:
                        startActivity(new Intent(Dashboard.this, Dashboard.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return true;
            }
        });

        /*
        All of this list stuff sets up and populates the list of study
        groups you see displayed. This well eventually pull from the SQL
        database to populate the list.
        */
        allGroups = findViewById(R.id.fullGroupList);
        for(int i = 10; i < 31; i++){
            studyGroups.add("MATH 1" + i);
        }
        for(int i = 10; i < 31; i++){
            studyGroupsTimes.add("01/01/2018 1:00PM - 4:00PM");
        }

        allGroups.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                startActivity(new Intent(Dashboard.this, ViewSGroup.class));
            }
        });

        ArrayList<Map<String, String>> listItems = new ArrayList<Map<String, String>>();
        for (int i = 0; i < studyGroups.size(); i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("group", studyGroups.get(i));
            datum.put("date", studyGroupsTimes.get(i));
            listItems.add(datum);
        }

        adapter = new SimpleAdapter(
                Dashboard.this,
                listItems,
                R.layout.textcenter,
                new String[] {"group", "date"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});


        allGroups.setAdapter(adapter);
    }
}
