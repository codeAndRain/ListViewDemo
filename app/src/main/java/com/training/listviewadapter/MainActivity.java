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

    private EditText name_editText;
    private EditText age_editText;
    private EditText gender_editText;
    private Button addButton;
    private Button resetButton;
    private Button removeButton;

    private List<Person> personList = new ArrayList<>();
    private PersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_editText = findViewById(R.id.name_Edit_Text);
        age_editText = findViewById(R.id.age_Edit_Text);
        gender_editText = findViewById(R.id.gender_Edit_Text);
        addButton = findViewById(R.id.add_button);
        resetButton = findViewById(R.id.reset_button);
        removeButton = findViewById(R.id.remove_button);

        adapter = new PersonAdapter(this, personList);
        setListAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddClicked();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_editText.setText("");
                age_editText.setText("");
                gender_editText.setText("");
            }
        });


        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = personList.size();
                adapter.remove(personList.get(count - 1));
//                personList.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void onAddClicked() {

        String name = name_editText.getText().toString();
        int age;
        String gender = gender_editText.getText().toString();

        String regexStr = "^[0-9]*$";

        if (name.isEmpty() && gender.isEmpty() && age_editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter Name, Age and Gender", Toast.LENGTH_LONG).show();
        } else if (name.isEmpty()) {
            Toast.makeText(this, "Please Enter Name", Toast.LENGTH_LONG).show();
        } else if (age_editText.getText().toString().isEmpty() || !age_editText.getText().toString().trim().matches(regexStr)) {
            Toast.makeText(this, "Please enter Age", Toast.LENGTH_LONG).show();
        } else if (gender.isEmpty()) {
            Toast.makeText(this, "Please enter Gender", Toast.LENGTH_SHORT).show();
        } else {
            age = Integer.parseInt(age_editText.getText().toString());
            personList.add(new Person(name, age, gender));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Person added successfully", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Person person = personList.get(position);
        Toast.makeText(this, person.getName() + " selected.", Toast.LENGTH_SHORT).show();
    }

}
