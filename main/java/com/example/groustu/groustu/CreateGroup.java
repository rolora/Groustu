package com.example.groustu.groustu;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateGroup extends AppCompatActivity {

    BottomNavigationView BNV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        connectToDatabase();

        BNV = findViewById(R.id.navigation);
        BNV.setSelectedItemId(R.id.action_new_study_group);
        BNV.setLabelVisibilityMode(2);
        BNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.action_new_study_group:
                        startActivity(new Intent(CreateGroup.this, CreateGroup.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_view_profile:
                        startActivity(new Intent(CreateGroup.this, UserProfile.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.action_go_dashboard:
                        startActivity(new Intent(CreateGroup.this, Dashboard.class));
                        overridePendingTransition(0, 0);
                        break;
                }
                return true;
            }
        });
    }

    public void connectToDatabase(){
        try {

            // SET CONNECTIONSTRING
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String groupName = "testeroni";
            Connection DbConn = DriverManager.getConnection("jdbc:jtds:sqlserver://129.22.23.215:1433/GroustuApp;name=" + groupName);

            Log.w("Connection","open");
            Statement stmt = DbConn.createStatement();
            ResultSet reset = stmt.executeQuery(" select * from name ");

            EditText num = (EditText) findViewById(R.id.displayMessage);
            num.setText(reset.getString(1));

            DbConn.close();

        } catch (Exception e)
        {
            Log.w("Error connection","" + e.getMessage());
        }
    }

}
