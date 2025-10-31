package com.example.ctofconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ctofconverter.Utils.Converters;
import com.example.ctofconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String CONVERTED_VALUE_EXTRA_KEY = "MainActivity_Converted_value_double";

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

        binding.celsiusConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = FtoCActivity.fToCIntentFactory(getApplicationContext(), convertValue());
                startActivity(intent);
                return false;
            }
        });
    }

    private double convertValue() {
        String enteredValue = binding.CelsiusValueEditTextNumberSigned.getText().toString();
        double valueToConvert = 0;
        if (!enteredValue.isEmpty()) {
            valueToConvert = Double.parseDouble(enteredValue);
        }
        valueToConvert = Converters.celsiusToFahrenheit(valueToConvert);

        return valueToConvert;
    }

    public void displayConvertedValue(View v) {

        binding.celsiusConvertedValueTextView.setText(
                getString(R.string.degrees_fahrenheit, convertValue())
                // R is built in object that allows to access resources (res folder)
        );
    }

    public static Intent MainActivityIntentFactory(Context context, double receivedValue) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, receivedValue);
        return intent;
    }


}