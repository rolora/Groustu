package com.example.groustu.groustu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    Button dboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        //avatars by <a href="https://www.freepik.com/free-vector/character-faces-icons_777192.htm">Designed by Skydesign</a>

        ImageView imageView = findViewById(R.id.uProfileuAvatar);
        if (((MyApp)this.getApplication()).getUserAvatar().equals("Avatar1")) {
            imageView.setImageResource(R.drawable.avatar1);
        } else {
            imageView.setImageResource(R.drawable.avatar2);
        }

        String uName = ((MyApp)this.getApplication()).getUName();
        String uDescription = ((MyApp)this.getApplication()).getUserDescription();

        TextView uProfileuNameView = (TextView)findViewById(R.id.uProfileuName);
        uProfileuNameView.setText(uName);

        TextView uProfileUDescriptionView = (TextView)findViewById(R.id.uProfileuDescription);
        uProfileUDescriptionView.setText(uDescription);

        dboardButton = findViewById(R.id.uProfileButton);

        dboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfile.this, Dashboard.class));
            }
        });
    }
}
