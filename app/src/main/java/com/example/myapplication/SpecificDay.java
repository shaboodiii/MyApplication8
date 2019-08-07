package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpecificDay extends AppCompatActivity {

    private TextView textView;

    GridView gridView;
    ArrayList<Exercise> list;
    ExerciseListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);

        Intent incomingIntent = getIntent();
        String date = ((Intent) incomingIntent).getStringExtra("date");

        gridView = (GridView)findViewById(R.id.id_grid);
        list = new ArrayList<>();
        adapter = new ExerciseListAdapter(this, R.layout.exercise_items, list);
        gridView.setAdapter(adapter);

        //get all data from sqlite

        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM EXERCISE");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String time = cursor.getString(1);
            String comment = cursor.getString(2);
            byte[] image = cursor.getBlob(4);

            list.add(new Exercise(id, time, comment, image));
        }
        adapter.notifyDataSetChanged();

    }
}
