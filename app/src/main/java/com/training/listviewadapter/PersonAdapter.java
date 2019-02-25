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

        // Get the data item for this position
        Person person = personList.get(position);

        // Check if an existing view is being reused, otherwise inflate the view
        View row = convertView;
        PersonAdapterViewHolder viewHolder;
        if (row == null) {
            // If there's no view to re-use, inflate a brand new view for row
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            viewHolder  = new PersonAdapterViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (PersonAdapterViewHolder) row.getTag();
        }

        setRow(person, viewHolder);

        // Return the completed view to render on screen
        return row;
    }

    private void setRow(Person person, PersonAdapterViewHolder viewHolder) {
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.nameTextView.setText(person.getName());
        viewHolder.ageTextView.setText(String.valueOf(person.getAge()));
        viewHolder.genderTextView.setText(person.getGender());
    }


    public static class PersonAdapterViewHolder {

        TextView nameTextView;
        TextView ageTextView;
        TextView genderTextView;

        public PersonAdapterViewHolder(View currentRow) {
            nameTextView = currentRow.findViewById(R.id.name_text_view);
            ageTextView = currentRow.findViewById(R.id.age_text_view);
            genderTextView = currentRow.findViewById(R.id.gender_text_view);
        }
    }
}
