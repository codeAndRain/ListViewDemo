package com.training.listviewadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private TextView selectedItemTextView;

    private static final String[] items = {"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedItemTextView = findViewById(R.id.section_text_view);

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedItem = items[position];
        selectedItemTextView.setText(selectedItem);
    }
}
