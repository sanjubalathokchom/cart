package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MakePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        TextView totalamount = (TextView) findViewById(R.id.amount);
       String totalPrice = getIntent().getStringExtra("totalPrice");
        String totalQuantity = getIntent().getStringExtra("totalQuantity");
        totalamount.setText(totalPrice);
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
               // Intent intent = new Intent(MakePayment.this, MainActivity.class);
               // startActivity(intent);
            }
        });

        // Display the selected item's text in a TextView

        Button gpay = (Button) findViewById(R.id.google_pay);
        Button paytm = (Button) findViewById(R.id.Paytm);
        Button phpay = (Button) findViewById(R.id.Phone_pay);
        Button pay = (Button) findViewById(R.id.PAY);
        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakePayment.this, SuccesfullyBooked.class);
                startActivity(intent);
            }
        });

    paytm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MakePayment.this, SuccesfullyBooked.class);
            startActivity(intent);
        }
    });
        phpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakePayment.this, SuccesfullyBooked.class);
                startActivity(intent);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakePayment.this, SuccesfullyBooked.class);
                startActivity(intent);
            }
        });
    }
}
