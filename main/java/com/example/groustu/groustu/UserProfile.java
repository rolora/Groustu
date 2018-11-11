package com.example.groustu.groustu;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UserProfile extends AppCompatActivity {

    BottomNavigationView BNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        BNV = findViewById(R.id.navigation);
        BNV.setSelectedItemId(R.id.action_view_profile);
        BNV.setLabelVisibilityMode(2);
        BNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_new_study_group:
                        startActivity(new Intent(UserProfile.this, CreateGroup.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_view_profile:
                        startActivity(new Intent(UserProfile.this, UserProfile.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_go_dashboard:
                        startActivity(new Intent(UserProfile.this, Dashboard.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return true;
            }
        });
    }
}
