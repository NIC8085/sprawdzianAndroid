package com.example.android_podstawy_sprawdzian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button oblicz = findViewById(R.id.button);
        EditText a = findViewById(R.id.editTextNumberDecimalA);
        EditText b = findViewById(R.id.editTextNumberDecimalB);
        EditText c = findViewById(R.id.editTextNumberDecimalC);
        EditText textView = findViewById(R.id.editTextText2);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a.getText().toString()=="" || b.getText().toString()=="" || c.getText().toString()==""){
                    textView.setText("Nie podano wszystkich wartości");
                }
                else{
                    double aValue = Double.parseDouble(a.getText().toString());
                    double bValue = Double.parseDouble(b.getText().toString());
                    double cValue = Double.parseDouble(c.getText().toString());
                    double delta=(bValue*bValue)-4*(aValue*cValue);
                    if (delta>0){
                        String wynik = "X1 = " + (((-1)*bValue+Math.sqrt(delta))/(2*aValue)) + "  X2 = "+ (((-1)*bValue+Math.sqrt(delta))/(2*aValue));
                        textView.setText(wynik);
                    }
                    else if (delta==0) {
                        String wynik = "X = " + ((-1)*bValue/(2*aValue));
                        textView.setText(wynik);
                    }
                    else{
                        textView.setText("Brak rozwiązań");
                    }
                }

            }
        });
    }
}