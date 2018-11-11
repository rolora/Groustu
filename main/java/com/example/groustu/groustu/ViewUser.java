package com.example.groustu.groustu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class displays all the user information on the name that user clicks
 * Includes username, description, and avatar
 */

public class ViewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        // Get the Intent that started this activity from ViewMembers and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ViewMembers.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView userNameView = findViewById(R.id.textViewUsername);
        userNameView.setText(message);

        // Manually set all users
        User[] users = new User[3];
        for (int i = 0; i < 3; i++) {
            users[i] = new User();
        }
        users[0].setUname("Abby");
        users[0].setUserDescription("A first year pre-med student majoring in BME");
        users[1].setUname("Bob");
        users[1].setUserDescription("A sophomore with undecided major taking classes in all departments");
        users[2].setUname("Chris");
        users[2].setUserDescription("A junior majoring in Psychology planning to be a social worker");

        // Display description
        TextView descriptionView = findViewById(R.id.textViewUserDescription);
        boolean found = false;
        // find user with that username
        for (int i = 0; i < 3; i++) {
            if (users[i].getUname().equals(message)) {
                descriptionView.setText(users[i].getUserDescription());
                found = true;
            }
        }
        // If cannot find user, display "User not found"
        if (!found) {
            String description = "User not found";
            descriptionView.setText(description);
        }

        // Display User Avatar
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setContentDescription("HELLO");
        imageView.setImageResource(R.drawable.picture);
    }
}