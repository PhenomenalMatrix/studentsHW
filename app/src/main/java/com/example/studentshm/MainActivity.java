package com.example.studentshm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements IonTextClick {

    static String RESULT_KEY = "result_key";
    MainAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MainAdapter();
        adapter.listener = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        final Button create = findViewById(R.id.main_button_create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createStudent();
            }
        });

    }

    private void createStudent() {
        adapter.addStudents();
        adapter.notifyDataSetChanged();
    }

    public void open2Activity(SomeClass someClass){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra(Main2Activity.TEXT_KEY, someClass);
        startActivityForResult(intent, 42);
    }

    @Override
    public void onTextClick(SomeClass someClass) {
        open2Activity(someClass);
    }

    void changeData (SomeClass someClass){
        adapter.change(someClass);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SomeClass someClass = (SomeClass) data.getSerializableExtra(RESULT_KEY);
        changeData(someClass);
    }
}
