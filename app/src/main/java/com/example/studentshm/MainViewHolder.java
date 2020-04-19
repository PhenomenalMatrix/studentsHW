package com.example.studentshm;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private SomeClass someClass;
    IonTextClick listener;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.vh_text_view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTextClick(someClass);
            }
        });
    }

    public void onBind(SomeClass someClass){
        this.someClass = someClass;
        Log.d("olo", someClass.name + someClass.position);
        textView.setText(someClass.name + " " + someClass.surname);
    }
}
