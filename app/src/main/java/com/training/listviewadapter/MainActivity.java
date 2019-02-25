package com.training.listviewadapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private EditText selectedItemEditText;
    private Button addButton;

    private List<Person> personList = new ArrayList<>();
    private PersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedItemEditText = findViewById(R.id.section_text_view);

        addButton = findViewById(R.id.add_button);

        adapter = new PersonAdapter(this, personList);
        setListAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddClicked();
            }
        });
    }

    private void onAddClicked() {
        personList.add(new Person("Anthony Jones", 22, "M"));
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Person person = personList.get(position);
        Toast.makeText(this, person.getName() + " selected.", Toast.LENGTH_SHORT).show();
    }

    private List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));
        persons.add(new Person("Anthony Jones", 22, "M"));

        return persons;
    }
}
