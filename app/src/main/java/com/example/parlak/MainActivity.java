package com.example.parlak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekbar;
    TextView tv_bar_value;
    int bright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = findViewById(R.id.seekbar_brightness);
        tv_bar_value = findViewById(R.id.seekbar_value);

        updateScreenBrightness();
        seekbar.setOnSeekBarChangeListener(bar_listener);
    }

    private SeekBar.OnSeekBarChangeListener bar_listener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateScreenBrightness();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void updateScreenBrightness() {
        bright = seekbar.getProgress();
        int yuzde =bright +1;
        tv_bar_value.setText("% " + yuzde);

        float Lightvalue = (float)(bright+1)/100;

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = Lightvalue;
        getWindow().setAttributes(layoutParams);
    }
}
