package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    //(18 Mei 2021, 10118043, Dian Rosa Pratama, IF-01)
    private String[] SubjectValues;
    private int[] SubjectValuesImage;
    private Context context;



    public AdapterRecyclerView(String[] subjectValues, int[] subjectValuesImage, Context context) {
        SubjectValues = subjectValues;
        SubjectValuesImage = subjectValuesImage;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        ViewHolder(View v) {

            super(v);
            imageView = v.findViewById(R.id.imageItem);
            textView = v.findViewById(R.id.textItem);
        }
    }


    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValues[position]);
        holder.imageView.setImageResource(SubjectValuesImage[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }
}