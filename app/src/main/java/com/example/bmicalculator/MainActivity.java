package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BMI = Weight : (Height)²
                double weightParsed = Double.parseDouble(weightText.getText().toString());
                double heightParsed = Double.parseDouble(heightText.getText().toString());
                double bmiResult = weightParsed / (heightParsed * heightParsed / 100) * 100;
                int finalResult = (int) Math.ceil(bmiResult);
                result.setText("Your calculated BMI: " + finalResult);
                result.setVisibility(View.VISIBLE);
            }
        });
    }
}