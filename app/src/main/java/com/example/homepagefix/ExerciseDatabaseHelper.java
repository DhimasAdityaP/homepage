package com.example.homepagefix;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExerciseDatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "exercise_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_EXERCISES = "exercises";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";

    public ExerciseDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_EXERCISES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }

    public long addExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, exercise.getName());
        values.put(COLUMN_DATE, exercise.getDate());
        values.put(COLUMN_TIME, exercise.getTime());
        long id = db.insert(TABLE_EXERCISES, null, values);
        db.close();
        return id;
    }

    public Cursor getAllExercises() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_EXERCISES, null, null, null, null, null, COLUMN_DATE + " DESC");
    }
}


