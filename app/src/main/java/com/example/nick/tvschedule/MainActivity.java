package com.example.nick.tvschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvItems;
    ShowAdapter itemsAdapter;
    ArrayList<Show> showList = new ArrayList<Show>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up Listview adapters
        lvItems = (ListView)findViewById(R.id.lv_shows);
        itemsAdapter = new ShowAdapter(this, showList);
        lvItems.setAdapter(itemsAdapter);

        tvAPI tv1 = new tvAPI(this);

    }

    public void onAddShow(View v){
        // get text from textbox and add show to
        EditText etShow = (EditText)findViewById(R.id.et_show);
        String newShow = etShow.getText().toString();

        // check added show is not default edit text string
        if(newShow.isEmpty() || newShow.equals(getString(R.string.et_show_default)))
            return;

        showList.add(new Show(newShow));

        // clear Text button
        etShow.setText("");

        //TODO Call show update
    }


    // Clear text on context change.
    public void onShowEditTextClick(View v){
        EditText etShow = (EditText)findViewById(R.id.et_show);
        etShow.setText("");
    }
}
