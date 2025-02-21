package com.example.counterapp.intentExample;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AlertDialogue extends AppCompatActivity {

    TextView textView;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialogue);
        textView = findViewById(R.id.alertText);

        textView.setText(String.valueOf(count));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void OpenAlertDialogue(View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(AlertDialogue.this);
        builder.setMessage("Are you MAD?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogue.this, "Great, Verified", Toast.LENGTH_SHORT).show();
                        textView.setText("0");
                    }
                })
                .setNegativeButton("Off course", null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}