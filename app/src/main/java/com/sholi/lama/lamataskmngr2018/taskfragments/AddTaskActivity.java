package com.sholi.lama.lamataskmngr2018.taskfragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sholi.lama.lamataskmngr2018.R;
import com.sholi.lama.lamataskmngr2018.data.MyTask;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {
private EditText etText,etTitle,etDueDate;
private SeekBar skbrImportnat,skbrNercessary;
private Button btnSave,btnDastePicker;
private TextView tvImportant,tvNercessary;
private int mYear,mMonth,mDay;


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
                dataHandler();

            }
        });
        btnDastePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }

    private void dataHandler() {
        boolean isok = true;

        final String Text = etText.getText().toString();
        String Title = etTitle.getText().toString();
        String DueDate = etDueDate.getText().toString();
        int Important = skbrImportnat.getProgress();
        int Nercessary = skbrNercessary.getProgress();
        if (Title.length() < 4) {
            etTitle.setError("Title have to be than 4 Char");
            isok = false;
        }
        if (Text.length() < 4) {
            etText.setError("Text have to be than 4 Char");
            isok = false;
        }
        if (DueDate.length() < 4) {
            etDueDate.setError("DueDate have to be than 4 Char");
            isok = false;
        }
        if (isok) {
            MyTask task = new MyTask();
            task.setCreatedAt(new Date());
            task.setDueDate(new Date(DueDate));
            task.setText(Text);
            task.getTitle(Title);
            task.setImportant(Important);
            task.getNecessary(Nercessary);

            FirebaseAuth auth = FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());
            DatabaseReference refrence = FirebaseDatabase.getInstance().getReference();
            String key = refrence.child("MyTasks").push().getKey();
            task.setKey(key);
            refrence.child("MyTasks").child(key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if ((task.isSuccessful())){
                        Toast.makeText(AddTaskActivity.this, "add Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(AddTaskActivity.this, "Add Faild", Toast.LENGTH_SHORT).show();
                    }

                }
            });


            }

    }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onClick(View v){
        if (v==btnDastePicker){
            final Calendar c=Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDateSet(DatePicker datePicker, int Year, int monthOfYear, int dayOfMonth) {
                    etDueDate.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+mYear);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
        }



}

