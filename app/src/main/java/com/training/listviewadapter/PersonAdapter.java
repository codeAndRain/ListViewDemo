package com.training.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        super(context, R.layout.list_item_layout, personList);
        this.personList = personList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Person person = personList.get(position);

        View row = convertView;

        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        setRow(person, row);

        return row;
    }

    private void setRow(Person person, View row) {
        TextView nameTextView = row.findViewById(R.id.name_text_view);
        nameTextView.setText(person.getName());

        TextView ageTextView = row.findViewById(R.id.age_text_view);
        ageTextView.setText(String.valueOf(person.getAge()));

        TextView genderTextView = row.findViewById(R.id.gender_text_view);
        genderTextView.setText(person.getGender());
    }
}
