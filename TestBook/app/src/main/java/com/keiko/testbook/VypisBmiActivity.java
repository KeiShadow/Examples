package com.keiko.testbook;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VypisBmiActivity extends AppCompatActivity {
    public static final String BMI = "bmi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);

        Intent i = getIntent();
        float bmi = i.getFloatExtra(BMI,-1);
        showBmi(bmi,tv);
    }

    private void showBmi(float bmi, TextView tv) {
        Resources res = getResources();
        String text = res.getString(R.string.zobraz_bmi,bmi);
        tv.setText(text);
    }
}
