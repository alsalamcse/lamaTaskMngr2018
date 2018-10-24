package com.sholi.lama.lamataskmngr2018.taskfragments;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.sholi.lama.lamataskmngr2018.R;

public class AddTaskActivity extends AppCompatActivity {
private EditText etText,etTitle,etDueDate;
private SeekBar skbrImportnat,skbrNercessary;
private Button btnSave,btnDastePicker;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle=findViewById(R.id.etTitle);
        etText=findViewById(R.id.etText);
        etDueDate=findViewById(R.id.etDueDate);
        skbrImportnat=findViewById(R.id.skbrImportant);
        skbrNercessary=findViewById(R.id.skbrNercessary);
        btnSave=findViewById(R.id.btnSave);
        btnDastePicker=findViewById(R.id.btnDatePicker);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDastePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
