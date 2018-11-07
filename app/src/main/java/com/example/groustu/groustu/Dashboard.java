package com.example.groustu.groustu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
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

    ListView list;
    ArrayList<String> studyGroups = new ArrayList<String>();
    ArrayList<String> studyGroupsTimes = new ArrayList<String>();
    SimpleAdapter adapter;
    ImageButton profileIcon;
    ImageButton createGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /*
        All of this profileIcon stuff sets up the icon and informs it of where
        clicking it needs to make the user go (the user profile page).
        */
        profileIcon = findViewById(R.id.userIcon);
        profileIcon.setBackgroundColor(Color.WHITE);
        profileIcon.setImageResource(R.drawable.icon);
        profileIcon.setContentDescription("profile icon");

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, UserProfile.class));
            }
        });

        /*
        All of this createGroup stuff sets up the icon and informs it of where
        clicking it needs to make the user go (the create group page).
        */
        createGroup = findViewById(R.id.cGroupIcon);
        createGroup.setBackgroundColor(Color.BLACK);
        createGroup.setContentDescription("create group icon");

        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, CreateGroup.class));
            }
        });

        /*
        All of this list stuff sets up and populates the list of study
        groups you see displayed. This well eventually pull from the SQL
        database to populate the list.
        */
        list = findViewById(R.id.groupList);
        for(int i = 10; i < 31; i++){
            studyGroups.add("MATH 1" + i);
        }
        for(int i = 10; i < 31; i++){
            studyGroupsTimes.add("01/01/2018 1:00PM - 4:00PM");
        }


        list.setOnItemClickListener(new OnItemClickListener() {
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
                android.R.layout.simple_list_item_2,
                new String[] {"group", "date"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});


        list.setAdapter(adapter);
    }
}
