package com.example.homepagefix;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<String> {

    public ExerciseAdapter(@NonNull Context context, @NonNull List<String> exercises) {
        super(context, 0, exercises);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_exercise, parent, false);
        }

        // Get the current exercise from the adapter
        String currentExercise = getItem(position);

        // Find the TextView in the list_item_exercise.xml layout with the ID textViewExerciseName
        TextView exerciseTextView = listItemView.findViewById(R.id.textViewExerciseName);

        // Set the exercise name on the TextView
        exerciseTextView.setText(currentExercise);

        // Return the whole list item layout (containing 1 TextView)
        return listItemView;
    }
}


