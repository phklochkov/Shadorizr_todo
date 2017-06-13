package com.example.renchan.shadorizr_todo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by renchan on 05.06.17.
 */

public class MainActivity extends Activity {
    private final ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        addKeyboardHandler();
    }

    public void onAddTodo(View view) {
        addTodo();
    }

    private void addKeyboardHandler() {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        keyCode == KeyEvent.KEYCODE_ENTER) {
                    addTodo();
                    return true;
                }
                return false;
            }
        });

    }

    private void addTodo() {
        Editable text = ((EditText) findViewById(R.id.editText)).getText();
        list.add(text.toString());
        text.clear();
        adapter.notifyDataSetChanged();
    }
}
