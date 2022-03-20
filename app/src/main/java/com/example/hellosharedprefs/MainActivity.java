package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnPink, btnSalmon, btnBrown, btnPlum, btnCount, btnReset, btnSave;
    int i = 0;
    String currentColor = "#FFFFFF";
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = getSharedPreferences("helloSharePrefs", Context.MODE_PRIVATE);
        textView = findViewById(R.id.textView);
        btnCount = findViewById(R.id.btnCount);
        btnBrown = findViewById(R.id.btnBrown);
        btnPink = findViewById(R.id.btnPink);
        btnSalmon = findViewById(R.id.btnSalmon);
        btnPlum = findViewById(R.id.btnPlum);
        btnSave = findViewById(R.id.btnSave);
        btnReset = findViewById(R.id.btnReset);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                textView.setText(String.valueOf(i));
            }
        });
        btnBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#B22222"));
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                currentColor = "#B22222";
            }
        });

        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#FF69B4"));
                currentColor = "#FF69B4";
            }
        });

        btnPlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#DDA0DD"));
                currentColor = "#DDA0DD";
            }
        });

        btnSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(Color.parseColor("#FFA07A"));
                currentColor = "#FFA07A";
            }
        });

           i = mPreferences.getInt("count", 0);
           textView.setText(String.valueOf(i));
           currentColor = mPreferences.getString("color", currentColor);
           textView.setBackgroundColor(Color.parseColor(currentColor));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putInt("count", i);
                editor.putString("color", currentColor);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.remove("count");
                editor.remove("color");
                editor.apply();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

}