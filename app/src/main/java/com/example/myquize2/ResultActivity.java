package com.example.myquize2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ResultActivity extends AppCompatActivity {
    private Button moveTopButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int correctAnswer = intent.getIntExtra("correctAnswer", 0);
        int quizeSize = intent.getIntExtra("quizeSize", 0);

        moveTopButton = findViewById(R.id.moveTop);
        resultText = findViewById(R.id.result);

        resultText.setText(quizeSize +"問中" + correctAnswer +"問正解です");

        moveTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}