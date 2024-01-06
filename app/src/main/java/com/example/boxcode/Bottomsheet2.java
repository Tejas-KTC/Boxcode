package com.example.boxcode;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class Bottomsheet2 extends BottomSheetDialogFragment {
    public Bottomsheet2() {
    }

    private OpenHelper2 dbHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.row_add_item,container,false);

        Button btnadd=view.findViewById(R.id.new_add_task_btn);
        EditText ed= view.findViewById(R.id.new_add_task_name);
        EditText ed1 = view.findViewById(R.id.new_add_task_des);
        TextView selecttime = view.findViewById(R.id.idTVSelectedTime);
        TextView selecttime2 = view.findViewById(R.id.idTVSelectedTime2);
        TextView timepicker = view.findViewById(R.id.idBtnPickTime);
        TextView timepicker2 = view.findViewById(R.id.idBtnPickTime2);

        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting the
                // instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting our hour, minute.
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                        selecttime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        timepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                        selecttime2.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });


        dbHandler = new OpenHelper2(getContext());
        btnadd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String courseName = ed.getText().toString();
                String courseDescription = ed1.getText().toString();

                if (courseName.isEmpty() && courseDescription.isEmpty()) {
                    Toast.makeText(getContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCourse(courseName,courseDescription,selecttime.getText().toString(),selecttime2.getText().toString());

                Toast.makeText(getContext(), "Course has been added.", Toast.LENGTH_SHORT).show();
                ed.setText("");
                ed1.setText("");
                selecttime.setText("00:00");
                selecttime2.setText("00:00");

            }
        });

        return view;
    }
}
