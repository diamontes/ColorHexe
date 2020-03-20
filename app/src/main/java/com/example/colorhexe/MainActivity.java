package com.example.colorhexe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randValueRed = 0;
    int randValueGreen = 0;
    int randValueBlue = 0;

    public void setTextColor(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View MyView = (View)findViewById(R.id.vMain);
        final SeekBar sbRed = (SeekBar)findViewById(R.id.sbRed);
        final SeekBar sbGreen = (SeekBar)findViewById(R.id.sbGreen);
        final SeekBar sbBlue = (SeekBar)findViewById(R.id.sbBlue);
        final Button btnColor = (Button)findViewById(R.id.btnColor);
        final TextView tvRed = (TextView)findViewById(R.id.tvRedDez);
        final TextView tvGreen = (TextView)findViewById(R.id.tvGreenDez);
        final TextView tvBlue = (TextView)findViewById(R.id.tvBlueDez);
        final TextView tvRedButton = (TextView)findViewById(R.id.tvRedDezBtn);
        final TextView tvGreenButton = (TextView)findViewById(R.id.tvGreenDezBtn);
        final TextView tvBlueButton = (TextView)findViewById(R.id.tvBlueDezBtn);
        final Switch swShowHints = (Switch)findViewById(R.id.swShowHints);

        MyView.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));

        swShowHints.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    tvRedButton.setText(String.valueOf(randValueRed));
                    tvGreenButton.setText(String.valueOf(randValueGreen));
                    tvBlueButton.setText(String.valueOf(randValueBlue));

                    int difRed = Math.abs(randValueRed - sbRed.getProgress());
                    int difGreen = Math.abs(randValueGreen - sbGreen.getProgress());
                    int difBlue = Math.abs(randValueBlue - sbBlue.getProgress());

                    double avgDif = Math.round(((((difRed + difGreen + difBlue)/3.0)-sbRed.getMin())/(sbRed.getMax()-sbRed.getMin()))*100.0);

                    btnColor.setText(Double.toString(avgDif) + "% " + "daneben");

                }
                else{
                    tvRedButton.setText("###");
                    tvGreenButton.setText("###");
                    tvBlueButton.setText("###");
                    btnColor.setText("Push me again!");
                }
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                randValueRed = new Random().nextInt(256);
                randValueGreen = new Random().nextInt(256);
                randValueBlue = new Random().nextInt(256);

                btnColor.setBackgroundColor(Color.rgb(randValueRed, randValueGreen, randValueBlue));

                swShowHints.setChecked(false);

                int rgb = randValueRed;
                rgb = (rgb << 8) + randValueGreen;
                rgb = (rgb << 8) + randValueBlue;

                btnColor.setTextColor(0xFFFFFFFF - rgb);

            }
        });

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MyView.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));
                tvRed.setText(String.valueOf(sbRed.getProgress()) + " | " + Integer.toString(Integer.valueOf(sbRed.getProgress()), 16));

                int rgbtvRed = sbRed.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbGreen.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbBlue.getProgress();

                tvRed.setTextColor(0xFFFFFFFF - rgbtvRed);

                int rgbtvGreen = sbRed.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbGreen.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbBlue.getProgress();

                tvGreen.setTextColor(0xFFFFFFFF - rgbtvGreen);

                int rgbtvBlue = sbRed.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbGreen.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbBlue.getProgress();

                tvBlue.setTextColor(0xFFFFFFFF - rgbtvBlue);


                int rgbtvRedButton = sbRed.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbGreen.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbBlue.getProgress();

                tvRedButton.setTextColor(0xFFFFFFFF - rgbtvRedButton);

                int rgbtvGreenButton = sbRed.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbGreen.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbBlue.getProgress();

                tvGreenButton.setTextColor(0xFFFFFFFF - rgbtvGreenButton);

                int rgbtvBlueButton = sbRed.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbGreen.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbBlue.getProgress();

                tvBlueButton.setTextColor(0xFFFFFFFF - rgbtvBlueButton);

                int rgbsbRed = sbRed.getProgress();
                rgbsbRed = (rgbsbRed << 8) + sbGreen.getProgress();
                rgbsbRed = (rgbsbRed << 8) + sbBlue.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MyView.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));
                tvGreen.setText(String.valueOf(sbGreen.getProgress()) + " | " + Integer.toString(Integer.valueOf(sbGreen.getProgress()), 16));

                int rgbtvRed = sbRed.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbGreen.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbBlue.getProgress();

                tvRed.setTextColor(0xFFFFFFFF - rgbtvRed);

                int rgbtvGreen = sbRed.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbGreen.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbBlue.getProgress();

                tvGreen.setTextColor(0xFFFFFFFF - rgbtvGreen);

                int rgbtvBlue = sbRed.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbGreen.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbBlue.getProgress();

                tvBlue.setTextColor(0xFFFFFFFF - rgbtvBlue);


                int rgbtvRedButton = sbRed.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbGreen.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbBlue.getProgress();

                tvRedButton.setTextColor(0xFFFFFFFF - rgbtvRedButton);

                int rgbtvGreenButton = sbRed.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbGreen.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbBlue.getProgress();

                tvGreenButton.setTextColor(0xFFFFFFFF - rgbtvGreenButton);

                int rgbtvBlueButton = sbRed.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbGreen.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbBlue.getProgress();

                tvBlueButton.setTextColor(0xFFFFFFFF - rgbtvBlueButton);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MyView.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));
                tvBlue.setText(String.valueOf(sbBlue.getProgress()) + " | " + Integer.toString(Integer.valueOf(sbBlue.getProgress()), 16));

                int rgbtvRed = sbRed.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbGreen.getProgress();
                rgbtvRed = (rgbtvRed << 8) + sbBlue.getProgress();

                tvRed.setTextColor(0xFFFFFFFF - rgbtvRed);

                int rgbtvGreen = sbRed.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbGreen.getProgress();
                rgbtvGreen = (rgbtvGreen << 8) + sbBlue.getProgress();

                tvGreen.setTextColor(0xFFFFFFFF - rgbtvGreen);

                int rgbtvBlue = sbRed.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbGreen.getProgress();
                rgbtvBlue = (rgbtvBlue << 8) + sbBlue.getProgress();

                tvBlue.setTextColor(0xFFFFFFFF - rgbtvBlue);


                int rgbtvRedButton = sbRed.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbGreen.getProgress();
                rgbtvRedButton = (rgbtvRedButton << 8) + sbBlue.getProgress();

                tvRedButton.setTextColor(0xFFFFFFFF - rgbtvRedButton);

                int rgbtvGreenButton = sbRed.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbGreen.getProgress();
                rgbtvGreenButton = (rgbtvGreenButton << 8) + sbBlue.getProgress();

                tvGreenButton.setTextColor(0xFFFFFFFF - rgbtvGreenButton);

                int rgbtvBlueButton = sbRed.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbGreen.getProgress();
                rgbtvBlueButton = (rgbtvBlueButton << 8) + sbBlue.getProgress();

                tvBlueButton.setTextColor(0xFFFFFFFF - rgbtvBlueButton);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
