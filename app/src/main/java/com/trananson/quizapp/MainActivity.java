package com.trananson.quizapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button changeColorButton;
    Button incrementButton;
    EditText responseText;
    TextView displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        changeColorButton = findViewById(R.id.colorButton);
        incrementButton = findViewById(R.id.incrButton);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldCount = incrementButton.getText().toString();
                String newCount = Integer.toString(Integer.parseInt(oldCount) + 1);
                incrementButton.setText(newCount);
            }
        });
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color= ((int)(Math.random()*16777215)) | (0xFF << 24);
                changeColorButton.setBackgroundColor(color);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello mom");
                Log.i("testButton","Hi dad! "+responseText.getText());
                displayText.setText("Hello "+responseText.getText() + "!");
            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(responseText.getText().toString().equals("TJ")){
                        displayText.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name.");
                    }
                }
            }
        });
    }
}
