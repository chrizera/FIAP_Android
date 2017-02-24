package com.example.logonrm.tabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textNumber1;
    private TextView textNumber2;
    private EditText textAnswer;
    private ImageView[] garrafas = new ImageView[4];
    private int placar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textNumber1 = (TextView) findViewById(R.id.textNumber1);
        this.textNumber2 = (TextView) findViewById(R.id.textNumber2);
        this.textAnswer = (EditText) findViewById(R.id.textAnswer);
        this.garrafas[0] = (ImageView) findViewById(R.id.imgGarrafa0);
        this.garrafas[1] = (ImageView) findViewById(R.id.imgGarrafa1);
        this.garrafas[2] = (ImageView) findViewById(R.id.imgGarrafa2);
        this.garrafas[3] = (ImageView) findViewById(R.id.imgGarrafa3);
        placar = 0;

        sortear();
    }

    public void conferir(View v) {
        int answer = Integer.parseInt(this.textAnswer.getText().toString());
        int number1 = Integer.parseInt(this.textNumber1.getText().toString());
        int number2 = Integer.parseInt(this.textNumber2.getText().toString());

        if(answer == number1*number2) {
            garrafas[placar].setImageResource(android.R.drawable.screen_background_light_transparent);
            placar += 1;
            garrafas[placar].setImageResource(R.drawable.garrafa);

            if(placar == (garrafas.length - 1)) {
                garrafas[placar].setImageResource(android.R.drawable.screen_background_light_transparent);
                placar = 0;
                garrafas[placar].setImageResource(R.drawable.garrafa);
            }
        }
        sortear();
    }

    public void sortear() {
        Random randomNumber = new Random();
        int number1 = randomNumber.nextInt(9) + 1;
        int number2 = randomNumber.nextInt(9) + 1;
        this.textNumber1.setText(String.valueOf(number1));
        this.textNumber2.setText(String.valueOf(number2));
    }
}
