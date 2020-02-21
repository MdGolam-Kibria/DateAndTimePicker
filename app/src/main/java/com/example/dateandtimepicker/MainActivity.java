package com.example.dateandtimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.OffsetTime;

public class MainActivity extends AppCompatActivity {
    TextView viewDate;
    Button dateBtn;
    DatePicker datePicker;
    DatePickerDialog datePickerDialog;
    Button datePickerDialogbtn, timePickerBtn, dialogTime;
    TimePickerDialog timePickerDialog;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewDate = (TextView) findViewById(R.id.viewDate);
        dateBtn = (Button) findViewById(R.id.dateBtn);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePickerDialogbtn = (Button) findViewById(R.id.dilogDatebtn);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        dialogTime = (Button) findViewById(R.id.timePickerDialog);
        timePickerBtn = (Button) findViewById(R.id.timePickerBtn);

        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String h = timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                viewDate.setText(h);
            }
        });
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = datePicker.getDayOfMonth();
                int month = (datePicker.getMonth()) + 1;
                int year = datePicker.getYear();
                viewDate.setText(day + "/" + month + "/" + year);
            }
        });
        datePickerDialogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentDay = datePicker.getDayOfMonth(), currentMonth = datePicker.getMonth(), correntYear = datePicker.getYear();
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        viewDate.setText(i2 + "/" + i1 + "/" + i);
                    }
                }, currentDay, currentMonth, correntYear);
                datePickerDialog.show();
            }
        });
        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            int currenthours = timePicker.getCurrentHour();
            int currentMint = timePicker.getCurrentMinute();

            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        viewDate.setText(i + ":" + i1);
                    }
                }, currenthours, currentMint, false);
                timePickerDialog.show();
            }
        });
    }
}
