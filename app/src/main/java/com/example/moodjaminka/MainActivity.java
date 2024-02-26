package com.example.moodjaminka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text1, text2;
    Button btn;
    LottieAnimationView anim1, anim2,anim3;
    int otvetInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        anim1 = findViewById(R.id.lottie1);
        anim2 = findViewById(R.id.lottie2);
        anim1.setAnimation(R.raw.animate);
        anim2.setAnimation(R.raw.animation2);
        anim3.setAnimation(R.raw.animation3);
        btn = findViewById(R.id.btn);
        setListeners();
    }

    private void setListeners() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Random random = new Random();
        otvetInt = random.nextInt(100);
        if ((otvetInt != 0) && (otvetInt > 0)) {
            text2.setText(String.valueOf(otvetInt) + " %");
            printAnswer();

        }
    }

    private void printAnswer()
    {
        if(otvetInt>=1 && otvetInt<=48){
            String str = Integer.toString(otvetInt);
            text2.setText(str+"% "+"У вас все не очень хорошо");
            anim2.setVisibility(View.INVISIBLE);
            anim1.setVisibility(View.INVISIBLE);
            anim3.setVisibility(View.VISIBLE);
        }else if(otvetInt>=48 && otvetInt<=68){
            String str = Integer.toString(otvetInt);
            text2.setText(str+"% "+"У вас нормальное настроение");
            anim2.setVisibility(View.INVISIBLE);
            anim3.setVisibility(View.INVISIBLE);
            anim1.setVisibility(View.VISIBLE);
        }
        else if(otvetInt>=68 && otvetInt<=100){
            String str = Integer.toString(otvetInt);
            text2.setText(str+"% "+"У вас шикарное настроение");
            anim3.setVisibility(View.INVISIBLE);
            anim1.setVisibility(View.INVISIBLE);
            anim2.setVisibility(View.VISIBLE);
        }
    }
}