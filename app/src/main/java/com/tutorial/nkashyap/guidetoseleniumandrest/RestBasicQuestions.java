package com.tutorial.nkashyap.guidetoseleniumandrest;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;


public class RestBasicQuestions extends Activity {

    // List view
    public ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    protected String[] questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_basic_questions);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        // Listview Data
        questions = getResources().getStringArray(R.array.restBQ);

        lv = (ListView) findViewById(R.id.list_view_rest);
        inputSearch = (EditText) findViewById(R.id.inputSearch_rest);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.question, questions);
        lv.setAdapter(adapter);

        // ListView Item Click Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent answerIntent = new Intent(RestBasicQuestions.this,RestBasicAnswer.class);
                String item_selected = (String) adapterView.getAdapter().getItem(position);
                Log.i("#####Item Selected: ", item_selected);
                int get_selected_item_position = Arrays.asList(questions).indexOf(item_selected);
                Log.i("#####Item index from view list: " ,"position VAL(index+1):: " + (get_selected_item_position +1));
                Toast.makeText(getApplicationContext(), "Selected question:" + item_selected, Toast.LENGTH_SHORT).show();
                answerIntent.putExtra("qposition1", get_selected_item_position);
                startActivity(answerIntent);
            }
        });

        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                RestBasicQuestions.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

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
