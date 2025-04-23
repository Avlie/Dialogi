package com.example.dialogi;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.Button1);
        Button button2 = findViewById(R.id.Button2);
        Button button3 = findViewById(R.id.Button3);
        Button button4 = findViewById(R.id.Button4);
        Button button5 = findViewById(R.id.Button5);
        Button button = findViewById(R.id.button);

        button1.setOnClickListener(v -> aboutDialog());
        button2.setOnClickListener(v -> showList());
        button3.setOnClickListener(v -> ShowDate());
        button4.setOnClickListener(v -> showTimeDialog());
        button5.setOnClickListener(v -> customDialog());




    }

    private void aboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("O aplikacji");
        builder.setMessage("To jest aplikacja z dialogami");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "Anuluj", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showList() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybiez opcje");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Wybrano:" + items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void ShowDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int viewYear, int dayOfMonth, int viewDay) {
                Toast.makeText(MainActivity.this, "Wybrano: " + dayOfMonth + "/" + (month + 1) + "/" + viewYear, Toast.LENGTH_SHORT).show();
            }

        }, year, month, day);
        datePickerDialog.show();
    }
    private void  showTimeDialog(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog TimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Wybrano: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true);
        TimePickerDialog.show();
    }
    private void customDialog() {
        final android.app.Dialog  dialog = new android.app.Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        Button button = dialog.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}