package com.tutorial.nkashyap.guidetoseleniumandrest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class RestBasicAnswer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_basic_answer);

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Get ListView object from xml
        TextView textView = (TextView) findViewById(R.id.answer1);

        String[] answers = getResources().getStringArray(R.array.restBA);

        int pos = getIntent().getIntExtra("qposition1", 0);

        textView.setText(answers[pos]);

        ActionBar actionBar = getActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        onBackPressed();
        return true;
    }
}