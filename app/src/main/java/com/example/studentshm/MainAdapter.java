package com.example.studentshm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    ArrayList<SomeClass> data;
    int dataSize;

    IonTextClick listener;

    public MainAdapter(){
        data = new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            SomeClass someClass = new SomeClass();
            someClass.position = i;
            someClass.name = "New";
            someClass.surname = "Student";
            someClass.group = "group";
            data.add(someClass);

        }
    }

    public void change(SomeClass someClass){
        data.set(someClass.position, someClass);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder holder = new MainViewHolder(v);
        holder.listener = listener;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(data.get(position));


    }

    @Override
    public int getItemCount() {
        return dataSize;
    }

    public void addStudents() {
        dataSize++;
    }
}
