package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize Button in java code via findViewById method in RelativeLayout
        final Button calculateButton = this.findViewById(R.id.calculateButton);

        // initialize editable Text fields for calculation
        final EditText heightText = this.findViewById(R.id.editHeightNumber);
        final EditText weightText = this.findViewById(R.id.editWeightNumber);

        // Result text field initialization
        EditText result = this.findViewById(R.id.editTextResultDecimal);

        // create onClickListener for calculate Button Method
        calculateButton.setOnClickListener(v -> {
            // Initialization string.length of weight & height from EditText fields
            int weightLength = weightText.getText().length();
            int heightLength = heightText.getText().length();

            // Crash prevention through asserting string.length > 0
            if (weightLength < 1 || heightLength < 1) {
                result.setText(R.string.errorText);
            } else {
                // BMI = Weight : (Height)²
                double weightParsed = Double.parseDouble(weightText.getText().toString());
                double heightParsed = Double.parseDouble(heightText.getText().toString());
                double bmiResult = weightParsed / (heightParsed * heightParsed / 100) * 100;
                int finalResult = (int) Math.ceil(bmiResult);
                result.setText(MessageFormat.format("Your calculated BMI: {0}", finalResult));
            }
            // sets invisibility of field result to visible
            result.setVisibility(View.VISIBLE);
        });
    }
}