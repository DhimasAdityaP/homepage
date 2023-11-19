package com.example.homepagefix;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Mainactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data olahraga
        ArrayList<String> exercises = new ArrayList<>();
        exercises.add("Push-up");
        exercises.add("Sit-up");
        exercises.add("Squat");
        exercises.add("Plank");

        // Inisialisasi ListView
        ListView listViewExercises = findViewById(R.id.listViewExercises);

        // Membuat dan mengatur adapter
        ExerciseAdapter adapter = new ExerciseAdapter(this, exercises);
        listViewExercises.setAdapter(adapter);
    }
}

