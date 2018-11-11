package com.example.groustu.groustu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Button;

public class ViewSGroup extends AppCompatActivity {

    ListView list;
    ArrayList<String> studyGroups = new ArrayList<String>(); //member names
    ArrayList<String> stimes = new ArrayList<String>(); //subtitle if needed later
    ArrayList<String> slocations = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();

    /**
     * Once the ViewSGroup screen is on, this will start.
     * Writes the group name, description, time, and location. Final version
     * will grab the information from a database, but
     * since no database yet, the XML resource file is used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sgroup);
        final TextView grouptext = (TextView) findViewById(R.id.groupname);
        final TextView locationtext = (TextView) findViewById(R.id.location);
        final TextView timetext = (TextView) findViewById(R.id.time);
        final TextView desctext = (TextView) findViewById(R.id.description);

        /**
         * Would normally get the information on the studygroup here
         * but since no database or working dataset, simply grabbed
         * items from the XML resource file
         */

        grouptext.setText(R.string.groupname);
        locationtext.setText(R.string.location);
        timetext.setText(R.string.time);
        desctext.setText(R.string.description);

        /**
         * Clicking on this button moves the user back to the same page.
         * Once finished, this button should disappear or there would be
         * a boolean to determine whether the user is already in the group
         * to change the state.
         */

        final Button joingroup = findViewById(R.id.joinGroup);
        joingroup.setText((((MyApp)this.getApplication()).inGroup()) ? "LEAVE GROUP" : "JOIN GROUP");
        joingroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 //Code here executes on main thread after user presses button
                fixGroup();
                startActivity(new Intent(ViewSGroup.this, ViewSGroup.class));
            }
        });

        /**
         * Clicking on this button moves the user to the ViewMembers page
         */
        final Button viewmems = findViewById(R.id.ViewMembers);
        viewmems.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                startActivity(new Intent(ViewSGroup.this, ViewMembers.class));
            }
        });
    }

    private void fixGroup(){
        if(((MyApp)this.getApplication()).inGroup()) {
            ((MyApp)this.getApplication()).setInGroup(false);
        } else {
            ((MyApp)this.getApplication()).setInGroup(true);
        }
    }
}