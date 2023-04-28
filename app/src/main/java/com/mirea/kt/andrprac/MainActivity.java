package com.mirea.kt.andrprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("AndrPrac_tag", "STARTED! :)");
        Button buttonCalculate = findViewById(R.id.btnCalculate);
        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("AndrPrac_tag", "Calculate Button click");
        TextView result = findViewById(R.id.textViewResult);
        result.setText("Результат: ");
        EditText editTextDeposit = findViewById(R.id.editTextDeposit);
        EditText editTextAnnPercent = findViewById(R.id.editTextAnnPercent);
        EditText editTextDepositTerm = findViewById(R.id.editTextDepositTerm);
        try {
            double deposit = Double.valueOf(editTextDeposit.getText().toString());
            double depTerm = Double.valueOf(editTextDepositTerm.getText().toString());
            double annPerc = Double.valueOf(editTextAnnPercent.getText().toString());
            for (int i = 1; i <= depTerm; i++)
            {
                deposit += deposit*((annPerc/100.0)/12.0);
            }
            result.setText(result.getText().toString()  + deposit);
        }catch (NumberFormatException e ){
            result.setText("Неверные значения, попробуйте ещё раз.");
        }




    }
}