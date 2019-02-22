package com.training.listviewadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private EditText selectedItemEditText;
    private Button addButton;

    private List<String> items = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedItemEditText = findViewById(R.id.section_text_view);

        addButton = findViewById(R.id.add_button);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = selectedItemEditText.getText().toString();
                if (!text.isEmpty()) {
                    onAddClicked(text);
                }
            }
        });
    }

    private void onAddClicked(String text) {
        items.add(text);
        adapter.notifyDataSetChanged();
        selectedItemEditText.setText("");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
            String selectedItem = items.get(position);
            selectedItemEditText.setText(selectedItem);
    }
}
