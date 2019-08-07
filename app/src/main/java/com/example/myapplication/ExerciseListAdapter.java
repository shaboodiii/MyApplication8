package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ExerciseListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Exercise> exerciseList;

    public ExerciseListAdapter(Context context, int layout, ArrayList<Exercise> exerciseList) {
        this.context = context;
        this.layout = layout;
        this.exerciseList = exerciseList;
    }

    @Override
    public int getCount() {
        return exerciseList.size();
    }

    @Override
    public Object getItem(int position) {
        return exerciseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView time, comment;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.time = (TextView) row.findViewById(R.id.id_time);
            holder.comment = (TextView) row.findViewById(R.id.id_comment);
            holder.imageView = (ImageView) row.findViewById(R.id.image_exercise);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        Exercise exercise = exerciseList.get(position);

        holder.time.setText(exercise.getTime());
        holder.comment.setText(exercise.getComment());

        byte[] exerciseImage = exercise.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(exerciseImage, 0, exerciseImage.length);
        holder.imageView.setImageBitmap(bitmap);


        return null;
    }
}
