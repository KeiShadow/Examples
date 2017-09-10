package com.keiko.testbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClicked(View button) {
        int vyska = getNum(R.id.etVyska);
        int vaha = getNum(R.id.etVaha);
        if(vyska<50){
            wrongNum(R.id.etVyska);
        }else if(vaha<0){
            wrongNum(R.id.etVaha);
        }else vypocetBMI(vyska, vaha);
    }

    private void vypocetBMI(int vyska, int vaha) {
        float bmi;
        float vyskam=(float)vyska/100;
        bmi = vaha/(vyskam*vyskam);
        Intent intent = new Intent(this,VypisBmiActivity.class);
        intent.putExtra(VypisBmiActivity.BMI,bmi );
        startActivity(intent);
    }

    protected void wrongNum(int nID) {
        Toast.makeText(this,R.string.nespravne_cislo,Toast.LENGTH_LONG).show();
        EditText etVstup = ((EditText)findViewById(nID));
        etVstup.setText("");
        etVstup.requestFocus();

    }

    private int getNum(int nID) {
        EditText etVstup =((EditText)findViewById(nID));
        String strVstup = etVstup.getText().toString();
        int nCislo=-1;
        try{
            nCislo = Integer.parseInt(strVstup);
        }catch (NumberFormatException e){}
        return nCislo;

    }
}
