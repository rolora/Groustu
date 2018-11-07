package com.example.groustu.groustu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewMembers extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_members);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Linking this to the ViewUser class
        Intent intent = new Intent(this, ViewUser.class);
        EditText editText = (EditText) findViewById(R.id.textView2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}