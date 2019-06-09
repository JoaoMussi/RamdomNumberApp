package com.example.random_app_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer randomNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btRandom = findViewById(R.id.random);
        btRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNum();
            }
        });
    }

    public void generateRandomNum() {

        Random r = new Random();

        EditText maxElm = findViewById(R.id.maxValue);
        EditText minElm = findViewById(R.id.minValue);
        TextView result = findViewById(R.id.randomNumElm);

        Integer max = Integer.parseInt(maxElm.getText().toString().equals("") ?  "0" : maxElm.getText().toString());
        Integer min = Integer.parseInt(minElm.getText().toString().equals("") ?  "0" : minElm.getText().toString());

        try {
            this.randomNum = r.nextInt(max - min + 1) + min;
            result.setText(this.randomNum.toString());
        } catch (Exception e) {
            result.setText("O primeiro número deve ser menor que o segundo");
        }
    }
}
