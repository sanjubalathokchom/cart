package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SuccesfullyBooked extends AppCompatActivity {
    private TextView movieName, date, time, theater;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succesfully_booked);

        // Initialize EditText fields
        movieName = findViewById(R.id.Movie_name);
        date = findViewById(R.id.Date);
        time = findViewById(R.id.Time);
        theater = findViewById(R.id.Theater);

        // Back button
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  finish();
               // Intent intent = new Intent(SuccesfullyBooked.this, MakePayment.class);
                //startActivity(intent);
            }
        });
        // Create a SimpleDateFormat to format the date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        // Get the current date and time
        Date currentDateAndTime = new Date();

        // Format the date and time and set them in the TextViews
        String formattedDate = dateFormat.format(currentDateAndTime);
        String formattedTime = timeFormat.format(currentDateAndTime);

        date.setText("Date: " + formattedDate);
        time.setText("Time: " + formattedTime);
    }
}