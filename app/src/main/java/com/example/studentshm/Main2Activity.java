package com.example.studentshm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public static  String TEXT_KEY = "text_key";

    EditText editTextName;
    EditText editTextSurname;
    EditText editTextGroup;
    SomeClass someClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.main2_text);
        editTextName = findViewById(R.id.main2_edit_text_name);
        editTextSurname = findViewById(R.id.main2_edit_text_surname);
        editTextGroup = findViewById(R.id.main2_edit_text_group);

        Button save = findViewById(R.id.main2_button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                someClass.name = editTextName.getText().toString();
                someClass.surname = editTextSurname.getText().toString();
                someClass.group = editTextGroup.getText().toString();
                Log.d("olo", someClass.name);
                intent.putExtra(MainActivity.RESULT_KEY, someClass);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

        if (getIntent() != null){
            someClass =(SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            editTextName.setText(someClass.name);
            editTextSurname.setText(someClass.surname);
            editTextGroup.setText(someClass.group);
        }else {
            textView.setText("Nothing to show");
        }
    }
}
