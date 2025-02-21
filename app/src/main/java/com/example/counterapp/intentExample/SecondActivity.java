package com.example.counterapp.intentExample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.counterapp.R;

public class SecondActivity extends AppCompatActivity {

    TextView txtValue1, txtValue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        txtValue1 = findViewById(R.id.txtintentvalue1);
        txtValue2 = findViewById(R.id.txtintentvalue2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        int value1 = intent.getIntExtra("key1", 0);
        int value2 = intent.getIntExtra("key2", 0);
        txtValue1.setText(String.valueOf(value1));
        txtValue2.setText(String.valueOf(value2));
    }
}