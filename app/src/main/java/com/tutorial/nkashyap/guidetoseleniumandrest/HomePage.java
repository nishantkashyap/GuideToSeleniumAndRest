package com.tutorial.nkashyap.guidetoseleniumandrest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class HomePage extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get the view from home page activity
        setContentView(R.layout.activity_home_page);

        // Locate the buttons in activity_home_page.xml
        Button selButton = (Button) findViewById(R.id.selButton);
        Button notesButton = (Button) findViewById(R.id.notes);
        //Button restButton = (Button) findViewById(R.id.restButton);


        // Capture button click for selenium basic
        selButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start a new activity class for selenium Questions page
                Intent selIntent = new Intent(HomePage.this,SeleniumTutQuestions.class);
                startActivity(selIntent);

            }
        });

        // Capture button click for rest tutorial
//        restButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //start a new activity class for REST Questions page
//                Intent restIntent = new Intent(HomePage.this,RestBasicQuestions.class);
//                startActivity(restIntent);
//
//            }
//        });


        // Capture button click for rest tutorial
        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start a new activity class for REST Questions page
                Intent restIntent = new Intent(HomePage.this,Notepadv2.class);
                startActivity(restIntent);

            }
        });

    }





}
