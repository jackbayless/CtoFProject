package com.example.ctofconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ctofconverter.Utils.Converters;
import com.example.ctofconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater()); //gets reference to everything in XML file as a java object
        View view = binding.getRoot(); // object representation of the screen

        setContentView(view);

        binding.CtoFTitleTextView.setOnClickListener(new View.OnClickListener() { // creating an inner class that implements an on click listener
            @Override
            public void onClick(View v) { // defining what happens when this is clicked
                Toast.makeText(MainActivity.this, "Hey... it worked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void cToFConversion(View v) {

        String enteredValue = binding.CelsiusValueEditTextNumberSigned.getText().toString();
        double valueToConvert = 0;
        if (!enteredValue.isEmpty()) {
            valueToConvert = Double.parseDouble(enteredValue);
        }
        valueToConvert = Converters.celsiusToFahrenheit(valueToConvert);
        binding.celsiusConvertedValueTextView.setText(
                getString(R.string.degrees_fahrenheit, valueToConvert)
                // R is built in object that allows to access resources (res folder)
        );

    }




}