package com.tutorial.nkashyap.guidetoseleniumandrest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;


public class SeleniumTutAnswer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selenium_tut_answer);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Get ListView object from xml
        TextView textView = (TextView) findViewById(R.id.answer);

        TextView question_textview = (TextView) findViewById(R.id.q_answer);

        String[] answers = getResources().getStringArray(R.array.seleniumBA);

        int pos = getIntent().getIntExtra("qposition",0);

        question_textview.setTextSize(15);
        question_textview.setText(getIntent().getStringExtra("question"));

        textView.setTextSize(16);

        textView.setText(answers[pos]);

        ActionBar actionBar = getActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        onBackPressed();
        return true;
    }
}
