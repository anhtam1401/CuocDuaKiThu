package com.example.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    ImageButton ibtnPlay;
    CheckBox cbNobita, cbShuka, cbDoraemon;
    SeekBar skNobita, skShuka, skDraemon;
    int sodiem =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        skNobita.setEnabled(false);
        skShuka.setEnabled(false);
        skDraemon.setEnabled(false);

        txtDiem.setText(sodiem + "");

        CountDownTimer countDownTimer =new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int Nobita = random.nextInt(number);
                int Shuka = random.nextInt(number);
                int Doraemon = random.nextInt(number);

                if(skNobita.getProgress() >= skNobita.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Nobita win", Toast.LENGTH_SHORT).show();
                    if (cbNobita.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đã thua", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableCheckBox();
                }

                if(skShuka.getProgress() >= skShuka.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Shuka win", Toast.LENGTH_SHORT).show();
                    if (cbShuka.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đã thua", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableCheckBox();
                }

                if(skDraemon.getProgress() >= skDraemon.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Draemon win", Toast.LENGTH_SHORT).show();
                    if (cbDoraemon.isChecked()){
                        sodiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đã chiến thắng", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đã thua", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(sodiem + "");
                    EnableCheckBox();
                }


                skNobita.setProgress(skNobita.getProgress() + Nobita);
                skShuka.setProgress(skShuka.getProgress() + Shuka);
                skDraemon.setProgress(skDraemon.getProgress() + Doraemon);

            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbNobita.isChecked() || cbShuka.isChecked() || cbDoraemon.isChecked()) {
                    skNobita.setProgress(0);
                    skShuka.setProgress(0);
                    skDraemon.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    DisableCheckBox();
                    countDownTimer.start();

                }
                else {
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbNobita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbShuka.setChecked(false);
                    cbDoraemon.setChecked(false);
                }
            }
        });
        cbShuka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbNobita.setChecked(false);
                    cbDoraemon.setChecked(false);
                }
            }
        });
        cbDoraemon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbShuka.setChecked(false);
                    cbNobita.setChecked(false);
                }
            }
        });
    }

    private  void EnableCheckBox(){
        cbNobita.setEnabled(true);
        cbShuka.setEnabled(true);
        cbDoraemon.setEnabled(true);
    }

    private  void DisableCheckBox(){
        cbNobita.setEnabled(false);
        cbShuka.setEnabled(false);
        cbDoraemon.setEnabled(false);
    }

    private  void Anhxa(){
        txtDiem      = (TextView) findViewById(R.id.textviewDiemso);
        ibtnPlay     = (ImageButton) findViewById(R.id.buttonPlay);
        cbNobita     = (CheckBox)  findViewById(R.id.checkboxNobita);
        cbShuka      = (CheckBox)  findViewById(R.id.checkboxShuka);
        cbDoraemon   = (CheckBox)  findViewById(R.id.CheckboxDoraemon);
        skNobita     = (SeekBar) findViewById(R.id.seekbarNobita);
        skShuka      = (SeekBar) findViewById(R.id.seekbarShuka);
        skDraemon    = (SeekBar) findViewById(R.id.seekbarDoraemon);
    }
}