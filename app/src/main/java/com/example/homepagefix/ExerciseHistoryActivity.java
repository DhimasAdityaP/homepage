package com.example.homepagefix;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseHistoryActivity extends AppCompatActivity{
    private ExerciseDatabaseHelper dbHelper;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_history);

        dbHelper = new ExerciseDatabaseHelper(this);
        displayExerciseHistory();
    }

    private void displayExerciseHistory() {
        Cursor cursor = dbHelper.getAllExercises();

        String[] fromColumns = {ExerciseDatabaseHelper.COLUMN_NAME, ExerciseDatabaseHelper.COLUMN_DATE, ExerciseDatabaseHelper.COLUMN_TIME};
        int[] toViews = {R.id.textExerciseName, R.id.textExerciseDate, R.id.textExerciseTime};

        adapter = new SimpleCursorAdapter(this, R.layout.item_exercise, cursor, fromColumns, toViews, 0);
        ListView listView = findViewById(R.id.listViewExercises);
        listView.setAdapter(adapter);
    }
}

