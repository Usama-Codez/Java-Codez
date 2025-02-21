package com.example.counterapp.intentExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.counterapp.R;
import com.google.android.material.snackbar.Snackbar;

public class counter extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter);
        textView = findViewById(R.id.increment);
        textView2 = findViewById(R.id.next);

        textView.setText("0");
        textView2.setText("A");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void addOne(View view){
        int currentVal = Integer.parseInt(String.valueOf(textView.getText()));
        int newValue = currentVal + 1;
        textView.setText(String.valueOf(newValue));
    }

    public void Alpha(View view){
        String currentText = textView2.getText().toString();

        // If it's empty, start from 'A'
        if (currentText.isEmpty()) {
            textView2.setText("A");
            return;
        }

        // Get the last character and increment it
        char lastChar = currentText.charAt(0);

        // If it's 'Z', wrap around to 'A'
        if (lastChar >= 'A' && lastChar < 'Z') {
            textView2.setText(String.valueOf((char) (lastChar + 1)));
        } else if (lastChar == 'Z') {
            textView2.setText("A"); // Reset to 'A' after 'Z'
        }

    }

    public void Send_Data_To_SecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key1", "50");
        intent.putExtra("key2", "20");
        startActivity(intent);

    }

    public void Show_Toast(View view) {
        /*Toast.makeText(this,
                "My Toast",
                Toast.LENGTH_SHORT).show();*/
        Snackbar.make(view, "My Toast", Snackbar.LENGTH_SHORT).show();
    }
}